/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;

import java.util.List;
import java.util.Scanner;
import mvc.model.Alimento;
import mvc.model.AlimentoDAO;
import mvc.model.AlimentoRefeicao;
import mvc.model.AlimentoRefeicaoDAO;
import mvc.model.AvaliacaoFisica;
import mvc.model.AvaliacaoFisicaDAO;
import mvc.model.Dieta;
import mvc.model.DietaDAO;
import mvc.model.Mensagem;
import mvc.model.MensagemDAO;
import mvc.model.Pessoa;
import mvc.model.PessoaDAO;
import mvc.model.Post;
import mvc.model.PostDAO;
import mvc.model.Refeicoes;
import mvc.model.RefeicoesDAO;
import mvc.model.Seguir;
import mvc.model.SeguirDAO;
import mvc.model.TipoDieta;
import mvc.model.TipoDietaDAO;
import mvc.view.GUI;

/**
 *
 * @author anath
 */
public class Main {

    GUI gui = new GUI();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private AlimentoDAO alimentoDAO = new AlimentoDAO();
    private AlimentoRefeicaoDAO alimentoRefDAO = new AlimentoRefeicaoDAO();
    private AvaliacaoFisicaDAO avaliacaoDAO = new AvaliacaoFisicaDAO();
    private TipoDietaDAO tipoDAO = new TipoDietaDAO();
    private DietaDAO dietaDAO = new DietaDAO();
    private RefeicoesDAO refeicoesDAO = new RefeicoesDAO();
    private MensagemDAO mensagemDAO = new MensagemDAO();
    private SeguirDAO seguirDAO = new SeguirDAO();
    private PostDAO postDAO = new PostDAO();
    Scanner scanner = new Scanner(System.in);

    public Main() {
        int opc = -1;
        do {
            opc = gui.menuLogin();
            switch (opc) {
                case 0:
                    System.out.println("Finalizando aplicacao");
                    break;
                case 1:
                    System.out.println("\n============> Passando para a tela de Login==========>\n");
                    String login = gui.login();
                    String senha = gui.senha();

                    Pessoa logada = pessoaDAO.login(login, senha);

                    if (logada.getNome() == null) {
                        System.out.println("\n===================\nLogin Invalido, tente novamente\n====================\n");
                        

                    } else {

                        System.out.println("Bem-vindo(a), " + logada.getNome() + "!");
                        System.out.println("\n============> Passando para a tela de Menu==========>\n");
                        MenuLogado(logada);

                    }
                    break;
                case 2:
                    System.out.println("\n============> Passando para a tela de cadastro==========>\n");
                    Pessoa pessoa = gui.criaPessoa();

                    try {
                        pessoaDAO.adicionaERetornaId(pessoa);
                    } catch (Exception e) {
                        System.out.println("Erro ao realizar o cadastro, tente novamente");
                    }

                    break;
                default:
                    throw new AssertionError("Opcao invalida");
            }
        } while (opc != 0);
    }

    public static void main(String[] args) {
        new Main();
    }

    private void MenuLogado(Pessoa logada) {
        int opc = 0;
        do {
            opc = gui.MenuPrincipal();
            switch (opc) {
                case 0:
                    System.out.println("\nDeslogando...\n\n\n");
                    break;
                case 1:
                    menuPerfil(logada);
                    break;
                case 2:
                    menuSocial(logada);
                    break;
                case 3:
                    menuDieta(logada);
                    break;

                default:
                    throw new AssertionError("Opcao invalida");
            }
        } while (opc != 0);
    }

    private void menuPerfil(Pessoa logada) {
        System.out.println("\n============> Passando para o menu de Perfil ==========>\n");
        int opc = 0;
        do {
            opc = gui.menuPerfil();
            switch (opc) {
                case 0:
                    break;
                case 1:
                    System.out.println(pessoaDAO.buscaPorID(logada.getId()));
                    break;
                case 2:
                    String dado = gui.alterarCadastro();
                    pessoaDAO.altera(logada, dado);
                    break;
                case 3:
                    int excluir = gui.excluirCadastro();
                    if (excluir == 1) {
                        pessoaDAO.exclui(logada);
                        System.exit(0);
                    }
                    break;

                default:
                    throw new AssertionError("Opcao invalida");
            }
        } while (opc != 0);
    }

