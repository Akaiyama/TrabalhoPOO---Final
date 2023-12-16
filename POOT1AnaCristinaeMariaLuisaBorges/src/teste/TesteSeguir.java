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
import mvc.model.Seguir;
import mvc.model.SeguirDAO;

/**
 *
 * @author mb780
 */
public class TesteSeguir {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        new TesteSeguir();
    }
    
    public TesteSeguir(){
        List<Seguir> seguidores = null;
        SeguirDAO seguirDAO = new SeguirDAO();
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        /*if(seguirDAO.adicionaERetornaId(this.criaSeguir()) == 0)
            System.out.println("Impossivel seguir voce mesmo");
        else
            System.out.println("Deu certo");
         */
        //seguidores = seguirDAO.mostrarTodos(null);
        //this.imprimeLista(seguidores);
         
        //Seguir s = seguirDAO.buscaPorID(1);
        //System.out.println("Retorno: ");
        //System.out.println(s);
        
        Seguir s = seguirDAO.exclui(this.excluiSeguir());
 
    }

    private void imprimeLista(List<Seguir> seguidores) {
        for (Seguir s : seguidores) {
         System.out.println(s);
         }
    }
   
    private Seguir removerSeguir() {
        return excluiSeguir();
    }
    
    /*public Seguir validaSeguir(List<Seguir> seguidores, Seguir seguindo){
        for (Seguir s : seguidores) {
            if(s.getPessoaDestino().
         System.out.println(s);
         }
    }*/
    
    public Seguir criaSeguir() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Seguir s = new Seguir();
        s.setPessoaOrigem(pessoaDAO.buscaPorID(4));
        s.setPessoaDestino(pessoaDAO.buscaPorID(2));
        
        return s;
    }
   
   public Seguir excluiSeguir() {
        
        Seguir s = new Seguir();
       s.setId(4);
        return s;
    } 
   
   private int menuSeguir() {
        StringBuilder builder = new StringBuilder("");
        builder.append("\n========================== MENU SEGUIR ==========================");
        builder.append("\n1 - Seguir;");
        builder.append("\n2 - Buscar;");
        builder.append("\n3 - Excluir;");
        builder.append("\n4 - Mostrar;");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());
        int opc = Integer.parseInt(scanner.nextLine());
        return opc;
    }
}