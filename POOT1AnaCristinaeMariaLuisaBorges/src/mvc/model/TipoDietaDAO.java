/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 *@author  Ana Cristina e Maria Luisa
 */
public class TipoDietaDAO {
    TipoDieta[] tiposDietas = new TipoDieta[50];
    
    public TipoDietaDAO(){
       TipoDieta tipo1 = new TipoDieta();
       tipo1.setNome(1);
       //equilibrada
        this.adiciona(tipo1);
    }

    
    public boolean adiciona(TipoDieta tipo) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            tiposDietas[proximaPosicaoLivre] = tipo;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (TipoDieta tipo : tiposDietas) {
            if (tipo != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temDie = false;
        for (TipoDieta tipo : tiposDietas) {
            if (tipo != null) {
                System.out.println(tipo);
                temDie = true;
            }
        }
        if (!temDie) {
            System.out.println("não existe dieta cadastrad");
        }
    }

    public TipoDieta buscaPorID(long id) {
        for (TipoDieta tipo : tiposDietas) {
            if (tipo != null && tipo.getId() == id) {
                return tipo;
            }
        }
        return null;

    }

    public boolean remover(String nome) {
        for (int i = 0; i < tiposDietas.length; i++) {
            if (tiposDietas[i] != null && tiposDietas[i].getNome().equals(nome)) {
                tiposDietas[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < tiposDietas.length; i++) {
            if (tiposDietas[i] == null) {
                return i;
            }
        }
        return -1;

    }
}
