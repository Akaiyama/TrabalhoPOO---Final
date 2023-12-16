/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import mvc.model.Post;
import mvc.model.PostDAO;
import mvc.model.Pessoa;
import mvc.model.PessoaDAO;

/**
 *
 * @author mb780
 */
public class TestePost {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        new TestePost();
    }
    
    public TestePost(){
        List<Post> posts = null;
        PostDAO postDAO = new PostDAO();
        
       //postDAO.adicionaERetornaId(this.adicionarPost());
         
       //posts = postDAO.mostrarTodos(null);
       //this.imprimeLista(posts);
         
       Post a = postDAO.buscaPorID(1);
       System.out.println("Post retornado: ");
       System.out.println(a);
        
       //Post p = postDAO.exclui(this.obtemExemploExclui());
       //System.out.println("\n\nDado excluído:");
       
       Post p = postDAO.altera(postDAO.buscaPorID(1), "Cansada");
        
    }

    private void imprimeLista(List<Post> posts) {
        for (Post p : posts) {
         System.out.println(p);
         }
    }
    
    private Post obtemExemploExclui() {
        Post p = new Post();
        p.setId(3);
        return p;
    }
    
    private Post adicionarPost() {
        return criaPost();
    }
    
   public Post criaPost() {
        Post p1 = new Post();
        PessoaDAO p = new PessoaDAO();
        Pessoa pessoa = p.buscaPorID(2);
        System.out.println("\n============ POSTAGEM ============");
        p1.setPessoa(pessoa); // pessoa logada
        System.out.println("\nPostagem: ");
        String post = scanner.nextLine();
        p1.setPostagem(post);
 
        return p1;
    }   
}