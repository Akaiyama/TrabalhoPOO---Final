/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;

import java.util.Scanner;
import mvc.model.Alimento;
import mvc.model.AlimentoDAO;
import mvc.model.AlimentoRefeicao;
import mvc.model.AlimentoRefeicaoDAO;
import mvc.model.AvaliacaoDAO;
import mvc.model.Avaliacao;
import mvc.model.Pessoa;
import mvc.model.PessoaDAO;
import mvc.model.Preferencias;
import mvc.model.PreferenciasDAO;
import mvc.model.Refeicoes;
import mvc.model.RefeicoesDAO;
import mvc.model.Dieta;
import mvc.model.DietaDAO;
import mvc.model.TipoDieta;
import mvc.model.TipoDietaDAO;
import mvc.model.Mensagem;
import mvc.model.MensagemDAO;
import mvc.model.Seguir;
import mvc.model.SeguirDAO;
import mvc.model.Post;
import mvc.model.PostDAO;
import mvc.view.GUIMain;

/**
 *
 * @author Ana Cristina e Maria Luisa
 */
public class controlMain {

    GUIMain gui = new GUIMain();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private AlimentoDAO alimentoDAO = new AlimentoDAO();
    private AlimentoRefeicaoDAO alimRefDAO = new AlimentoRefeicaoDAO();
    private AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO(pessoaDAO);
    private TipoDietaDAO tipoDAO = new TipoDietaDAO();
    private DietaDAO dietaDAO = new DietaDAO(pessoaDAO, avaliacaoDAO, tipoDAO);
    private RefeicoesDAO refeicoesDAO = new RefeicoesDAO();
    private PreferenciasDAO preferenciasDAO = new PreferenciasDAO();
    private MensagemDAO mensagemDAO = new MensagemDAO(pessoaDAO, pessoaDAO);
    private SeguirDAO seguindoDAO = new SeguirDAO(pessoaDAO);
    private PostDAO postsDAO = new PostDAO(pessoaDAO);
    Scanner scanner = new Scanner(System.in);

