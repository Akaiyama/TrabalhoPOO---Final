/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import java.util.List;
import java.util.Scanner;
import mvc.model.Dieta;
import mvc.model.DietaDAO;
import mvc.model.Refeicoes;
import mvc.model.RefeicoesDAO;

/**
 *
 * @author mb780
 */
public class TesteRefeicoes {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new TesteRefeicoes();
    }

    public TesteRefeicoes() {
        List<Refeicoes> refeicoes = null;
        
        RefeicoesDAO refeicoesDAO = new RefeicoesDAO();

        //refeicoesDAO.adicionaERetornaId(this.criaRefeicoes());
        
        //refeicoes = refeicoesDAO.mostrarTodos(null);
        //this.imprimeLista(refeicoes);
        //Refeicoes r = refeicoesDAO.buscaPorID(2);
        //System.out.println("Refeicao: ");
        //System.out.println(r);
        Refeicoes r = refeicoesDAO.exclui(this.obtemRefeicoesExclui());
    }

    private void imprimeLista(List<Refeicoes> refeicoes) {
        for (Refeicoes r : refeicoes) {
            System.out.println(r);
        }
    }

    private Refeicoes obtemRefeicoesExclui() {
        Refeicoes refeicao = new Refeicoes();
        refeicao.setId(5);
        return refeicao;
    }


    /* public int menuTipoRefeicao() {
        StringBuilder builder = new StringBuilder("");
        builder.append("\n\n================== TIPO REFEICAO ================== ");
        builder.append("\n1 - Cafe da manha;");
        builder.append("\n2 - Almoco;");
        builder.append("\n3 - Cafe da tarde;");
        builder.append("\n4 - Janta;");
        builder.append("\n5 - Ceia;");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());
        int opc = Integer.parseInt(scanner.nextLine());
        return opc;
    }*/
    public Refeicoes criaRefeicoes() {
        DietaDAO dietaDAO = new DietaDAO();
        Refeicoes r1 = new Refeicoes();
        System.out.println("\n================== CADASTRO REFEICAO ==================");
        r1.setDieta(dietaDAO.buscaPorID(3));

        System.out.println("\nNome refeicao: ");
        String nomerefeicao = scanner.nextLine();
        r1.setNomeRefeicao(nomerefeicao);
        r1.setCaloriaMAX(r1.getDieta().getCalorias() / r1.getDieta().getNroRefeicoes());
        r1.setCalorias(r1.getCaloriaMAX());
        System.out.println(r1.getDieta().getTipo().getNome());
        switch (r1.getDieta().getTipo().getNome()) {
            case "Equilibrada":
                
                r1.setCarbMAX(r1.getCalorias() * 0.40);
                r1.setProMAX(r1.getCalorias() * 0.30);
                r1.setGordMAX(r1.getCalorias() * 0.30);
                
                break;
            case "Low Carb":
                r1.setCarbMAX(r1.getCalorias() * 0.30);
                r1.setProMAX(r1.getCalorias() * 0.50);
                r1.setGordMAX(r1.getCalorias() * 0.20);
                break;
            case "Cetogenica":
                r1.setCarbMAX(r1.getCalorias() * 0.15);
                r1.setProMAX(r1.getCalorias() * 0.15);
                r1.setGordMAX(r1.getCalorias() * 0.70);
                break;
        }
        r1.setCalorias(0);
        r1.setCarboidratos(0);
        r1.setGorduras(0);
        r1.setProteinas(0);
        return r1;
    }

}
