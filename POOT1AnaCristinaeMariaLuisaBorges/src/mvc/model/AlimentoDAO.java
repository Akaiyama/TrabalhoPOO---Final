/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import teste.ConnectionFactory;
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
 * @author anath
 */
public class AlimentoDAO {

    public long adicionaERetornaId(Alimento elemento) {
        String sql = "insert into alimento "
                + "(nome,carboidratos,proteinas,gorduras,porcao,calorias,dataCriacao,dataModificacao)"
                + " values (?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1, elemento.getNome());
            stmt.setDouble(2, elemento.getCarboidratos());
            stmt.setDouble(3, elemento.getProteinas());
            stmt.setDouble(4, elemento.getGorduras());
            stmt.setInt(5, elemento.getPorcao());
            stmt.setDouble(6, elemento.getCalorias());
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

    public List<Alimento> mostrarTodos(Alimento elemento) {
        String sql = "select * from alimento";

        List<Alimento> alimentos = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); 
                PreparedStatement stmt = connection.prepareStatement(sql); 
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("idAlimento");
                String nome = rs.getString("nome");
                Double carboidratos = rs.getDouble("carboidratos");
                Double proteinas = rs.getDouble("proteinas");
                Double gorduras = rs.getDouble("gorduras");
                int porcao = rs.getInt("porcao");
                Double calorias = rs.getDouble("calorias");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();
                
                Alimento alimento = new Alimento();
                alimento.setId(id);
                alimento.setNome(nome);
                alimento.setCarboidratos(carboidratos);
                alimento.setProteinas(proteinas);
                alimento.setGorduras(gorduras);
                alimento.setPorcao(porcao);
                alimento.calcCalorias();
                
                                
                alimentos.add(alimento);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // itera no ResultSet
        return alimentos;
    }
    
    public Alimento buscaPorID(long code) {
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement ps = createPreparedStatement(connection, code);
            ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Long id = rs.getLong("idAlimento");
                String nome = rs.getString("nome");
                Double carboidratos = rs.getDouble("carboidratos");
                Double proteinas = rs.getDouble("proteinas");
                Double gorduras = rs.getDouble("gorduras");
                int porcao = rs.getInt("porcao");
                Double calorias = rs.getDouble("calorias");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();
                
                Alimento alimento = new Alimento();
                alimento.setId(id);
                alimento.setNome(nome);
                alimento.setCarboidratos(carboidratos);
                alimento.setProteinas(proteinas);
                alimento.setGorduras(gorduras);
                alimento.setPorcao(porcao);
                alimento.calcCalorias();
                alimento.setDataModificacao(dataModificacao);
                alimento.setDataModificacao(dataModificacao);
                return alimento;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from alimento where idAlimento = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }
    
    public Alimento exclui(Alimento elemento) {
        String sql = "delete from alimento where idAlimento = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, elemento.getId());
            
            stmt.execute();
            
            System.out.println("Elemento excluído com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return elemento;
    }
}
