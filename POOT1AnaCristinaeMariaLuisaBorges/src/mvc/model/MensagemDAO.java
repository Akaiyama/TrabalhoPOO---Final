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
 * @author Ana Cristina e Maria Luisa -> MensagemDAO - Parte 2
 */
public class MensagemDAO {

    //Função para adicionar a mensagem
    public long adicionaERetornaId(Mensagem elemento) {
        String sql = "insert into mensagem "
                + "(idpOrigem,idpDestino,mensagem,dataCriacao,dataModificacao)"
                + " values (?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setLong(1, elemento.getPessoaOrigem().getId());
            stmt.setLong(2, elemento.getPessoaDestino().getId());
            stmt.setString(3, elemento.getMensagem());
            stmt.setDate(4, java.sql.Date.valueOf(elemento.getDataCriacao()));
            stmt.setDate(5, java.sql.Date.valueOf(elemento.getDataModificacao()));

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

    //Função para mostrar todas as mensagens
    public List<Mensagem> mostrarTodos(Mensagem elemento, Pessoa logada) {
        String sql = "select * from mensagem";
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Mensagem> mensagens = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                if (logada.getId() == rs.getLong("idpOrigem") || logada.getId() == rs.getLong("idpDestino")) {
                    Long id = rs.getLong("idmensagem");
                    Long idOrigem = rs.getLong("idpOrigem");
                    Long idDestino = rs.getLong("idpDestino");
                    String mensagem = rs.getString("mensagem");
                    Date createDate = rs.getDate("dataCriacao");
                    LocalDate dataCriacao = createDate.toLocalDate();
                    Date updateDate = rs.getDate("dataModificacao");
                    LocalDate dataModificacao = updateDate.toLocalDate();

                    Pessoa pessoaOrigem = pessoaDAO.buscaPorID(idOrigem);
                    Pessoa pessoaDestino = pessoaDAO.buscaPorID(idDestino);

                    Mensagem m = new Mensagem();
                    m.setId(id);
                    m.setPessoaOrigem(pessoaOrigem);
                    m.setPessoaDestino(pessoaDestino);
                    m.setMensagem(mensagem);
                    m.setDataCriacao(dataCriacao);
                    m.setDataModificacao(dataModificacao);
                    mensagens.add(m);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mensagens;
    }

    //Função para buscar a mensagem pelo ID
    public Mensagem buscaPorID(long code, Pessoa logada) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = createPreparedStatement(connection, code); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                if (logada.getId() == rs.getLong("idpOrigem") || logada.getId() == rs.getLong("idpDestino")) {
                    Long id = rs.getLong("idmensagem");
                    Long idOrigem = rs.getLong("idpOrigem");
                    Long idDestino = rs.getLong("idpDestino");
                    String mensagem = rs.getString("mensagem");
                    Date createDate = rs.getDate("dataCriacao");
                    LocalDate dataCriacao = createDate.toLocalDate();
                    Date updateDate = rs.getDate("dataModificacao");
                    LocalDate dataModificacao = updateDate.toLocalDate();

                    Pessoa pessoaOrigem = pessoaDAO.buscaPorID(idOrigem);
                    Pessoa pessoaDestino = pessoaDAO.buscaPorID(idDestino);

                    Mensagem m = new Mensagem();
                    m.setId(id);
                    m.setPessoaOrigem(pessoaOrigem);
                    m.setPessoaDestino(pessoaDestino);
                    m.setMensagem(mensagem);
                    m.setDataCriacao(dataCriacao);
                    m.setDataModificacao(dataModificacao);

                    return m;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //Config PreparedStatement
    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from mensagem where idmensagem = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    //Função para excluir a mensagem
    public Mensagem exclui(Mensagem elemento) {
        String sql = "delete from mensagem where idmensagem = ?";

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