    private void menuSocial(Pessoa logada) {
        System.out.println("\n============> Passando para o menu Social ==========>\n");
        int opc = 0;
        do {
            opc = gui.menuSocial();
            switch (opc) {
                case 0:
                    break;
                case 1:
                    System.out.println("\n============> Passando para o menu Seguir ==========>\n");
                    int opcSeguir = gui.menuSeguir();
                    switch (opcSeguir) {
                        case 0:
                            break;
                        case 1:
                            Long idPessoaProcurada = gui.seguir();
                            Seguir s = seguirDAO.buscaPorID(idPessoaProcurada, logada);
                            if (s != null) {
                                System.out.println("Deixando de seguir");
                                seguirDAO.exclui(s);
                            } else {
                                System.out.println("Comecando a seguir");
                                s = comecarSeguir(logada, idPessoaProcurada);
                                seguirDAO.adicionaERetornaId(s);
                            }
                            break;
                        case 2:
                            List<Seguir> seguidos = null;
                            seguidos = seguirDAO.buscaPorIDSeguidores(logada);
                            Seguidores(seguidos);
                            break;
                        case 3:
                            List<Seguir> seguidores = null;
                            seguidores = seguirDAO.buscaPorIDSeguidores(logada);
                            Seguidores(seguidores);
                            break;
                        default:
                            throw new AssertionError("Opcao invalida");
                    }
                    break;
                case 2:
                    System.out.println("\n============> Passando para o menu Mensagens ==========>\n");
                    int opcMens = gui.menuMensagem();
                    switch (opcMens) {
                        case 1:
                            Mensagem m = gui.mandarMensagem(logada, pessoaDAO);
                            verificaPodeMandar(m);
                            break;
                        case 2:
                            List<Mensagem> mensagens = null;
                            mensagens = mensagemDAO.mostrarTodos(null, pessoaDAO.buscaPorID(1));
                            CaixaDeEntrada(mensagens);
                            break;
                        default:
                            throw new AssertionError("Opcao invalida");
                    }
                    break;
                case 3:

                    System.out.println("\n============> Passando para o menu Timeline ==========>\n");
                    int opcTime = gui.menuTimeline();
                    switch (opcTime) {
                        case 0:
                            break;
                        case 1:
                            postDAO.adicionaERetornaId(gui.postar(logada));
                            break;
                        case 2:
                            List<Post> posts = null;
                            posts = postDAO.mostrarTodos(null);
                            timeline(posts);
                            break;
                        default:
                            throw new AssertionError("Opcao invalida");
                    }
                    break;
                default:
                    throw new AssertionError("Opcao invalida");
            }
        } while (opc != 0);
    }

