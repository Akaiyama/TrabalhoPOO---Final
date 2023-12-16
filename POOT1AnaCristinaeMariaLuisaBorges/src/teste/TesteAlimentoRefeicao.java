/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import java.util.List;
import java.util.Scanner;
import mvc.model.Alimento;
import mvc.model.AlimentoDAO;
import mvc.model.Refeicoes;
import mvc.model.RefeicoesDAO;
import mvc.model.AlimentoRefeicao;
import mvc.model.AlimentoRefeicaoDAO;

/**
 *
 * @author ana e maria
 */
public class TesteAlimentoRefeicao {
        Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new TesteAlimentoRefeicao();
    }

    public TesteAlimentoRefeicao() {
        List<AlimentoRefeicao> alimentos = null;
        AlimentoRefeicaoDAO alimentorefeicaoDAO = new AlimentoRefeicaoDAO();
        
        //alimentorefeicaoDAO.adicionaERetornaId(this.criaAlimentoRefeicao());

        //alimentos = alimentorefeicaoDAO.mostrarTodos(null);
        //this.imprimeLista(alimentos);
       
        //AlimentoRefeicao al = alimentorefeicaoDAO.exclui(this.obtemExemploExclui());
        
    }

    private void imprimeLista(List<AlimentoRefeicao> refeicoes) {
        for (AlimentoRefeicao ar : refeicoes) {
            System.out.println(ar);
        }
    }

    private AlimentoRefeicao obtemExemploExclui() {
        AlimentoRefeicao r = new AlimentoRefeicao();
        r.setId(2);
        return r;
    }
    
    public AlimentoRefeicao criaAlimentoRefeicao() {
        AlimentoRefeicao alimento = new AlimentoRefeicao();
        RefeicoesDAO refeicoesDAO = new RefeicoesDAO();
        AlimentoDAO alimentoDAO = new AlimentoDAO();
        Alimento a1 = alimentoDAO.buscaPorID(1);
        
        alimento.setRefeicao(refeicoesDAO.buscaPorID(2));
        alimento.setAlimento(a1);
        alimento.setPorcao(100);
        alimento.setCalorias(a1.getCalorias());
        alimento.setProteinas(a1.getProteinas());
        alimento.setCarboidratos(a1.getCarboidratos());
        alimento.setGorduras(a1.getGorduras());
        
        
        return alimento;
//        System.out.println("\nDigite o id do alimento que comeu: ");
//        Long id = Long.parseLong(scanner.nextLine());
//        
//        AlimentoRefeicao alimentosRefeicao = new AlimentoRefeicao();
//        RefeicoesDAO refeicoesDAO = new RefeicoesDAO();
//        Refeicoes refeicao = refeicoesDAO.buscaPorID(2);
//        AlimentoDAO alimentoDAO = new AlimentoDAO();
//        Alimento alimento = alimentoDAO.buscaPorID(id);
//        
//        
//        alimentosRefeicao.setAlimento(alimento);
//            alimentosRefeicao.setRefeicao(refeicao);
//            alimentosRefeicao.setCalorias(alimentosRefeicao.getAlimento().getCalorias());
//            alimentosRefeicao.setCarboidratos(alimentosRefeicao.getAlimento().getCarboidratos());
//            alimentosRefeicao.setPorcao(100);
//            alimentosRefeicao.setProteinas(alimentosRefeicao.getAlimento().getProteinas());
//            alimentosRefeicao.setGorduras(alimentosRefeicao.getAlimento().getGorduras());
//            refeicao.setCalorias(refeicao.getCalorias() + alimentosRefeicao.getCalorias());
//            refeicao.setProteinas(refeicao.getProteinas() + alimentosRefeicao.getProteinas());
//            refeicao.setCarboidratos(refeicao.getCarboidratos() + alimentosRefeicao.getCarboidratos());
//            refeicao.setGorduras(refeicao.getGorduras() + alimentosRefeicao.getGorduras());
//            return alimentosRefeicao;
        
    }
}
