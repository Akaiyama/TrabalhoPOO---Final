/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import java.util.List;
import java.util.Scanner;
import mvc.model.TipoDieta;
import mvc.model.TipoDietaDAO;

/**
 *
 * @author anath
 */
public class TesteTipoDieta {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        new TesteTipoDieta();
    }
    
    public TesteTipoDieta(){
        List<TipoDieta> tipos = null;
        TipoDietaDAO tipoDietaDAO = new TipoDietaDAO();
        
        //tipoDietaDAO.adicionaERetornaId(this.adicionarTipoDieta());
         
         tipos = tipoDietaDAO.mostrarTodos(null);
         this.imprimeLista(tipos);
         
        //TipoDieta tipo = tipoDietaDAO.buscaPorID(1);
        //System.out.println("Tipo de dieta retornado: ");
        //System.out.println(tipo);
        
        TipoDieta tipo = tipoDietaDAO.exclui(this.obtemExemploExclui());

    }

    private void imprimeLista(List<TipoDieta> tipos) {
        for (TipoDieta t : tipos) {
         System.out.println(t);
         }
    }
    
    
    private TipoDieta obtemExemploExclui() {
        TipoDieta t = new TipoDieta();
        t.setId(2);
        return t;
    }
    
    private TipoDieta adicionarTipoDieta() {
        return criaTipoDieta();
    }
    public TipoDieta criaTipoDieta() {
        
        StringBuilder builder = new StringBuilder("");
        builder.append("\nQual o tipo de dieta voce ira fazer agora: ");
        builder.append("\n1 - Equilibrada;");
        builder.append("\n2 - Low Carb;");
        builder.append("\n3 - Cetogênica;");
        builder.append("\nQual sua opcao ? R: ");
        System.out.println(builder.toString());
        int opc = Integer.parseInt(scanner.nextLine());
        TipoDieta t = new TipoDieta();
        t.setNome(opc);
        return t; 
    }
}