    private void menuDieta(Pessoa logada) {
        System.out.println("\n============> Passando para o menu de Dieta ==========>\n");
        int opc = 0;
        do {
            opc = gui.menuDieta();
            switch (opc) {
                case 0:
                    break;
                case 1:
                    System.out.println("\n============> Passando para o menu Avaliacao Fisica ==========>\n");
                    int opcMenuAv = gui.menuAvaliacao();

                    switch (opcMenuAv) {
                        case 0:
                            break;
                        case 1:
                            AvaliacaoFisica av = gui.criaAvaliacao(logada);
                            avaliacaoDAO.adicionaERetornaId(av);
                            break;
                        case 2:

                            List<AvaliacaoFisica> avaliacoes = null;
                            avaliacoes = avaliacaoDAO.mostrarTodos(null, logada);
                            this.relatorioAvaliacoes(avaliacoes);
                            break;
                        case 3:
                            Long idAv = gui.excluirAvaliacao();
                            if (idAv != -1) {
                                avaliacaoDAO.exclui(avaliacaoDAO.buscaPorID(idAv));
                            }

                            break;
                        default:
                            throw new AssertionError("Opcao invalida");
                    }
                    break;
                case 2:
                    System.out.println("\n============> Passando para o menu Dieta ==========>\n");
                    int opcMenuDie = gui.menuDietaTipo();

                    switch (opcMenuDie) {
                        case 0:
                            break;
                        case 1:
                            TipoDieta tipo = new TipoDieta();
                            tipo.setNome(gui.objDieta());
                            tipoDAO.adicionaERetornaId(tipo);
                            System.out.println("\nEscolha o id da avaliacao para seguir nessa dieta");
                            List<AvaliacaoFisica> avaliacoes = null;
                            avaliacoes = avaliacaoDAO.mostrarTodos(null, logada);
                            this.relatorioAvaliacoes(avaliacoes);
                            Long idAv = Long.parseLong(scanner.nextLine());

                            dietaDAO.adicionaERetornaId(gui.criaDieta(gui.menuObjetivoDieta(), logada, avaliacaoDAO.buscaPorID(idAv), tipo));
                            break;
                        case 2:

                            List<Dieta> dietas = null;
                            dietas = dietaDAO.mostrarTodos(null, logada);
                            listaDietas(dietas);

                            break;
                        default:
                            throw new AssertionError("Opcao invalida");
                    }
                    break;
                case 3:
                    System.out.println("\n============> Passando para o menu Refeicao ==========>\n");
                    int opcMenuRef = gui.MenuRefeicao();

                    switch (opcMenuRef) {
                        case 1:
                            List<Dieta> dietas = null;
                            System.out.println("\nEscolha o id da dieta dessa refeicao: ");
                            dietas = dietaDAO.mostrarTodos(null, logada);
                            listaDietas(dietas);

                            Long idDiet = Long.parseLong(scanner.nextLine());
                            Dieta dieta = dietaDAO.buscaPorID(idDiet);

                            Refeicoes refeicao = gui.criaRefeicao(dieta);

                                                        refeicoesDAO.adicionaERetornaId(refeicao);
                                List<Alimento> alimentos = null;
                                alimentos = alimentoDAO.mostrarTodos(null);
                                listaAlimentos(alimentos);

                                while (refeicao.getCalorias() <= refeicao.getCaloriaMAX()) {
                                    AlimentoRefeicao ali = gui.criaAlimentoRefeicao(refeicao, alimentoDAO);
                                    
                                        alimentoRefDAO.adicionaERetornaId(ali);
                                        System.out.println("\nAlimento adicionado a refeicao, calculando se você ainda pode comer mais nessa refeicao...");
                                        System.out.println(refeicao.toString() + "\n");
                                        List<AlimentoRefeicao> alimentosRef = null;
                                        alimentosRef = alimentoRefDAO.mostrarTodos(null, refeicao);
                                        listaAlimentosRefeicao(alimentosRef);

                                    
                                }

                            break;
                        case 2:
                            List<Refeicoes> refeicoes = null;

                            refeicoes = refeicoesDAO.mostrarTodos(null);
                            listRefeicoes(refeicoes);
                            break;

                        default:
                            throw new AssertionError("Opcao invalida");
                    }
            }
        } while (opc != 0);
    }

    private void Seguidores(List<Seguir> seguidores) {
        for (Seguir s : seguidores) {
            System.out.println(s);
        }
    }

    private void timeline(List<Post> posts) {
        for (Post p : posts) {
            System.out.println(p);
        }
    }

    private Seguir comecarSeguir(Pessoa logada, Long idPessoaProcurada) {
        Seguir s = new Seguir();
        s.setPessoaOrigem(logada);
        s.setPessoaDestino(pessoaDAO.buscaPorID(idPessoaProcurada));

        return s;
    }

    private void CaixaDeEntrada(List<Mensagem> mensagens) {
        for (Mensagem m : mensagens) {
            System.out.println(m);
        }
    }

    private void verificaPodeMandar(Mensagem m) {
        if (seguirDAO.buscaPorID(m.getPessoaOrigem().getId(), m.getPessoaDestino()) == null
                || seguirDAO.buscaPorID(m.getPessoaDestino().getId(), m.getPessoaOrigem()) == null) {
            System.out.println("Voce nao pode mandar mensagem para quem nao te segue ou voce nao segue");
        } else {
            mensagemDAO.adicionaERetornaId(m);
        }
    }

    private void relatorioAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
        for (AvaliacaoFisica av : avaliacoes) {
            System.out.println(av);
        }
    }

    private void listaDietas(List<Dieta> dietas) {
        for (Dieta d : dietas) {
            System.out.println(d);
        }
    }

    private void listRefeicoes(List<Refeicoes> refeicoes) {
        for (Refeicoes r : refeicoes) {
            System.out.println(r);
        }
    }

    private void listaAlimentos(List<Alimento> alimentos) {
        for (Alimento a : alimentos) {
            System.out.println(a);
        }
    }

    private void listaAlimentosRefeicao(List<AlimentoRefeicao> alimentos) {
        for (AlimentoRefeicao ar : alimentos) {
            System.out.println(ar);
        }
    }

}
