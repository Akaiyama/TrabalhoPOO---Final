/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
import java.time.LocalDate;
import java.time.Month;
import mvc.control.controlMain;

/**
 *
 * @author  Ana Cristina e Maria Luisa
 */
public class PessoaDAO {
    Pessoa[] pessoas = new Pessoa[50];
    
    public PessoaDAO(){
        Pessoa p1 = new Pessoa();
        p1.setNome("Ana");
        p1.setSexo("F");
        p1.setNascimento(LocalDate.of(1998, Month.AUGUST, 11));
        p1.setTipoUsuario("Admin");
        p1.setLogin("ana");
        p1.setSenha("teste");
        
        this.adiciona(p1);
        
        Pessoa p2 = new Pessoa();
        p2.setNome("Maria");
        p2.setSexo("F");
        p2.setNascimento(LocalDate.of(2003, Month.NOVEMBER, 9));
        p2.setTipoUsuario("Admin");
        p2.setLogin("maria");
        p2.setSenha("teste");
        
        this.adiciona(p2);
        
    }
    
    public Pessoa buscaPessoaLogin(String login, String senha){
        for (Pessoa pessoa : pessoas) {
            if(pessoa != null && pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)){
                return pessoa;
            }
        }
        return null;
    }
    
    public Pessoa buscaPessoaLoginAdmin(String login, String senha){
        for (Pessoa pessoa : pessoas) {
            if(pessoa != null && pessoa.getLogin().equals(login) && 
                    pessoa.getSenha().equals(senha) && 
                    pessoa.getTipoUsuario().equalsIgnoreCase("Admin")){
                return pessoa;
            }
        }
        return null;
    }
    public boolean adiciona(Pessoa pessoa) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            pessoas[proximaPosicaoLivre] = pessoa;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temPessoa = false;
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                System.out.println(pessoa);
                temPessoa = true;
            }
        }
        if (!temPessoa) {
            System.out.println("não existe pessoa cadastrada");
        }
    }

    public boolean alterarNome(String nome, String novoNome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null && pessoa.getNome().equals(nome)) {
                pessoa.setNome(novoNome);
                return true;
            }
        }
        return false;

    }

    public Pessoa buscaPorNome(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null && pessoa.getNome().equals(nome)) {
                return pessoa;
            }
        }
        return null;
    }

    public boolean remover(String nome) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equals(nome)) {
                pessoas[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                return i;
            }
        }
        return -1;

    }
}
