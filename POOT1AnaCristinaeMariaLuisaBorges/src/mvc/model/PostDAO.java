/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import mvc.model.Pessoa;
import mvc.model.Post;
import mvc.model.Seguir;

/**
 *
 * @author mb780
 */
public class PostDAO {

    Post[] posts = new Post[100];
    PessoaDAO pessoaDAO;
    SeguirDAO seguirDAO;

    public PostDAO() {
    }

    public PostDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
        seguirDAO = new SeguirDAO(pessoaDAO);

        Pessoa pessoa0 = pessoaDAO.getPessoas()[0];
        Post p1 = new Post();
        p1.setPessoa(pessoa0);
        p1.setPost("Vou compartilhar com vocês a minha jornada em busca por um corpo melhor e vou mostrar o processo para vocês!");
        adiciona(p1);

        Post p2 = new Post();
        p2.setPessoa(pessoa0);
        p2.setPost("""
                    Bom dia familia! Vim atualizar voces sobre a evolucao do shape da mae, da so uma olhada
                    *FOTO*""");
        adiciona(p2);

        Post p3 = new Post();
        p3.setPessoa(pessoa0);
        p3.setPost("Atualizacao final da minha evolucao: as dietas e as avaliacoes que fiz me ajudaram demais no processo.");
        adiciona(p3);

        Pessoa pessoa1 = pessoaDAO.getPessoas()[1];
        Post p4 = new Post();
        p4.setPessoa(pessoa1);
        p4.setPost("Ultimamente tenho seguido uma dieta para aumentar a minha massa muscular e estou tendo otimos resultados, se quiserem mais detalhes mando na dm!");
        adiciona(p4);

    }

    public Post[] getPosts() {
        return posts;
    }

    public SeguirDAO getSeguirDAO() {
        return seguirDAO;
    }

    //Busca postagem por ID
    public boolean buscaPost(int id) {
        for (Post post : posts) {
            if (post != null && post.getId() == id) {
                System.out.println(post);
                return true;
            }
        }
        System.out.println("Post nao encontrado.");
        return false;
    }

    //Edita post com busca por ID
    public boolean alteraPost(int id, String postagem) {
        for (Post post : posts) {
            if (post != null && post.getId() == id) {
                post.setPost(postagem);
                post.setDataModificacao(LocalDate.now());
                return true;
            }
        }
        System.out.println("Nao foi possivel alterar seu post.");
        return false;
    }

    //Cria nova postagem
     public Post inserirPost(Pessoa origem, String postagem) {
        Post post = new Post();
        for (Post p :posts) {
                post.setPessoa(origem);
                post.setPost(postagem);     
            }
        return post;
    }  
     
    public boolean adiciona(Post post) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            posts[proximaPosicaoLivre] = post;
            return true;
        } else {
            System.out.println("Nao foi possivel adicionar o post.");
            return false;
        }
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < posts.length; i++) {
            if (posts[i] == null) {
                return i;
            }
        }
        return -1;
    }

    //Exlui a postagem por ID
    public boolean excluirPost(int id) {
        for (int i = 0; i < posts.length; i++) {
            if (posts[i] != null && posts[i].getId() == id) {
                posts[i] = null;
                System.out.println("Post excluido com sucesso!");
                return true;
            }
        }
        System.out.println("Nao foi possivel excluir o post.");
        return false;
    }

    //Exibe todas as postagens sem detalhes
    public void mostrarTodosNormal() {
        boolean tem = false;
        for (Post post : posts) {
            if (post != null) {
                System.out.println(post.getPessoa().getNome() + "\n" + post.getPost() + "\n\n");
                tem = true;
            }
        }
        if (!tem) {
            System.out.println("Nao ha postagens dessa pessoa.");
        }
    }
    //Exibe todos os detalhes, incluindo o ID das postagens, para o usuário realizar a operação selecionada
    public void mostrarTodosDetalhado() {
        boolean tem = false;
        for (Post post : posts) {
            if (post != null) {
                System.out.println(post.toString() + "\n");
                tem = true;
            }
        }
        if (!tem) {
            System.out.println("Nao ha postagens dessa pessoa.");
        }
    }
}


