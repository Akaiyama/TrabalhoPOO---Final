/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.control;
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
