/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author Ana Cristina e Maria Luisa
 */
public class RefeicoesDAO {
    Refeicoes[] refeicoes = new Refeicoes[50];
    
    public RefeicoesDAO(){
        
    }

    
    public boolean adiciona(Refeicoes refeicao) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            refeicoes[proximaPosicaoLivre] = refeicao;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Refeicoes refeicao : refeicoes) {
            if (refeicao != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temRef = false;
        for (Refeicoes refeicao : refeicoes) {
            if (refeicao != null) {
                System.out.println(refeicao.toString());
                temRef = true;
            }
        }
        if (!temRef) {
            System.out.println("nao existe refeicao cadastrada");
        }
    }

    public Refeicoes buscaPorNome(String nome) {
        for (Refeicoes refeicao : refeicoes) {
            if (refeicao != null && refeicao.getNomeRefeicao().equals(nome)) {
                return refeicao;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < refeicoes.length; i++) {
            if (refeicoes[i] != null && refeicoes[i].getNomeRefeicao().equals(nome)) {
                refeicoes[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < refeicoes.length; i++) {
            if (refeicoes[i] == null) {
                return i;
            }
        }
        return -1;

    }
}
