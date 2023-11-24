/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author Ana Cristina e Maria Luisa
 */
public class RegistroDietaDAO {
    RegistroDieta[] registros = new RegistroDieta[50];
    
    public RegistroDietaDAO(){
        
    }

    
    public boolean adiciona(RegistroDieta registro) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            registros[proximaPosicaoLivre] = registro;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (RegistroDieta registro : registros) {
            if (registro != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean temReg = false;
        for (RegistroDieta registro : registros) {
            if (registro != null) {
                System.out.println(registro);
                temReg = true;
            }
        }
        if (!temReg) {
            System.out.println("não existe registro cadastrad");
        }
    }

    public RegistroDieta buscaPorID(long id) {
        for (RegistroDieta registro : registros) {
            if (registro != null && registro.equals(id)) {
                return registro;
            }
        }
        return null;

    }

    public boolean remover(long id) {
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] != null && registros[i].equals(id)) {
                registros[i] = null;
                return true;
            }
        }
        return false;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] == null) {
                return i;
            }
        }
        return -1;

    }
}
