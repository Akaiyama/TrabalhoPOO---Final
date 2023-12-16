/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import java.util.List;
import java.util.Scanner;
import mvc.model.AvaliacaoFisica;
import mvc.model.AvaliacaoFisicaDAO;
import mvc.model.Dieta;
import mvc.model.DietaDAO;
import mvc.model.Pessoa;
import mvc.model.PessoaDAO;
import mvc.model.TipoDieta;
import mvc.model.TipoDietaDAO;

/**
 *
 * @author anath
 */
public class TesteDieta {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new TesteDieta();
    }

    public TesteDieta() {
        List<Dieta> dietas = null;
        DietaDAO dietaDAO = new DietaDAO();
        PessoaDAO pessoaDAO = new PessoaDAO();
        AvaliacaoFisicaDAO avaliacaoDAO = new AvaliacaoFisicaDAO();
        TipoDietaDAO tipoDAO = new TipoDietaDAO();

        Pessoa pessoa = pessoaDAO.buscaPorID(1);
        AvaliacaoFisica avaliacao = avaliacaoDAO.buscaPorID(1);
        TipoDieta tipo = tipoDAO.buscaPorID(1);

        //dietaDAO.adicionaERetornaId(this.criaDieta(pessoa, avaliacao, tipo));

        //dietas = dietaDAO.mostrarTodos(null, logada);
         //this.imprimeLista(dietas);
        Dieta d = dietaDAO.buscaPorID(4);
        System.out.println("Dieta retornado: ");
        System.out.println(d);
        //Dieta dieta = dietaDAO.exclui(this.obtemDietaExclui());
    }

    private void imprimeLista(List<Dieta> dietas) {
        for (Dieta d : dietas) {
            System.out.println(d);
        }
    }

    private Dieta obtemDietaExclui() {
        Dieta dieta = new Dieta();
        dieta.setId(3);
        return dieta;
    }

    public int menuObjetivoDieta() {
        StringBuilder builder = new StringBuilder("");
        builder.append("\n\nQual o objetivo da sua dieta? ");
        builder.append("\n1 - Diminuir o peso;");
        builder.append("\n2 - Manter o peso;");
        builder.append("\n3 - Aumentar o peso;");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());
        int opc = Integer.parseInt(scanner.nextLine());
        return opc;
    }

    public Dieta criaDieta(Pessoa logada, AvaliacaoFisica av, TipoDieta tipo) {
        Dieta dieta = new Dieta(logada, av, tipo);
        dieta.setObjetivo(menuObjetivoDieta());
        StringBuilder builder = new StringBuilder("");
        builder.append("\n\nQuantas refeicoes ira fazer ao dia?");
        builder.append("\n3 - três refeicoes;");
        builder.append("\n4 - quatro refeicoes;");
        builder.append("\n5 - cinco refeicoes;");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());
        int numRef = Integer.parseInt(scanner.nextLine());
        dieta.setNroRefeicoes(numRef);
        dieta.setCalorias(av.getTMB());

        return dieta;
    }
}
