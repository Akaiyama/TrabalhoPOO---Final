/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author mb780
 */
public class PostDAO {

    Post[] posts = new Post[100];

    public PostDAO() {
    }

    public PostDAO(PessoaDAO pessoa, DietaDAO dieta, AvaliacaoDAO avaliacao) {
        Pessoa p1 = pessoa.buscaPessoaLogin("ana", "teste");

        Post po1 = new Post();
        po1.setPessoa(p1);
        po1.setPost("Vou compartilhar com vocês a minha jornada em busca por um corpo melhor e vou mostrar o processo para vocês!");
        this.adiciona(po1);
        
        Post po2 = new Post();
        po2.setPessoa(p1);
        po2.setPost("""
                    Bom dia familia! Vim atualizar voces sobre a evolucao do shape da mãe, da so uma olhada
                    *FOTO*""");
        this.adiciona(po1);
        
        Post po3 = new Post();
        po3.setPessoa(p1);
        po3.setPost("Atualização final da minha evolução: as dietas e as avaliações que fiz me ajudaram demais no processo.");
       
        this.adiciona(po1);
        
    }  
    
    public boolean adiciona(Post post) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            posts[proximaPosicaoLivre] = post;
            return true;
        } else {
            return false;
        }
    }

    public boolean ehVazio() {
        for (Post post : posts) {
            if (post != null) {
                return false;
            }
        }
        return true;
    }

    public void mostrarTodos() {
        boolean tem = false;
        for (Post post : posts) {
            if (post != null) {
                System.out.println(post.toString());
                tem = true;
            }
        }
        if (!tem) {
            System.out.println("Não há postagens dessa pessoa.");
        }
    }
    
    public boolean alterarPost(long id, String novoPost){
        for (Post post : posts) {
            if (post != null && post.getId() == id) {
                post.setPost(novoPost);
            }
            return true;
        }
        return false;
    }

    public boolean remover(String post) {
        for (int i = 0; i < posts.length; i++) {
            if (posts[i] != null && posts[i].getPost().equals(post)) {
                posts[i] = null;
                return true;
            }
        }
        return false;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < posts.length; i++) {
            if (posts[i] == null) {
                return i;
            }
        }
        return -1;

    }

}
