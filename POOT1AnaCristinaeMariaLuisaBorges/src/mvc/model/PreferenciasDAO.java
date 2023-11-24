/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author Ana Cristina e Maria Luisa
 */
public class PreferenciasDAO {
    Preferencias[] preferencias = new Preferencias[50];
    
    public PreferenciasDAO(){
        
    }

    
    public boolean adiciona(Preferencias preferencia) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            preferencias[proximaPosicaoLivre] = preferencia;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Preferencias preferencia : preferencias) {
            if (preferencia != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temPref = false;
        for (Preferencias preferencia : preferencias) {
            if (preferencia != null) {
                System.out.println(preferencia.toString());
                temPref = true;
            }
        }
        if (!temPref) {
            System.out.println("\nNao existe preferencias cadastradas ainda");
        }
    }

    public Preferencias buscaPorNome(String nome) {
        for (Preferencias preferencia : preferencias) {
            if (preferencia != null && preferencia.getAlimento().equals(nome)) {
                return preferencia;
            }
        }
        return null;

    }

    public boolean remover(Alimento nome) {
        for (int i = 0; i < preferencias.length; i++) {
            if (preferencias[i] != null && preferencias[i].getAlimento().equals(nome)) {
                preferencias[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < preferencias.length; i++) {
            if (preferencias[i] == null) {
                return i;
            }
        }
        return -1;

    }
}
