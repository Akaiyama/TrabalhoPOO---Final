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
 * @author Ana Cristina e Maria Luísa -> SeguirDAO - Parte 2
 */
public class SeguirDAO {
     //Função para adicionar seguir
    public long adicionaERetornaId(Seguir elemento) {
        String sql = "insert into seguir "
                + "(idPessoaOrigem, idPessoaDestino,dataCriacao,dataModificacao)"
                + " values (?,?,?,?)";
        
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setLong(1, elemento.getPessoaOrigem().getId());
            stmt.setLong(2, elemento.getPessoaDestino().getId());
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
    public List<Seguir> mostrarTodos(Seguir elemento) {
        String sql = "select * from seguir";
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Seguir> seguidores = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("idSeguir");
                Long idpessoaorigem = rs.getLong("idPessoaOrigem");
                Long idpessoadestino = rs.getLong("idPessoaDestino");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();
              
                Pessoa origem = pessoaDAO.buscaPorID(idpessoaorigem);
                Pessoa destino = pessoaDAO.buscaPorID(idpessoadestino);

                Seguir seguir = new Seguir();
                seguir.setId(id);
                seguir.setPessoaOrigem(origem);
                seguir.setPessoaDestino(destino);
                seguir.setDataCriacao(dataCriacao);
                seguir.setDataModificacao(dataModificacao);
                seguidores.add(seguir);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return seguidores;
    }

    //Função para buscar seguir pelo ID
    public Seguir buscaPorID(long code) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        SeguirDAO seguirDAO = new SeguirDAO();
        
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = createPreparedStatement(connection, code); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("idSeguir");
                Long idpessoaorigem = rs.getLong("idPessoaOrigem");
                Long idpessoadestino = rs.getLong("idPessoaDestino");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();
                
                Pessoa origem = pessoaDAO.buscaPorID(idpessoaorigem);
                Pessoa destino = pessoaDAO.buscaPorID(idpessoadestino);
               
                Seguir seguir = new Seguir();
                seguir.setId(id);
                seguir.setPessoaOrigem(origem);
                seguir.setPessoaDestino(destino);
                seguir.setDataCriacao(dataCriacao);
                seguir.setDataModificacao(dataModificacao);
                
                return seguir;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //Config PreparedStatement
    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from seguir where idSeguir = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    //Função para excluir seguir
    public Seguir exclui(Seguir elemento) {
        String sql = "delete from seguir where idSeguir = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, elemento.getId());

            stmt.execute();

            System.out.println("Elemento excluido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return elemento;
    }

}
