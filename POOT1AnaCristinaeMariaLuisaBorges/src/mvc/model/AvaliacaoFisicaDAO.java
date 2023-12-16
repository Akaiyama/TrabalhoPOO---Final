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
 * @author Ana Cristina e Maria Luisa -> AvaliacaoDAO - Parte 2
 */
public class AvaliacaoFisicaDAO {

    //Função para adicionar avaliação
    public long adicionaERetornaId(AvaliacaoFisica elemento) {

        //id, pessoa, peso, altura, idade, pescoco, cintura, quadril, IMC, TMB, BF, massa gorda kg, massa magra kg, dataCriacao, dataModificacao.
        String sql = "insert into avaliacaofisica "
                + "(idpessoa,peso,idade,altura,pescoco,cintura,quadril,IMC,TMB,BF,massaGorda,massaMagra,dataCriacao,dataModificacao)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setLong(1, elemento.getPessoa().getId());
            stmt.setDouble(2, elemento.getPeso());
            stmt.setInt(3, elemento.getIdade());
            stmt.setDouble(4, elemento.getAltura());
            stmt.setDouble(5, elemento.getPescoco());
            stmt.setDouble(6, elemento.getCintura());
            stmt.setDouble(7, elemento.getQuadril());
            stmt.setDouble(8, elemento.getIMC());
            stmt.setDouble(9, elemento.getTMB());
            stmt.setDouble(10, elemento.getBF());
            stmt.setDouble(11, elemento.getMassaGorda());
            stmt.setDouble(12, elemento.getMassaMagra());
            stmt.setDate(13, java.sql.Date.valueOf(elemento.getDataCriacao()));
            stmt.setDate(14, java.sql.Date.valueOf(elemento.getDataModificacao()));

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
    public List<AvaliacaoFisica> mostrarTodos(AvaliacaoFisica elemento, Pessoa logada) {
        String sql = "select * from avaliacaofisica";
        PessoaDAO pessoaDAO = new PessoaDAO();
        AvaliacaoCalculos a = new AvaliacaoCalculos();
        List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

       try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = create(connection, logada.getId()); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("idavaliacaofisica");
                Long idpessoa = rs.getLong("idpessoa");
                Double peso = rs.getDouble("peso");
                Integer idade = rs.getInt("idade");
                Double altura = rs.getDouble("altura");
                Double pescoco = rs.getDouble("pescoco");
                Double cintura = rs.getDouble("cintura");
                Double quadril = rs.getDouble("quadril");
                Double imc = rs.getDouble("IMC");
                Double tmb = rs.getDouble("TMB");
                Double bf = rs.getDouble("BF");
                Double massaGorda = rs.getDouble("massaGorda");
                Double massaMagra = rs.getDouble("massaMagra");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();

                Pessoa pessoa = pessoaDAO.buscaPorID(idpessoa);

                AvaliacaoFisica avaliacao = new AvaliacaoFisica(pessoa);
                avaliacao.setId(id);
                avaliacao.setPessoa(pessoa);
                avaliacao.setPeso(peso);
                avaliacao.setIdade(idade);
                avaliacao.setAltura(altura);
                avaliacao.setPescoco(pescoco);
                avaliacao.setCintura(cintura);
                avaliacao.setQuadril(quadril);
                avaliacao.setIMC(imc);
                avaliacao.setTMB(tmb);
                avaliacao.setBF(bf);
                avaliacao.setMassaGorda(massaGorda);
                avaliacao.setMassaMagra(massaMagra);
                avaliacao.setDataCriacao(dataCriacao);
                avaliacao.setDataModificacao(dataModificacao);
                avaliacoes.add(avaliacao);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return avaliacoes;
    }

    //Função para buscar a avaliação pelo ID
    public AvaliacaoFisica buscaPorID(long code) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        AvaliacaoFisicaDAO avaliacaoDAO = new AvaliacaoFisicaDAO();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = createPreparedStatement(connection, code); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("idavaliacaofisica");
                Long idpessoa = rs.getLong("idpessoa");
                Double peso = rs.getDouble("peso");
                Integer idade = rs.getInt("idade");
                Double altura = rs.getDouble("altura");
                Double pescoco = rs.getDouble("pescoco");
                Double cintura = rs.getDouble("cintura");
                Double quadril = rs.getDouble("quadril");
                Double imc = rs.getDouble("IMC");
                Double tmb = rs.getDouble("TMB");
                Double bf = rs.getDouble("BF");
                Double massaGorda = rs.getDouble("massaGorda");
                Double massaMagra = rs.getDouble("massaMagra");
                Date createDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = createDate.toLocalDate();
                Date updateDate = rs.getDate("dataModificacao");
                LocalDate dataModificacao = updateDate.toLocalDate();

                Pessoa pessoa = pessoaDAO.buscaPorID(idpessoa);

                AvaliacaoFisica avaliacao = new AvaliacaoFisica(pessoa);
                avaliacao.setId(id);
                avaliacao.setPessoa(pessoa);
                avaliacao.setPeso(peso);
                avaliacao.setIdade(idade);
                avaliacao.setAltura(altura);
                avaliacao.setPescoco(pescoco);
                avaliacao.setCintura(cintura);
                avaliacao.setQuadril(quadril);
                avaliacao.setIMC(imc);
                avaliacao.setTMB(tmb);
                avaliacao.setBF(bf);
                avaliacao.setMassaGorda(massaGorda);
                avaliacao.setMassaMagra(massaMagra);
                avaliacao.setDataCriacao(dataCriacao);
                avaliacao.setDataModificacao(dataModificacao);

                return avaliacao;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //Config PreparedStatement
    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from avaliacaofisica where idavaliacaofisica = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }
//Config PreparedStatement
    private PreparedStatement create(Connection con, long id) throws SQLException {
        String sql = "select * from avaliacaofisica where idpessoa = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    //Função para excluir a avaliação
    public AvaliacaoFisica exclui(AvaliacaoFisica elemento) {
        String sql = "delete from avaliacaofisica where idavaliacaofisica = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, elemento.getId());

            stmt.execute();

            System.out.println("Avaliacao excluida com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return elemento;
    }

}
