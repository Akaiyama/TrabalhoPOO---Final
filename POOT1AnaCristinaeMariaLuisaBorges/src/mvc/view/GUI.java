/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import mvc.model.Alimento;
import mvc.model.AlimentoDAO;
import mvc.model.AlimentoRefeicao;
import mvc.model.AvaliacaoCalculos;
import mvc.model.AvaliacaoFisica;
import mvc.model.Dieta;
import mvc.model.Mensagem;
import mvc.model.Pessoa;
import mvc.model.PessoaDAO;
import mvc.model.Post;
import mvc.model.Refeicoes;
import mvc.model.Seguir;
import mvc.model.TipoDieta;

/**
 *
 * @author anath
 */
public class GUI {

    Scanner scanner = new Scanner(System.in);

    public int menuLogin() {
        StringBuilder builder = new StringBuilder("");
        builder.append("SEJA BEM VINDO AO MEU PROGRAMA\n\n");
        builder.append("0 - Para sair do programa");
        builder.append("\n1 - Login");
        builder.append("\n2 - Ainda nao e cadastrado\n");

        System.out.println(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public Pessoa criaPessoa() {
        Pessoa p1 = new Pessoa();
        System.out.println("\nCADASTRO");
        System.out.println("\nNome: ");
        String nome = scanner.nextLine();
        p1.setNome(nome);

        System.out.println("\nSexo - F para feminino ou M para masculino: ");
        String sexo = scanner.nextLine();
        p1.setSexo(sexo);

        System.out.println("\nInforme sua data de nascimento xx/xx/xxxx seguindo dia, mes e ano: ");
        String nasc = scanner.nextLine();
        LocalDate nascimento = LocalDate.parse(nasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        p1.setNascimento(nascimento);

        System.out.println("\nLogin: ");
        String login = scanner.nextLine();
        p1.setLogin(login);

        System.out.println("\nSenha: ");
        String senha = scanner.nextLine();
        p1.setSenha(senha);

        p1.setTipoUsuario("Comum");
        return p1;
    }

    public String login() {
        System.out.print("Login: ");
        return scanner.nextLine();
    }

    public String senha() {
        System.out.print("Senha: ");
        return scanner.nextLine();
    }

    public int MenuPrincipal() {
        StringBuilder builder = new StringBuilder("");

        builder.append("\n\nMENU PRINCIPAL\n\n");
        builder.append("\n1 - Perfil");
        builder.append("\n2 - Social");
        builder.append("\n3 - Dieta");
        builder.append("\n0 - Sair");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuPerfil() {
        StringBuilder builder = new StringBuilder("");

        builder.append("\n\nMENU PERFIL\n\n");
        builder.append("\n1 - Visualizar cadastro");
        builder.append("\n2 - Atualizar cadastro");
        builder.append("\n3 - Excluir perfil");
        builder.append("\n0 - Voltar");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public String alterarCadastro() {
        System.out.println("\n============> Alterando seu Login ==========>\n");
        System.out.println("\nInforme o novo login: ");
        String nome = scanner.nextLine();
        return nome;
    }

    public int excluirCadastro() {
        StringBuilder builder = new StringBuilder("");

        builder.append("\n============> Excluindo sua conta ==========>\n");
        builder.append("\nAtencao! Essa e uma acao permanente e todos os seus dados serao perdidos.");
        builder.append("\nDeseja realmente excluir sua conta?");
        builder.append("\n1 - Confirmar exclusao");
        builder.append("\n0 - Voltar");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());
        return Integer.parseInt(scanner.nextLine());
    }

    public int menuSocial() {
        StringBuilder builder = new StringBuilder("");

        builder.append("\n\nMENU SOCIAL\n\n");
        builder.append("\n1 - Seguir");
        builder.append("\n2 - Mensagens");
        builder.append("\n3 - Timeline");
        builder.append("\n0 - Voltar");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    /*public Mensagem criaMensagem() {

        System.out.println("\nPara quem voce quer mandar mensagem? ");
    }*/
    public int menuSeguir() {
        StringBuilder builder = new StringBuilder("");
        builder.append("\n1 - Seguir/ Deixar de seguir;");
        builder.append("\n2 - Seguindo;");
        builder.append("\n3 - Seguidores;");
        builder.append("\n0 - Voltar");
        System.out.println(builder.toString());
        int opc = Integer.parseInt(scanner.nextLine());
        return opc;

    }

    public Long seguir() {

        System.out.println("\nDigite o id do usuario:");
        Long id = Long.parseLong(scanner.nextLine());
        return id;
    }

    public int menuMensagem() {
        StringBuilder builder = new StringBuilder("");

        builder.append("\n1 - Mandar uma mensagem");
        builder.append("\n2 - Mensagens");
        builder.append("\n0 - Voltar");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuTimeline() {
        StringBuilder builder = new StringBuilder("");
        builder.append("\n1 - Postar;");
        builder.append("\n2 - Mostrar todos os posts");
        builder.append("\n0 - Voltar");
        System.out.println(builder.toString());
        int opc = Integer.parseInt(scanner.nextLine());
        return opc;
    }

    public Post postar(Pessoa logada) {
        Post p1 = new Post();
        System.out.println("\n============ POSTAGEM ============");
        p1.setPessoa(logada); // pessoa logada
        System.out.println("\nPostagem: ");
        String post = scanner.nextLine();
        p1.setPostagem(post);

        return p1;
    }

    public Mensagem mandarMensagem(Pessoa logada, PessoaDAO pessoaDAO) {
        Mensagem m = new Mensagem();
        System.out.println("\nInforme o id da pessoa para o qual você quer enviar a mensagem: ");
        Long id = Long.parseLong(scanner.nextLine());
        m.setPessoaDestino(pessoaDAO.buscaPorID(id));
        System.out.println("\nInforme a mensagem a ser enviada: ");
        String mensagem = scanner.nextLine();
        m.setMensagem(mensagem);
        m.setPessoaOrigem(logada);

        return m;
    }

    public int menuDieta() {
        StringBuilder builder = new StringBuilder("");

        builder.append("\n\nMENU SECAO DIETA \n\n");
        builder.append("\n1 - Avaliacao Fisica");
        builder.append("\n2 - Dieta");
        builder.append("\n3 - Refeicao");
        builder.append("\n0 - Voltar");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuAvaliacao() {
        StringBuilder builder = new StringBuilder("");

        builder.append("\n\nMENU AVALIACAO FISICA\n\n");
        builder.append("\n1 - Adicionar avaliacao;");
        builder.append("\n2 - Consultar avaliacoes;");
        builder.append("\n3 - Excluir avaliacao;");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());
        return Integer.parseInt(scanner.nextLine());
    }

    public AvaliacaoFisica criaAvaliacao(Pessoa logada) {
        AvaliacaoCalculos a = new AvaliacaoCalculos();
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

    public long excluirAvaliacao() {
        long id = -1;
        System.out.println("\nExcluir uma avaliacao fisica ira prejudicar o seu historico, "
                + "tem certeza que deseja excluir uma avaliacao fisica? \n1 - Sim\n2 - Cancelar");
        System.out.println("\nQual sua opcao ? R: ");
        int opc = Integer.parseInt(scanner.nextLine());

        if (opc == 1) {
            System.out.println("\nInforme o ID da avaliacao que deseja excluir: ");
            id = Long.parseLong(scanner.nextLine());
        } else {

        }
        return id;
    }

    public int menuDietaTipo() {
        StringBuilder builder = new StringBuilder("");
        builder.append("\n\nMENU DIETA");
        builder.append("\n1- Adicionar Dieta");
        builder.append("\n2 - Consultar Dieta");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());
        int opc = Integer.parseInt(scanner.nextLine());
        return opc;
    
    }
    
    public int objDieta() {
        StringBuilder builder = new StringBuilder("");
        builder.append("\nQual o tipo de dieta voce ira fazer agora: ");
        builder.append("\n1 - Equilibrada;");
        builder.append("\n2 - Low Carb;");
        builder.append("\n3 - Cetogênica;");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());
        int opc = Integer.parseInt(scanner.nextLine());
        return opc;
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

    public int nroRef() {
        
        StringBuilder builder = new StringBuilder("");
        builder.append("\n\nQuantas refeicoes ira fazer ao dia?");
        builder.append("\n3 - três refeicoes;");
        builder.append("\n4 - quatro refeicoes;");
        builder.append("\n5 - cinco refeicoes;");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());
        int numRef = Integer.parseInt(scanner.nextLine());
        
        return numRef;
    }

    public Refeicoes criaRefeicao(Dieta dieta) {
       Refeicoes refeicao = new Refeicoes();
       refeicao.setDieta(dieta);
        System.out.println("\nInforme o nome da refeicao que esta fazendo: ");
        String nome = scanner.nextLine();
       refeicao.setNomeRefeicao(nome);
       switch (dieta.getNroRefeicoes()) {
            case 3:
                refeicao.setCaloriaMAX(dieta.getCalorias()/3);
                break;
            case 4:
                refeicao.setCaloriaMAX(dieta.getCalorias()/4);
                break;
            case 5:
                refeicao.setCaloriaMAX(dieta.getCalorias()/5);
                break;
        }
        switch (dieta.getTipo().getNome()) {
            case "Equilibrada":
                refeicao.setCarbMAX(refeicao.getCalorias()*0.40);
                refeicao.setProMAX(refeicao.getCalorias()*0.30);
                refeicao.setGordMAX(refeicao.getCalorias()*0.30);           
                break;
            case "Low Carb":
                refeicao.setCarbMAX(refeicao.getCalorias()*0.30);
                refeicao.setProMAX(refeicao.getCalorias()*0.50);
                refeicao.setGordMAX(refeicao.getCalorias()*0.20);
                break;
            case "Cetogenica":
                refeicao.setCarbMAX(refeicao.getCalorias()*0.15);
                refeicao.setProMAX(refeicao.getCalorias()*0.15);
                refeicao.setGordMAX(refeicao.getCalorias()*0.70);
                break;
        }
        refeicao.setCarboidratos(0);
        refeicao.setGorduras(0);
        refeicao.setProteinas(0);
        
       return refeicao;
    }
    
    public AlimentoRefeicao criaAlimentoRefeicao(Refeicoes refeicao, AlimentoDAO alimentoDAO) {
        System.out.println("\nDigite o id do alimento que comeu: ");
        Long idAl = Long.parseLong(scanner.nextLine());
        AlimentoRefeicao alimentosRefeicao = new AlimentoRefeicao();
        Alimento alimento = alimentoDAO.buscaPorID(idAl);
        if (alimento != null) {
            alimentosRefeicao.setAlimento(alimento);
            alimentosRefeicao.setRefeicao(refeicao);
            alimentosRefeicao.setCalorias(alimentosRefeicao.getAlimento().getCalorias());
            alimentosRefeicao.setCarboidratos(alimentosRefeicao.getAlimento().getCarboidratos());
            alimentosRefeicao.setPorcao(100);
            alimentosRefeicao.setProteinas(alimentosRefeicao.getAlimento().getProteinas());
            alimentosRefeicao.setGorduras(alimentosRefeicao.getAlimento().getGorduras());
            refeicao.setCalorias(refeicao.getCalorias() + alimentosRefeicao.getCalorias());
            refeicao.setProteinas(refeicao.getProteinas() + alimentosRefeicao.getProteinas());
            refeicao.setCarboidratos(refeicao.getCarboidratos() + alimentosRefeicao.getCarboidratos());
            refeicao.setGorduras(refeicao.getGorduras() + alimentosRefeicao.getGorduras());
            return alimentosRefeicao;
        }else
        {
            return null;
        }
    }
    
    public Dieta criaDieta(int opcObj, Pessoa logada, AvaliacaoFisica av, TipoDieta tipo) {
        Dieta dieta = new Dieta(logada, av, tipo);
        dieta.setObjetivo(opcObj);
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

    public int MenuRefeicao() {
       
      StringBuilder builder = new StringBuilder("");
        builder.append("\n\nMENU REFEICAO");
        builder.append("\n1- Adicionar Refeicao");
        builder.append("\n2 - Consultar Refeicoes");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());
        int opc = Integer.parseInt(scanner.nextLine());
        return opc;
    }
}
