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
import teste.ConnectionFactory;

/**
 *
 * @author Ana Cristina e Maria Luisa
 */
public class DietaDAO {

    //Função para adicionar avaliação
    public long adicionaERetornaId(Dieta elemento) {

        String sql = "insert into dieta "
                + "(idpessoaDieta,idavaliacaofisicaDieta,idtipoDieta,objetivo,calorias,nroRefeicoes,dataCriacao,dataModificacao)"
                + " values (?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setLong(1, elemento.getPessoa().getId());
            stmt.setLong(2, elemento.getAvaliacaoFisica().getId());
            stmt.setLong(3, elemento.getTipo().getId());
            stmt.setString(4, elemento.getObjetivo());
            stmt.setDouble(5, elemento.getCalorias());
            stmt.setInt(6, elemento.getNroRefeicoes());
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

    //Função para mostrar todas as avaliações
    public List<Dieta> mostrarTodos(Dieta elemento, Pessoa logada) {
        String sql = "select * from dieta";
        PessoaDAO pessoaDAO = new PessoaDAO();
        AvaliacaoFisicaDAO avaliacaoDAO = new AvaliacaoFisicaDAO();
        TipoDietaDAO tipoDAO = new TipoDietaDAO();

        List<Dieta> dietas = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = create(connection, logada.getId()); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("iddieta");
                Long idpessoa = rs.getLong("idpessoaDieta");
                Long idavaliacao = rs.getLong("idavaliacaofisicaDieta");
                Long idtipo = rs.getLong("idtipoDieta");
                String objetivo = rs.getString("objetivo");
                Double calorias = rs.getDouble("calorias");
                int nro = rs.getInt("nroRefeicoes");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();

                Pessoa pessoa = pessoaDAO.buscaPorID(idpessoa);
                AvaliacaoFisica avaliacao = avaliacaoDAO.buscaPorID(idavaliacao);
                TipoDieta tipo = tipoDAO.buscaPorID(idtipo);
                Dieta dieta = new Dieta();
                
                dieta.setId(id);
                dieta.setPessoa(pessoa);
                dieta.setAvaliacaoFisica(avaliacao);
                dieta.setTipo(tipo);
                dieta.setObjetivo(objetivo);
                dieta.setCalorias(calorias);
                dieta.setNroRefeicoes(nro);
                dieta.setDataCriacao(dataCriacao);
                dieta.setDataModificacao(dataModificacao);
                dietas.add(dieta);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dietas;
    }

    //Função para buscar a avaliação pelo ID
    public Dieta buscaPorID(long code) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        AvaliacaoFisicaDAO avaliacaoDAO = new AvaliacaoFisicaDAO();
        TipoDietaDAO tipoDAO = new TipoDietaDAO();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = createPreparedStatement(connection, code); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("iddieta");
                Long idpessoa = rs.getLong("idpessoaDieta");
                Long idavaliacao = rs.getLong("idavaliacaofisicaDieta");
                Long idtipo = rs.getLong("idtipoDieta");
                String objetivo = rs.getString("objetivo");
                Double calorias = rs.getDouble("calorias");
                int nro = rs.getInt("nroRefeicoes");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();

                Pessoa pessoa = pessoaDAO.buscaPorID(idpessoa);
                AvaliacaoFisica avaliacao = avaliacaoDAO.buscaPorID(idavaliacao);
                TipoDieta tipo = tipoDAO.buscaPorID(idtipo);
                Dieta dieta = new Dieta();
                
                dieta.setId(id);
                dieta.setPessoa(pessoa);
                dieta.setAvaliacaoFisica(avaliacao);
                dieta.setTipo(tipo);
                dieta.setObjetivo(objetivo);
                dieta.setCalorias(calorias);
                dieta.setNroRefeicoes(nro);
                dieta.setDataCriacao(dataCriacao);
                dieta.setDataModificacao(dataModificacao);

                return dieta;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //Config PreparedStatement
    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from dieta where iddieta = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }
    
    //Config PreparedStatement
    private PreparedStatement create(Connection con, long id) throws SQLException {
        String sql = "select * from dieta where idpessoaDieta = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    //Função para excluir a avaliação
    public Dieta exclui(Dieta elemento) {
        String sql = "delete from dieta where iddieta = ?";

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
