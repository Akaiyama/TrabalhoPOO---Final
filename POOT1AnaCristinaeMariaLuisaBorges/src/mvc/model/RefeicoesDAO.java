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
 * @author Ana e Maria
 */
public class RefeicoesDAO {
    public long adicionaERetornaId(Refeicoes elemento) {
    
        String sql = "insert into refeicoes "
                + "(idDieta,carboidratos,carbMAX,proteinas,proMAX,gorduras,gordMAX,calorias,caloriasMAX,nomeRefeicao,dataCriacao,dataModificacao)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setLong(1, elemento.getDieta().getId());
            stmt.setDouble(2, elemento.getCarboidratos());
            stmt.setDouble(3, elemento.getCarbMAX());
            stmt.setDouble(4, elemento.getProteinas());
            stmt.setDouble(5, elemento.getProMAX());
            stmt.setDouble(6, elemento.getGorduras());
            stmt.setDouble(7, elemento.getGordMAX());
            stmt.setDouble(8, elemento.getCalorias());
            stmt.setDouble(9, elemento.getCaloriaMAX());
            stmt.setString(10, elemento.getNomeRefeicao());
            stmt.setDate(11, java.sql.Date.valueOf(elemento.getDataCriacao()));
            stmt.setDate(12, java.sql.Date.valueOf(elemento.getDataModificacao()));

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

    //Função para mostrar todas as refeições
    public List<Refeicoes> mostrarTodos(Refeicoes elemento) {
        String sql = "select * from refeicoes";
        DietaDAO dietaDAO = new DietaDAO();
        List<Refeicoes> refeicoes = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("idrefeicoes");
                Long iddieta = rs.getLong("idDieta");
                Double carboidratos = rs.getDouble("carboidratos");
                Double carbMAX = rs.getDouble("carbMAX");
                Double proteinas = rs.getDouble("proteinas");
                Double proMAX = rs.getDouble("proMAX");
                Double gorduras = rs.getDouble("gorduras");
                Double gordMAX = rs.getDouble("gordMAX");
                Double calorias = rs.getDouble("calorias");
                Double caloriasMAX = rs.getDouble("caloriasMAX");
                String nomerefeicao = rs.getString("nomeRefeicao");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();

                Dieta dieta = dietaDAO.buscaPorID(iddieta);
               
                Refeicoes refeicao = new Refeicoes();
                refeicao.setId(id);
                refeicao.setDieta(dieta);
                refeicao.setCarboidratos(carboidratos);
                refeicao.setCarbMAX(carbMAX);
                refeicao.setProteinas(proteinas);
                refeicao.setProMAX(proMAX);
                refeicao.setGorduras(gorduras);
                refeicao.setGordMAX(gordMAX);
                refeicao.setCalorias(calorias);
                refeicao.setCaloriaMAX(caloriasMAX);
                refeicao.setNomeRefeicao(nomerefeicao);
                refeicao.setDataCriacao(dataCriacao);
                refeicao.setDataModificacao(dataModificacao);
                
                refeicoes.add(refeicao);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return refeicoes;
    }

    //Função para buscar a refeição pelo ID
    public Refeicoes buscaPorID(long code) {
        DietaDAO dietaDAO = new DietaDAO();
        RefeicoesDAO refeicaoDAO = new RefeicoesDAO();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = createPreparedStatement(connection, code); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("idrefeicoes");
                Long iddieta = rs.getLong("idDieta");
                Double carboidratos = rs.getDouble("carboidratos");
                Double carbMAX = rs.getDouble("carbMAX");
                Double proteinas = rs.getDouble("proteinas");
                Double proMAX = rs.getDouble("proMAX");
                Double gorduras = rs.getDouble("gorduras");
                Double gordMAX = rs.getDouble("gordMAX");
                Double calorias = rs.getDouble("calorias");
                Double caloriasMAX = rs.getDouble("caloriasMAX");
                String nomerefeicao = rs.getString("nomeRefeicao");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();

                Dieta dieta = dietaDAO.buscaPorID(iddieta);
               
                Refeicoes refeicao = new Refeicoes();
                refeicao.setId(id);
                refeicao.setDieta(dieta);
                refeicao.setCarboidratos(carboidratos);
                refeicao.setCarbMAX(carbMAX);
                refeicao.setProteinas(proteinas);
                refeicao.setProMAX(proMAX);
                refeicao.setGorduras(gorduras);
                refeicao.setGordMAX(gordMAX);
                refeicao.setCalorias(calorias);
                refeicao.setCaloriaMAX(caloriasMAX);
                refeicao.setNomeRefeicao(nomerefeicao);
                refeicao.setDataCriacao(dataCriacao);
                refeicao.setDataModificacao(dataModificacao);

                return refeicao;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //Config PreparedStatement
    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from refeicoes where idrefeicoes = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    //Função para excluir a refeição
    public Refeicoes exclui(Refeicoes elemento) {
        String sql = "delete from refeicoes where idrefeicoes = ?";

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