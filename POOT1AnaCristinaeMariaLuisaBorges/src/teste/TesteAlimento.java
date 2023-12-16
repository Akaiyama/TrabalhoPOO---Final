/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;
import java.util.List;
import java.util.Scanner;
import mvc.model.Alimento;
import mvc.model.AlimentoDAO;
/**
 *
 * @author anath
 */
public class TesteAlimento {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        new TesteAlimento();
    }
    
    public TesteAlimento(){
        List<Alimento> alimentos = null;
        AlimentoDAO alimentoDAO = new AlimentoDAO();
        
        alimentoDAO.adicionaERetornaId(this.adicionarAlimento());
         
         alimentos = alimentoDAO.mostrarTodos(null);
         this.imprimeLista(alimentos);
         
        //Alimento a = alimentoDAO.buscaPorID(1);
       // System.out.println("Alimento retornado: ");
        //System.out.println(a);
        
        //Alimento a = alimentoDAO.exclui(this.obtemAlimentoExclui());

    }

    private void imprimeLista(List<Alimento> alimentos) {
        for (Alimento a : alimentos) {
         System.out.println(a);
         }
    }
    
    
    private Alimento obtemAlimentoExclui() {
        Alimento alimento = new Alimento();
        alimento.setId(5);
        return alimento;
    }
    
    private Alimento adicionarAlimento() {
        return criaAlimento();
    }
    public Alimento criaAlimento() {
        Alimento a1 = new Alimento();
        System.out.println("\nCADASTRO ALIMENTO");
        System.out.println("\nNome: ");
        String nome = scanner.nextLine();
        a1.setNome(nome);

        System.out.println("\nPorcao: ");
        int porcao = Integer.parseInt(scanner.nextLine());
        a1.setPorcao(porcao);

        System.out.println("\nProteina: ");
        double proteina = Double.parseDouble(scanner.nextLine());
        a1.setProteinas(proteina);

        System.out.println("\nCarboidrato: ");
        double carbo = Double.parseDouble(scanner.nextLine());
        a1.setCarboidratos(carbo);

        System.out.println("\nGorduras: ");
        double gorduras = Double.parseDouble(scanner.nextLine());
        a1.setGorduras(gorduras);

        return a1;
    }
}
