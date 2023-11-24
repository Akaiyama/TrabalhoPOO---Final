/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
import java.time.LocalDate;
/**
 *
 * @author mb780
 */
public class Post {
    /*Será possível postar informações (dieta, foto das refeições, resultados ou quaisquer coisas que a pessoa quiser). 
    Informações importantes: id, pessoa, conteudo da mensagem, dataCriacao, dataModificacao.*/
    private long id;
    private Pessoa pessoa;
    private String postagem;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private static long serialP;
    
    public Post(){
        Post.serialP = Post.serialP + 1;
        this.id = Post.serialP;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now(); 
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getPost() {
        return postagem;
    }

    public void setPost(String postagem) {
        this.postagem = postagem;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public long getId() {
        return id;
    }
    
     @Override
    public String toString() {
        return "\n========================================"
                + "\nPessoa: " + pessoa + "\nid: " + id + "\n Postagem: " + postagem
                + "\n dataCriacao: " + dataCriacao + ", dataModificacao: " + dataModificacao + '}';
    }
}
