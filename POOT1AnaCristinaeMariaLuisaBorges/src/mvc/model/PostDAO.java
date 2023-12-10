/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import mvc.control.ConnectionFactory;

/**
 *
 * @author ana e maria
 */
public class PostDAO {
    //Função para adicionar POST
    public long adicionaERetornaId(Post elemento) {
        String sql = "insert into post "
                + "(idpessoaPost,postagem,dataCriacao,dataModificacao)"
                + " values (?,?,?,?)";
        
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setLong(1, elemento.getPessoa().getId());
            stmt.setString(2, elemento.getPostagem());
            stmt.setDate(3, java.sql.Date.valueOf(elemento.getDataCriacao()));
            stmt.setDate(4, java.sql.Date.valueOf(elemento.getDataModificacao()));

            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();

            int retorno = 0;
            if (rs.next()) {
                retorno = rs.getInt(1);
            }

            System.out.println("O id inserido foi: " + retorno);
            elemento.setId(retorno);

            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Função para mostrar todos os usuários e seus seguidores (todas as conexões entre usuários)
    public List<Post> mostrarTodos(Post elemento) {
        String sql = "select * from post";
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Post> posts = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("idpost");
                long idpessoa = rs.getLong("idpessoaPost");
                String postagem = rs.getString("postagem");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();
              
                Pessoa p = pessoaDAO.buscaPorID(idpessoa);
                
                Post post = new Post();
                post.setId(id);
                post.setPessoa(p);
                post.setPostagem(postagem);
                post.setDataCriacao(dataCriacao);
                post.setDataModificacao(dataModificacao);
                posts.add(post);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }

    //Função para buscar POST pelo ID
    public Post buscaPorID(long code) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        PostDAO postDAO = new PostDAO();
        
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = createPreparedStatement(connection, code); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("idpost");
                long idpessoa = rs.getLong("idpessoaPost");
                String postagem = rs.getString("postagem");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();
              
                Pessoa p = pessoaDAO.buscaPorID(idpessoa);
                
                Post post = new Post();
                post.setId(id);
                post.setPessoa(p);
                post.setPostagem(postagem);
                post.setDataCriacao(dataCriacao);
                post.setDataModificacao(dataModificacao);
                
                return post;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //Config PreparedStatement
    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from post where idpost = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    //Função para excluir POST
    public Post exclui(Post elemento) {
        String sql = "delete from post where idpost = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, elemento.getId());

            stmt.execute();

            System.out.println("Elemento excluido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return elemento;
    }
    
    public Post altera(Post elemento, String dado) {
        String sql = "update post set postagem = ? where idpessoaPost = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, dado);
            stmt.setLong(2, elemento.getId());
            stmt.execute();

            System.out.println("Voce alterou seu post.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return elemento;
    }
}