    public controlMain() {

        int opc = -1;
        do {
            opc = gui.menuBoasVindas();
            switch (opc) {
                case 0:
                    gui.encerrar();
                    break;
                case 1:
                    String login = gui.login();
                    String senha = gui.senha();
                    Pessoa logada = pessoaDAO.buscaPessoaLogin(login, senha);

                    if (logada != null) {
                        int opcMenu = 10;
                        do {
                            //colocar timeline aqui
                            
                            opcMenu = gui.menuPrincipal();
                            switch (opcMenu) {
                                case 0:
                                    gui.encerrar();
                                    opc = 0;
                                    break;
                                case 1:
                                    Pessoa mostrarPessoa = pessoaDAO.buscaPorNome(logada.getNome());
                                    System.out.println(mostrarPessoa.toString());
                                    break;
                                case 2:
                                    String novoNome = gui.alterarPessoa();
                                    if (pessoaDAO.alterarNome(logada.getNome(), novoNome)) {
                                        System.out.println("\nNome alterado com sucesso, " + logada.getNome());
                                    } else {
                                        gui.erro();
                                    }
                                    break;
                                case 3:
                                    int opcAv = gui.menuAvaliacao();
                                    avaliacao(opcAv, logada);
                                    break;
                                case 4:
                                    int opcD = gui.menuDieta();
                                    dieta(opcD, logada);
                                    break;
                                case 5:
                                    int opcPref = gui.menuPreferencias();
                                    preferencia(opcPref, logada);
                                    break;
                                case 6:
                                    String resp = gui.excluiPessoa(logada);
                                    if (pessoaDAO.remover(resp)) {
                                        System.out.println("\nConta excluida com sucesso!");
                                        opcMenu = 0;
                                        opc = 0;
                                        gui.encerrar();
                                    } else {
                                        gui.erro();
                                    }
                                    break;
                                case 7:
                                    int opcSeguir = gui.menuSeguir();
                                    String nome;
                                    Seguir s3 = new Seguir();

                                    switch (opcSeguir) {
                                        case 1:
                                            //  String nome;
                                            System.out.println("Digite o nome da pessoa que voce quer comecar a seguir:");
                                            nome = scanner.nextLine();

                                            boolean check = false;

                                            Pessoa p = pessoaDAO.buscaPorNome(nome);
                                            if (p == null) {
                                                System.out.println("essa pessoa nao existe");
                                            } else {
                                                s3.setPessoaOrigem(logada);
                                                s3.setPessoaDestino(p);

                                                check = seguindoDAO.começarASeguir(logada, p);
                                                if (check == true) {
                                                    System.out.println("Pronto, agora voce segue essa pessoa");
                                                } else {
                                                    System.out.println("Voce ja segue essa pessoa");
                                                }
                                            }
                                            break;

                                        case 2:
                                            System.out.println("Digite o nome da pessoa que voce quer deixar de seguir:");
                                            nome = scanner.nextLine();

                                            Pessoa p1 = pessoaDAO.buscaPorNome(nome);
                                            s3.setPessoaOrigem(logada);
                                            s3.setPessoaDestino(p1);

                                            check = seguindoDAO.deixarDeSeguir(logada, p1);
                                            if (check == true) {
                                                System.out.println("Pronto, deixou de seguir essa pessoa");
                                            } else {
                                                System.out.println("Voce nao segue essa pessoa");
                                            }

                                            break;

                                        case 3:
                                            seguindoDAO.mostrarTodos(logada);
                                            break;

                                        case 0:
                                            break;
                                    }
                                    break;
                                case 8:
                                    int opcMensagem = gui.menuMensagens();
                                    
                                    switch (opcMensagem) {
                                        case 1:
                                            System.out.println("Destinatario:");
                                            String destinatario = scanner.nextLine();
                                            System.out.println("Digite o conteudo da mensagem:");
                                            String mensagem = scanner.nextLine();
                                            
                                            if (destinatario == null || mensagem == null) {
                                                System.out.println("Nao foi possivel enviar essa mensagem.");
                                            } else {
                                                Pessoa p2 = pessoaDAO.buscaPorNome(destinatario);
                                                Mensagem m = mensagemDAO.mandarMensagem(logada, p2, mensagem);
                                                mensagemDAO.adicionaMensagem(m);
                                            }
                                            break;
                                        case 2:
                                            mensagemDAO.mostrarTodos();
                                            break;

                                        case 0:
                                            break;
                                    }
                                    break;
                                case 9:
                                    int opcPost = gui.menuPostagem();
                                    
                                    switch(opcPost){
                                        case 1:
                                            System.out.println("Insira o seu novo post:");
                                            String postagem = scanner.nextLine();
                                            Post post = postsDAO.inserirPost(logada, postagem);
                                            postsDAO.adiciona(post);
                                            break;
                                        case 2:
                                            postsDAO.mostrarTodosDetalhado();
                                            System.out.println("Insira o id do post que voce deseja alterar:");
                                            String id = scanner.nextLine();
                                            
                                            System.out.println("Insira a nova postagem:");
                                            postagem = scanner.nextLine();
                                            int ID = Integer.parseInt(id);
                                            postsDAO.alteraPost(ID, postagem);
                                            break;
                                        case 3:
                                            postsDAO.mostrarTodosDetalhado();
                                            System.out.println("Insira o id do post que voce deseja excluir:");
                                            id = scanner.nextLine();
                                            ID = Integer.parseInt(id);
                                            postsDAO.excluirPost(ID);
                                            break;
                                        case 4:
                                            postsDAO.mostrarTodosNormal();
                                            break;
                                            
                                        case 0:
                                            break;
                                    }
                                    break;

                            }
                        } while (opcMenu != 0);
                    } else {
                        System.out.println("\n===================\nLogin Invalido, tente novamente\n====================\n");
                    }
                    break;

                case 2:
                    Pessoa pessoa = gui.criaPessoa();

                    if (pessoaDAO.adiciona(pessoa)) {
                        System.out.println("\nCadastro realizado com sucesso!");
                    } else {
                        gui.erro();
                    }
                    break;

                case 3:
                    System.out.println("Login admin");
                    login = gui.login();
                    senha = gui.senha();
                    logada = pessoaDAO.buscaPessoaLoginAdmin(login, senha);

                    if (logada != null) {
                        int opcMenu = 0;
                        do {
                            opcMenu = gui.menuPrincipalAdmin();
                            switch (opcMenu) {
                                case 0:
                                    gui.encerrar();
                                    opcMenu = 10;
                                    opc = 0;
                                    break;
                                case 1:
                                    int opcMenuAlimentos = gui.menuAlimentos();
                                    alimento(opcMenuAlimentos, logada);
                                    break;
                                case 10:
                                    break;
                                default:
                                    gui.invalido();
                            }
                        } while (opcMenu != 10);
                    } else {
                        System.out.println("\n===================\nLogin Invalido, tente novamente\n====================\n");
                    }

                    break;

                default:
                    gui.invalido();
            }
        } while (opc != 0);
    }

