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
public class AlimentoRefeicaoDAO {

    //Função para adicionar alimentoRefeição
    public long adicionaERetornaId(AlimentoRefeicao elemento) {
        /*  private Refeicoes refeicao;
            private Alimento alimento;
            private int porcao;
            private double proteinas;
            private double gorduras;
            private double carboidratos;
            private double calorias;*/
        
        String sql = "insert into alimentorefeicao "
                + "(idRefeicao, idAlimento, porcao, proteinas, gorduras, carboidratos,calorias,dataCriacao,dataModificacao)"
                + " values (?,?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setLong(1, elemento.getRefeicao().getId());
            stmt.setLong(2, elemento.getAlimento().getId());
            stmt.setInt(3, elemento.getPorcao());
            
            stmt.setDouble(4, elemento.getProteinas());
            stmt.setDouble(5, elemento.getGorduras());
            stmt.setDouble(6, elemento.getCarboidratos());
            stmt.setDouble(7, elemento.getCalorias());
            stmt.setDate(8, java.sql.Date.valueOf(elemento.getDataCriacao()));
            stmt.setDate(9, java.sql.Date.valueOf(elemento.getDataModificacao()));

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

    //Função para mostrar todas os alimentoRefeição
    public List<AlimentoRefeicao> mostrarTodos(AlimentoRefeicao elemento) {
        String sql = "select * from alimentorefeicao";
        RefeicoesDAO refeicoesDAO = new RefeicoesDAO();
        AlimentoDAO alimentoDAO = new AlimentoDAO();

        List<AlimentoRefeicao> alimentorefeicoes = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("idAlimentoRefeicao");
                Long idrefeicao = rs.getLong("idRefeicao");
                Long idalimento = rs.getLong("idAlimento");
                int porcao = rs.getInt("porcao");
                Double proteinas = rs.getDouble("proteinas");
                Double gorduras = rs.getDouble("gorduras");
                Double carboidratos = rs.getDouble("carboidratos");
                Double calorias = rs.getDouble("calorias");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();

                Refeicoes r = refeicoesDAO.buscaPorID(idrefeicao);
                Alimento a = alimentoDAO.buscaPorID(idalimento);

                AlimentoRefeicao alimentorefeicao = new AlimentoRefeicao();
                alimentorefeicao.setId(id);
                alimentorefeicao.setRefeicao(r);
                alimentorefeicao.setAlimento(a);
                alimentorefeicao.setPorcao(porcao);
                alimentorefeicao.setProteinas(proteinas);
                alimentorefeicao.setGorduras(gorduras);
                alimentorefeicao.setCarboidratos(carboidratos);
                alimentorefeicao.setCalorias(calorias);
                alimentorefeicao.setDataCriacao(dataCriacao);
                alimentorefeicao.setDataModificacao(dataModificacao);
                alimentorefeicoes.add(alimentorefeicao);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alimentorefeicoes;
    }

    //Função para buscar o alimentoRefeição pelo ID
    public AlimentoRefeicao buscaPorID(long code) {
        RefeicoesDAO refeicoesDAO = new RefeicoesDAO();
        AlimentoDAO alimentoDAO = new AlimentoDAO();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = createPreparedStatement(connection, code); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("idAlimentoRefeicao");
                Long idrefeicao = rs.getLong("idRefeicao");
                Long idalimento = rs.getLong("idAlimento");
                int porcao = rs.getInt("porcao");
                Double proteinas = rs.getDouble("proteinas");
                Double gorduras = rs.getDouble("gorduras");
                Double carboidratos = rs.getDouble("carboidratos");
                Double calorias = rs.getDouble("calorias");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();

                Refeicoes r = refeicoesDAO.buscaPorID(idrefeicao);
                Alimento a = alimentoDAO.buscaPorID(idalimento);

                AlimentoRefeicao alimentorefeicao = new AlimentoRefeicao();
                alimentorefeicao.setId(id);
                alimentorefeicao.setRefeicao(r);
                alimentorefeicao.setAlimento(a);
                alimentorefeicao.setPorcao(porcao);
                alimentorefeicao.setProteinas(proteinas);
                alimentorefeicao.setGorduras(gorduras);
                alimentorefeicao.setCarboidratos(carboidratos);
                alimentorefeicao.setCalorias(calorias);
                alimentorefeicao.setDataCriacao(dataCriacao);
                alimentorefeicao.setDataModificacao(dataModificacao);

                return alimentorefeicao;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //Config PreparedStatement
    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from alimentorefeicao where idAlimentoRefeicao = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    //Função para excluir o alimentoRefeição
    public AlimentoRefeicao exclui(AlimentoRefeicao elemento) {
        String sql = "delete from alimentorefeicao where idAlimentoRefeicao = ?";

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
