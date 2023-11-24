/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package mvc.model;

/**
 *
 * @author mb780
 */
public class SeguirDAO {

    Seguir[] seguindo = new Seguir[20];

    public SeguirDAO(PessoaDAO p) {
        Pessoa p1 = p.buscaPessoaLogin("ana", "teste");
        Pessoa p2 = p.buscaPessoaLogin("maria", "teste");

        Seguir s1 = new Seguir();
        s1.setPessoaOrigem(p1);
        s1.setPessoaDestino(p2);
        this.adiciona(s1);
        
        Seguir s2 = new Seguir();
        s2.setPessoaOrigem(p2);
        s2.setPessoaDestino(p1);
        this.adiciona(s2);
    }

    public boolean começarASeguir(Pessoa origem, Pessoa destino) {
        boolean check = false;
        Seguir seguir = buscarSeguidor(origem, destino);
        if (seguir == null) {
            Seguir segues = new Seguir();
            segues.setPessoaOrigem(origem);
            segues.setPessoaDestino(destino);
            this.adiciona(seguir);
            
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public boolean deixarDeSeguir(Pessoa origem, Pessoa destino) {
        boolean check;
        Seguir seguir = buscarSeguidor(origem, destino);
        if (seguir != null) {
            for (Seguir s1 : seguindo) {
                if (s1 != null && s1.equals(seguir)) {
                    s1 = null;
                }
            }
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public Seguir buscarSeguidor(Pessoa origem, Pessoa destino) {
        for (Seguir s : seguindo) {
            if(s != null){
                if (s.getPessoaOrigem().equals(origem) && s.getPessoaDestino().equals(destino)) {
                    System.out.println(s.toString());
                return s;
                } 
            }   
        }
        return null;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < seguindo.length; i++) {
            if (seguindo[i] == null) {
                return i;
            }
        }
        return -1;

    }

    public boolean adiciona(Seguir seguir) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            seguindo[proximaPosicaoLivre] = seguir;
            return true;
        } else {
            return false;
        }
    }

    public boolean ehVazio() {
        for (Seguir seguir : seguindo) {
            if (seguir != null) {
                return false;
            }
        }
        return true;
    }

    public void mostrarTodos(Pessoa p) {
            
        boolean tem = false;
        for (Seguir seguir : seguindo) {
            if (seguir != null  && seguir.getPessoaDestino() != p && seguir.getPessoaOrigem().equals(p)) {
                System.out.println(seguir.toString());
                tem = true;
            }
        }
        if (!tem) {
            System.out.println("Nao ha seguidores ainda.");
        }
    }
    
    
}