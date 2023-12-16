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
 *@author  Ana Cristina e Maria Luisa
 */
public class TipoDietaDAO {
    
    
    public long adicionaERetornaId(TipoDieta elemento) {
        String sql = "insert into tipodieta "
                + "(nome,carboidratos,proteinas,gorduras,dataCriacao,dataModificacao)"
                + " values (?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1, elemento.getNome());
            stmt.setDouble(2, elemento.getCarboidratos());
            stmt.setDouble(3, elemento.getProteinas());
            stmt.setDouble(4, elemento.getGorduras());
            stmt.setDate(5, java.sql.Date.valueOf(elemento.getDataCriacao()));
            stmt.setDate(6, java.sql.Date.valueOf(elemento.getDataModificacao()));

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

    public List<TipoDieta> mostrarTodos(TipoDieta elemento) {
        String sql = "select * from tipodieta";

        List<TipoDieta> tipos = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); 
                PreparedStatement stmt = connection.prepareStatement(sql); 
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Long id = rs.getLong("idtipoDieta");
                String nome = rs.getString("nome");
                Double carboidratos = rs.getDouble("carboidratos");
                Double proteinas = rs.getDouble("proteinas");
                Double gorduras = rs.getDouble("gorduras");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();
                
                TipoDieta tipo = new TipoDieta();
                tipo.setId(id);
                tipo.setCarboidratos(carboidratos);
                tipo.setProteinas(proteinas);
                tipo.setGorduras(gorduras);
                tipo.setNome2(nome);

                                
                tipos.add(tipo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // itera no ResultSet
        return tipos;
    }
    
    public TipoDieta buscaPorID(long code) {
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement ps = createPreparedStatement(connection, code);
            ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Long id = rs.getLong("idtipoDieta");
                String nome = rs.getString("nome");
                Double carboidratos = rs.getDouble("carboidratos");
                Double proteinas = rs.getDouble("proteinas");
                Double gorduras = rs.getDouble("gorduras");
                
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();
                
                TipoDieta tipo = new TipoDieta();
                tipo.setId(id);
                tipo.setNome2(nome);
                tipo.setCarboidratos(carboidratos);
                tipo.setProteinas(proteinas);
                tipo.setGorduras(gorduras);
                tipo.setDataCriacao(dataCriacao);
                tipo.setDataModificacao(dataModificacao);
                
                return tipo;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from tipodieta where idtipoDieta = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }
    
    public TipoDieta exclui(TipoDieta elemento) {
        String sql = "delete from tipodieta where idtipoDieta = ?";

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
