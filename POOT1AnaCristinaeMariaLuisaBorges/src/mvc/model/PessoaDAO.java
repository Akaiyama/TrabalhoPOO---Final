/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import mvc.control.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mb780 -> PessoaDAO - Parte 2
 */
/*
    private long id;
    private String nome;
    private String sexo;
    private LocalDate nascimento;
    private String login;
    private String senha;
    private String tipoUsuario;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
 */
public class PessoaDAO {

    //Função para adicionar pessoa
    public long adicionaERetornaId(Pessoa elemento) {
        String sql = "insert into pessoa "
                + "(nome,sexo,dataNascimento,login,senha,tipoUsuario,dataCriacao,dataModificacao)"
                + " values (?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1, elemento.getNome());
            stmt.setString(2, elemento.getSexo());
            stmt.setDate(3, java.sql.Date.valueOf(elemento.getNascimento()));
            stmt.setString(4, elemento.getLogin());
            stmt.setString(5, elemento.getSenha());
            stmt.setString(6, elemento.getTipoUsuario());
            stmt.setDate(7, java.sql.Date.valueOf(elemento.getDataCriacao()));
            stmt.setDate(8, java.sql.Date.valueOf(elemento.getDataModificacao()));

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

    //Função para mostrar todas as pessoas
    public List<Pessoa> mostrarTodos(Pessoa elemento) {
        String sql = "select * from pessoa";

        List<Pessoa> pessoas = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("idpessoa");
                String nome = rs.getString("nome");
                String sexo = rs.getString("sexo");
                Date currentDate = rs.getDate("dataNascimento");
                LocalDate dataNascimento = currentDate.toLocalDate();
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();
                
                Pessoa pessoa = new Pessoa();
                pessoa.setId(id);
                pessoa.setNome(nome);
                pessoa.setSexo(sexo);
                pessoa.setNascimento(dataNascimento);
                pessoa.setLogin(login);
                pessoa.setSenha(senha);
                pessoa.setDataCriacao(dataCriacao);
                pessoa.setDataModificacao(dataModificacao);
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pessoas;
    }

    //Função para buscar a pessoa pelo ID
    public Pessoa buscaPorID(long code) {
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = createPreparedStatement(connection, code); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("idPessoa");
                String nome = rs.getString("nome");
                String sexo = rs.getString("sexo");
                Date currentDate = rs.getDate("dataNascimento");
                LocalDate dataNascimento = currentDate.toLocalDate();
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();

                Pessoa pessoa = new Pessoa();
                pessoa.setId(id);
                pessoa.setNome(nome);
                pessoa.setSexo(sexo);
                pessoa.setNascimento(dataNascimento);
                pessoa.setLogin(login);
                pessoa.setSenha(senha);
                pessoa.setDataCriacao(dataCriacao);
                pessoa.setDataModificacao(dataModificacao);

                return pessoa;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //Config PreparedStatement
    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from pessoa where idPessoa = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    //Função para excluir a pessoa
    public Pessoa exclui(Pessoa elemento) {
        String sql = "delete from pessoa where idpessoa = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, elemento.getId());

            stmt.execute();

            System.out.println("Elemento excluido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return elemento;
    }
    
    public Pessoa altera(Pessoa elemento, String dado) {
        String sql = "update pessoa set login = ? where idpessoa = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, dado);
            stmt.setLong(2, elemento.getId());
            stmt.execute();

            System.out.println("Voce alterou seu login.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return elemento;
    }
}
