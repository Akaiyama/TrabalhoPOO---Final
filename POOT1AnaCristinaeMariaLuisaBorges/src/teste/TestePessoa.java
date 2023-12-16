/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import mvc.model.Pessoa;
import mvc.model.PessoaDAO;
/**
 *
 * @author mb780
 */
public class TestePessoa {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        new TestePessoa();
    }
    
    public TestePessoa(){
        List<Pessoa> pessoas = null;
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        //pessoaDAO.adicionaERetornaId(this.adicionarPessoa());
         
        //pessoas = pessoaDAO.mostrarTodos(null);
        //this.imprimeLista(pessoas);
         
        //Pessoa a = pessoaDAO.buscaPorID(1);
        //System.out.println("Pessoa retornada: ");
        //System.out.println(a);
        
        /*Pessoa p = pessoaDAO.exclui(this.obtemContatoExemploExclui());
         System.out.println("\n\nDado excluído:");
        */
        
        pessoaDAO.altera(pessoaDAO.buscaPorID(4), "dudu");
    }

    private void imprimeLista(List<Pessoa> pessoas) {
        for (Pessoa p : pessoas) {
         System.out.println(p);
         }
    }
    
    private Pessoa obtemContatoExemploExclui() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(3);
        return pessoa;
    }
    
    private Pessoa adicionarPessoa() {
        return criaPessoa();
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
}