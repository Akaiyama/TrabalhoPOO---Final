/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author Ana Cristina e Maria Luisa
 */
public class DietaDAO {

    Dieta[] registros = new Dieta[50];

    public DietaDAO() {
    }

    public DietaDAO(PessoaDAO p, AvaliacaoDAO av, TipoDietaDAO tipoDAO) {
        Pessoa p1 = p.buscaPessoaLogin("ana", "teste");
        Avaliacao a1 = av.buscaPorID(1);
        TipoDieta tipo1 = tipoDAO.buscaPorID(1);

        Dieta registro1 = new Dieta(p1, a1, tipo1);
        registro1.setNroRefeicoes(5);
        registro1.setObjetivo(1);
        //Diminuir o peso
        registro1.setCalorias(a1.getTMB());

        this.adiciona(registro1);
    }

    public boolean adiciona(Dieta registro) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            registros[proximaPosicaoLivre] = registro;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Dieta registro : registros) {
            if (registro != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos(Pessoa p) {
        boolean temReg = false;
        for (Dieta registro : registros) {
            if (registro != null && registro.getPessoa().equals(p)) {
                System.out.println(registro.toString());
                temReg = true;
            }
        }
        if (!temReg) {
            System.out.println("nao existe dieta cadastrada");
        }
    }

    public Dieta buscaPorID(long id) {
        for (Dieta registro : registros) {
            if (registro != null && registro.getId() == id) {
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
