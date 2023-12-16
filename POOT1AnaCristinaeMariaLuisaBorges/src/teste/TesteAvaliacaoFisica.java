/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import mvc.model.AvaliacaoCalculos;
import mvc.model.AvaliacaoFisica;
import mvc.model.AvaliacaoFisicaDAO;
import mvc.model.Pessoa;
import mvc.model.PessoaDAO;

/**
 *
 * @author mb780
 */
public class TesteAvaliacaoFisica {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new TesteAvaliacaoFisica();
    }

    public TesteAvaliacaoFisica() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<AvaliacaoFisica> avaliacoes = null;
        AvaliacaoFisicaDAO avaliacaoDAO = new AvaliacaoFisicaDAO();
        //avaliacaoDAO.adicionaERetornaId(this.adicionarAvaliacaoFisica(pessoaDAO));

        //avaliacoes = avaliacaoDAO.mostrarTodos(null);
       // this.imprimeLista(avaliacoes);
        //AvaliacaoFisica av = avaliacaoDAO.buscaPorID(1);
        //System.out.println("Avaliacao fisica retornada: ");
        //System.out.println(av);
        AvaliacaoFisica av = avaliacaoDAO.exclui(this.obtemContatoExemploExclui());
        
    }

    private void imprimeLista(List<AvaliacaoFisica> avaliacoes) {
        for (AvaliacaoFisica av : avaliacoes) {
            System.out.println(av);
        }
    }

    private AvaliacaoFisica obtemContatoExemploExclui() {
        PessoaDAO pessoaDAO = new PessoaDAO();

        AvaliacaoFisica avaliacao = new AvaliacaoFisica(pessoaDAO.buscaPorID(2));
        avaliacao.setId(2);
        return avaliacao;
    }

    private AvaliacaoFisica adicionarAvaliacaoFisica(PessoaDAO pessoaDAO) {
        return criaAvaliacaoFisica(pessoaDAO);
    }
    
    public AvaliacaoFisica criaAvaliacaoFisica(PessoaDAO pessoaDAO) {
        AvaliacaoCalculos a = new AvaliacaoCalculos();
        Pessoa logada = pessoaDAO.buscaPorID(2);
        AvaliacaoFisica a1 = new AvaliacaoFisica(logada);
        System.out.println("\nCADASTRO AVALIACAO FISICA");
        System.out.println("\nInforme seu peso em quilos: ");
        double peso = Double.parseDouble(scanner.nextLine());
        a1.setPeso(peso);

        System.out.println("\nInforme sua altura em cm: ");
        double alt = Double.parseDouble(scanner.nextLine());
        a1.setAltura(alt);

        a1.setIdade(a.calculaIdade(logada));
        a1.setIMC(a.calculaIMC(a1));

        int opcAtiv = menuFatorAtividade();
        double fatorAtiv = a.fatorAtividade(opcAtiv);
        a1.setTMB(a.calculaTMB(a1, logada, fatorAtiv));

        System.out.println("\nInforme o tamanho do seu pescoco em cm: ");
        double pesc = Double.parseDouble(scanner.nextLine());
        a1.setPescoco(pesc);

        System.out.println("\nInforme o tamanho da sua cintura em cm: ");
        double cint = Double.parseDouble(scanner.nextLine());
        a1.setCintura(cint);

        System.out.println("\nInforme o tamanho do seu quadril em cm: ");
        double quadril = Double.parseDouble(scanner.nextLine());
        a1.setQuadril(quadril);

        a1.setBF(a.calculaBF(a1, logada));

        a1.setMassaGorda(a.calculaMassaGorda(a1));
        a1.setMassaMagra(a.calculaMassaMagra(a1, logada));

        System.out.println(a1.toString());

        return a1;
    }
    
    private int menuFatorAtividade() {
        StringBuilder builder = new StringBuilder("");
        builder.append("\nCom  relacao a atividade fisica voce se considera: ");
        builder.append("\n1 - Sedentario (pouco ou nenhum exercício);");
        builder.append("\n2 - Levemente ativo  (exercício leve 1 a 3 dias por semana);");
        builder.append("\n3 - Moderadamente ativo (exercício moderado 6 a 7 dias por semana);");
        builder.append("\n4 - Muito ativo (exercício intenso todos os dias ou exercício duas vezes ao dia);");
        builder.append("\n5 - Extra ativo (exercício muito difícil, treinamento ou trabalho físico)");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());
        int opc = Integer.parseInt(scanner.nextLine());
        return opc;
    }
}
