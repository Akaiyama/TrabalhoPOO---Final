/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author Ana Cristina e Maria Luisa
 */
public class AlimentoRefeicaoDAO {
    AlimentoRefeicao[] alimentosRefeicao = new AlimentoRefeicao[50];
    
    public AlimentoRefeicaoDAO(){
        
    }

    
    public boolean adiciona(AlimentoRefeicao alimentoRefeicao) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            alimentosRefeicao[proximaPosicaoLivre] = alimentoRefeicao;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (AlimentoRefeicao alimentoRefeicao : alimentosRefeicao) {
            if (alimentoRefeicao != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temAli = false;
        for (AlimentoRefeicao alimentoRefeicao : alimentosRefeicao) {
            if (alimentoRefeicao != null) {
                System.out.println(alimentoRefeicao.toString());
                temAli = true;
            }
        }
        if (!temAli) {
            System.out.println("não existe alimento cadastrad");
        }
    }

    public AlimentoRefeicao buscaPorNome(String nome) {
        for (AlimentoRefeicao alimentoRefeicao : alimentosRefeicao) {
            if (alimentoRefeicao != null && alimentoRefeicao.getAlimento().equals(nome)) {
                return alimentoRefeicao;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < alimentosRefeicao.length; i++) {
            if (alimentosRefeicao[i] != null && alimentosRefeicao[i].getAlimento().equals(nome)) {
                alimentosRefeicao[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < alimentosRefeicao.length; i++) {
            if (alimentosRefeicao[i] == null) {
                return i;
            }
        }
        return -1;

    }
}