    public static void main(String[] args) {
        new controlMain();
    }

    private void preferencia(int opc, Pessoa logada) {
        switch (opc) {
            case 1:
                alimentoDAO.mostrarTodos();
                String nomeAlimento = gui.criarPreferencia();
                Alimento buscaNome = alimentoDAO.buscaPorNome(nomeAlimento);
                if (buscaNome == null) {
                    gui.requisicoes(nomeAlimento);
                    System.out.println("\nAinda nao temos esse alimento cadastrado em nosso sistema, mas ja abrimos uma requisicao para nossos desenvolvedores adicionaram. Tente novamente em breve!");
                } else {
                    Preferencias p1 = new Preferencias(logada);
                    p1.setAlimento(buscaNome);
                    if (preferenciasDAO.adiciona(p1)) {
                        System.out.println("\nPreferencia adicionada com sucesso");
                    } else {
                        System.out.println("\nPreferencia nao adicionada");
                    }
                }
                break;
            case 2:
                preferenciasDAO.mostrarTodos();
                break;
            case 3:
                nomeAlimento = gui.excluirPreferencia();
                buscaNome = alimentoDAO.buscaPorNome(nomeAlimento);
                if (buscaNome == null) {
                    gui.requisicoes(nomeAlimento);
                    System.out.println("\nAinda nao temos esse alimento cadastrado em nosso sistema, mas ja abrimos uma requisicao para nossos desenvolvedores adicionaram. Tente novamente em breve!");
                } else {
                    if (preferenciasDAO.remover(buscaNome)) {
                        System.out.println("\nPreferencia do alimento " + nomeAlimento + " excluido com sucesso!");
                    } else {
                        gui.erro();
                    }

                }
                break;
            case 10:
                break;
            default:
                gui.invalido();
        }

    }

    private void alimento(int opcMenuAlimentos, Pessoa logada) {
        switch (opcMenuAlimentos) {
            case 1:
                Alimento alimento = gui.criaAlimento();

                if (alimentoDAO.adiciona(alimento)) {

                    System.out.println("\nAlimento adicionado com sucesso");
                } else {
                    System.out.println("\nAlimento nao adicionado");
                }

                break;
            case 2:
                String nome = gui.buscarAlimento();
                Alimento mudaNome = alimentoDAO.buscaPorNome(nome);
                if (mudaNome == null) {
                    System.out.println("\nAlimento nao encontrado, impossivel trocar o nome");
                } else {
                    String novoNome = gui.alterarAlimento(nome);
                    if (alimentoDAO.alterarNome(nome, novoNome)) {
                        System.out.println("\nNome alterado com sucesso, " + logada.getNome());
                    } else {
                        gui.erro();
                    }
                }
                break;
            case 3:
                nome = gui.buscarAlimento();
                Alimento buscaNome = alimentoDAO.buscaPorNome(nome);
                if (buscaNome == null) {
                    System.out.println("\nAlimento nao encontrado");
                } else {
                    System.out.println(buscaNome.toString());
                }
                break;
            case 4:
                alimentoDAO.mostrarTodos();
                break;
            case 5:
                nome = gui.excluirAlimento();
                buscaNome = alimentoDAO.buscaPorNome(nome);
                if (buscaNome == null) {
                    System.out.println("\nAlimento nao encontrado");
                } else {
                    if (alimentoDAO.remover(nome)) {
                        System.out.println("\nAlimento " + nome + " excluido com sucesso!");

                    } else {
                        gui.erro();
                    }
                }

                break;
            case 10:
                break;
            default:
                gui.invalido();
        }
    }

