/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import mvc.control.ConnectionFactory;

/**
 *
 * @author  Ana Cristina e Maria Luisa
 */
public class AlimentoDAO {
    Alimento[] alimentos = new Alimento[100];
    
    public AlimentoDAO(){
        Alimento arroz1 = new Alimento();
        arroz1.setNome("Arroz Integral Cozido");
        arroz1.setPorcao(100);
        arroz1.setProteinas(2.6);
        arroz1.setCarboidratos(25.8);
        arroz1.setGorduras(1.0);
        arroz1.getCalorias();
        this.adiciona(arroz1);
        
        Alimento arroz2 = new Alimento();
        arroz2.setNome("Arroz cozido");
        arroz2.setPorcao(100);
        arroz2.setProteinas(7.2);
        arroz2.setCarboidratos(78.8);
        arroz2.setGorduras(0.3);
        arroz2.getCalorias();
        this.adiciona(arroz2);
        
        Alimento feijao = new Alimento();
        feijao.setNome("Feijao Carioca cozido");
        feijao.setPorcao(100);
        feijao.setProteinas(4.8);
        feijao.setCarboidratos(13.6);
        feijao.setGorduras(0.5);
        feijao.getCalorias();
        this.adiciona(feijao);
        
        Alimento feijao2 = new Alimento();
        feijao2.setNome("Feijao Tropeiro");
        feijao2.setPorcao(100);
        feijao2.setProteinas(10.2);
        feijao2.setCarboidratos(19.6);
        feijao2.setGorduras(6.8);
        feijao2.getCalorias();
        this.adiciona(feijao2);
        
        Alimento feijoada = new Alimento();
        feijoada.setNome("Feijoada");
        feijoada.setPorcao(100);
        feijoada.setProteinas(8.7);
        feijoada.setCarboidratos(11.6);
        feijoada.setGorduras(6.5);
        feijoada.getCalorias();
        this.adiciona(feijoada);
        
        Alimento salada1 = new Alimento();
        salada1.setNome("Salada de Legumes - Cozida ao Vapor");
        salada1.setPorcao(100);
        salada1.setProteinas(2.0);
        salada1.setCarboidratos(7.1);
        salada1.setGorduras(0.3);
        salada1.getCalorias();
        this.adiciona(salada1);
        
        Alimento estrogonofe = new Alimento();
        estrogonofe.setNome("Estrogonofe de Frango");
        estrogonofe.setPorcao(100);
        estrogonofe.setProteinas(17.6);
        estrogonofe.setCarboidratos(2.6);
        estrogonofe.setGorduras(8.0);
        estrogonofe.getCalorias();
        this.adiciona(estrogonofe);
        
        Alimento bifeContra = new Alimento();
        bifeContra.setNome("Bife contra-file grelhado");
        bifeContra.setPorcao(100);
        bifeContra.setProteinas(32.4);
        bifeContra.setCarboidratos(0);
        bifeContra.setGorduras(15.5);
        bifeContra.getCalorias();
        this.adiciona(bifeContra);
        
        Alimento fileFrango = new Alimento();
        fileFrango.setNome("File de frango grelhado");
        fileFrango.setPorcao(100);
        fileFrango.setProteinas(31.02);
        fileFrango.setCarboidratos(0);
        fileFrango.setGorduras(3.57);
        fileFrango.getCalorias();
        this.adiciona(fileFrango);
        
        Alimento carneMoida = new Alimento();
        carneMoida.setNome("Carne moida cozida (acem)");
        carneMoida.setPorcao(100);
        carneMoida.setProteinas(26.7);
        carneMoida.setCarboidratos(0);
        carneMoida.setGorduras(10.9);
        carneMoida.getCalorias();
        this.adiciona(carneMoida);
        
        Alimento almondega = new Alimento();
        almondega.setNome("Almondega frita");
        almondega.setPorcao(100);
        almondega.setProteinas(18.2);
        almondega.setCarboidratos(14.3);
        almondega.setGorduras(15.8);
        almondega.getCalorias();
        this.adiciona(almondega);
        
        Alimento banana = new Alimento();
        banana.setNome("Banana prata");
        banana.setPorcao(100);
        banana.setProteinas(1.3);
        banana.setCarboidratos(26.0);
        banana.setGorduras(0.1);
        banana.getCalorias();
        this.adiciona(banana);
        
        Alimento maca = new Alimento();
        maca.setNome("Maca fuji");
        maca.setPorcao(100);
        maca.setProteinas(0.3);
        maca.setCarboidratos(15.2);
        maca.setGorduras(0);
        maca.getCalorias();
        this.adiciona(maca);
        
        Alimento laranja = new Alimento();
        laranja.setNome("Laranja pera");
        laranja.setPorcao(100);
        laranja.setProteinas(1.0);
        laranja.setCarboidratos(8.9);
        laranja.setGorduras(0.1);
        laranja.getCalorias();
        this.adiciona(laranja);
        
        Alimento mamao = new Alimento();
        mamao.setNome("Mamao papaia");
        mamao.setPorcao(100);
        mamao.setProteinas(0.5);
        mamao.setCarboidratos(10.4);
        mamao.setGorduras(0.1);
        mamao.getCalorias();
        this.adiciona(mamao);
        
        Alimento melancia = new Alimento();
        melancia.setNome("Melancia");
        melancia.setPorcao(100);
        melancia.setProteinas(0.9);
        melancia.setCarboidratos(8.1);
        melancia.setGorduras(0);
        melancia.getCalorias();
        this.adiciona(melancia);
        
        Alimento uva = new Alimento();
        uva.setNome("Uva rubi");
        uva.setPorcao(100);
        uva.setProteinas(0.6);
        uva.setCarboidratos(12.7);
        uva.setGorduras(0.2);
        uva.getCalorias();
        this.adiciona(uva);
        
        Alimento leite = new Alimento();
        leite.setNome("Leite com achocolatado");
        leite.setPorcao(100);
        leite.setProteinas(2.1);
        leite.setCarboidratos(14.2);
        leite.setGorduras(2.2);
        leite.getCalorias();
        this.adiciona(leite);
        
        Alimento iogurte = new Alimento();
        iogurte.setNome("Iogurte natural");
        iogurte.setPorcao(100);
        iogurte.setProteinas(4.1);
        iogurte.setCarboidratos(1.9);
        iogurte.setGorduras(3.0);
        iogurte.getCalorias();
        this.adiciona(iogurte);
        
        Alimento queijo = new Alimento();
        queijo.setNome("Queijo minas frescal");
        queijo.setPorcao(100);
        queijo.setProteinas(17.4);
        queijo.setCarboidratos(3.2);
        queijo.setGorduras(20.2);
        queijo.getCalorias();
        this.adiciona(queijo);
        
        Alimento cafe = new Alimento();
        cafe.setNome("Cafe");
        cafe.setPorcao(100);
        cafe.setProteinas(0.7);
        cafe.setCarboidratos(1.5);
        cafe.setGorduras(0.1);
        cafe.getCalorias();
        this.adiciona(cafe);
        
        Alimento omelete = new Alimento();
        omelete.setNome("Omelete de queijo");
        omelete.setPorcao(100);
        omelete.setProteinas(15.6);
        omelete.setCarboidratos(0.4);
        omelete.setGorduras(22.0);
        omelete.getCalorias();
        this.adiciona(omelete);
        
        Alimento ovo = new Alimento();
        
    }

    
    public long adicionaERetornaId(Alimento elemento) {
        String sql = "insert into alimento "
                + "(nome,carboidratos,proteinas,gorduras,porcao,calorias,dataCriacao,dataModificacao)" 
                + " values (?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
            
            ResultSet rs=stmt.getGeneratedKeys();
            
            int retorno=0;
            if(rs.next()){
                retorno = rs.getInt(1);
            }
            
            System.out.println("O id inserido foi: " + retorno);
            elemento.setId(retorno);
            
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean adiciona(Alimento alimento) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            alimentos[proximaPosicaoLivre] = alimento;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Alimento alimento : alimentos) {
            if (alimento != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temAli = false;
        for (Alimento alimento : alimentos) {
            if (alimento != null) {
                System.out.println(alimento.toString());
                temAli = true;
            }
        }
        if (!temAli) {
            System.out.println("não existe alimento cadastrad");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (Alimento alimento : alimentos) {
            if (alimento != null && alimento.getNome().equals(nome)) {
                alimento.setNome(novoNome);
                alimento.setDataModificacao(LocalDate.now());
                return true;
            }
        }
        return false;

    }

    public Alimento buscaPorNome(String nome) {
        for (Alimento alimento : alimentos) {
            if (alimento != null && alimento.getNome().equals(nome)) {
                return alimento;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] != null && alimentos[i].getNome().equals(nome)) {
                alimentos[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] == null) {
                return i;
            }
        }
        return -1;

    }
}