    private void avaliacao(int opcAv, Pessoa logada) {

        switch (opcAv) {
            case 1:
                Avaliacao avaliacao = gui.criaAvaliacao(logada);
                avaliacaoDAO.adiciona(avaliacao);
                break;
            case 2:
                avaliacaoDAO.mostrarTodos(logada);
                break;
            case 3:
                long idBusca = gui.pegaIDavaliacao();
                Avaliacao alterar = avaliacaoDAO.buscaPorID(idBusca);
                if (alterar != null) {
                    double novoPeso = gui.alterarAvaliacao(alterar);
                    if (avaliacaoDAO.alterar(idBusca, novoPeso, logada)) {
                        System.out.println("\nAlteracao feita com sucesso! ");
                    } else {
                        gui.erro();

                    }

                } else {
                    gui.erro();
                }
                break;
            case 4:
                long id = gui.excluirAvaliacao();
                if (avaliacaoDAO.remover(id)) {
                    System.out.println("\nAvaliacao " + id + " excluida com sucesso!");
                } else {
                    gui.erro();
                }
                break;
            case 10:
                break;
            default:
                gui.invalido();
        }
    }

    private void dieta(int opcD, Pessoa logada) {
        switch (opcD) {
            case 1:
                int opcTipoD = gui.objDieta();
                TipoDieta tipo = criaTipoDieta(opcTipoD);
                if (tipoDAO.adiciona(tipo)) {
                    System.out.println("\nTipo de dieta adicionado");
                    int opcObj = gui.menuObjetivoDieta();
                    avaliacaoDAO.mostrarTodos(logada);
                    long idAv = gui.pegaAvaliacao();
                    Avaliacao avaliacao = avaliacaoDAO.buscaPorID(idAv);
                    if (avaliacao != null) {
                        Dieta dieta = gui.criaDieta(opcObj, logada, avaliacao, tipo);
                        dietaDAO.adiciona(dieta);
                    } else {
                        System.out.println("\nAvaliacao invalida!\n Consulte as avaliacoes disponiveis e tente novamente...");
                    }

                }
                break;
            case 2:
                dietaDAO.mostrarTodos(logada);
                break;
            case 3:
                dietaDAO.mostrarTodos(logada);
                long id = gui.pegaDieta();
                Dieta dieta = dietaDAO.buscaPorID(id);

                if (dieta != null) {
                    int opcRe = gui.menuRefeicao();
                    refeicao(opcRe, logada, dieta);
                } else {
                    System.out.println("\nDieta invalida! Consulte as dietas disponiveis e tente novamente");
                }
                break;
            case 4:
                refeicoesDAO.mostrarTodos();
                break;
            case 5:
                long idDieta = gui.excluirDieta();
                dietaDAO.remover(idDieta);
                break;
            default:
                gui.erro();
        }

    }

    private TipoDieta criaTipoDieta(int opc) {
        TipoDieta tipo = new TipoDieta();
        tipo.setNome(opc);
        return tipo;
    }

    private void refeicao(int opcRe, Pessoa logada, Dieta dieta) {
        Refeicoes refeicao = gui.criaRefeicao(opcRe, dieta);

        if (refeicoesDAO.adiciona(refeicao)) {
            alimentoDAO.mostrarTodos();

            while (refeicao.getCalorias() <= refeicao.getCaloriaMAX()) {
                AlimentoRefeicao ali = gui.criaAlimentoRefeicao(refeicao, alimentoDAO);
                if (ali != null) {
                    alimRefDAO.adiciona(ali);
                    System.out.println("\nAlimento adicionado a refeicao, calculando se você ainda pode comer mais nessa refeicao...");
                    System.out.println(refeicao.toString() + "\n");
                    alimRefDAO.mostrarTodos();
                } else {
                    System.out.println("\nAlgo deu errado, tente novamente");

                }
            }
        } else {
            gui.erro();
        }

    }
}
