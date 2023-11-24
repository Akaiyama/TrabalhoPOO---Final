/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
import mvc.model.PessoaDAO;

/**
 *
 * @author Ana Cristina e Maria Luisa
 */
public class AvaliacaoDAO {

    Avaliacao[] avaliacoes = new Avaliacao[50];

    public AvaliacaoDAO(){
        
    }
    
    public AvaliacaoDAO(PessoaDAO p) {
        Pessoa p1 = p.buscaPessoaLogin("ana", "teste");
        Avaliacao a1 = new Avaliacao(p1);
        AvaliacaoCalculos a = new AvaliacaoCalculos();
        a1.setAltura(170);
        a1.setPeso(71);
        a1.setIdade(a.calculaIdade(p1));
        a1.setIMC(a.calculaIMC(a1));
        a1.setTMB(a.calculaTMB(a1, p1, 1.375));
        a1.setPescoco(34);
        a1.setCintura(81);
        a1.setQuadril(102);
        a1.setBF(a.calculaBF(a1, p1));
        a1.setMassaGorda(a.calculaMassaGorda(a1));
        a1.setMassaMagra(a.calculaMassaMagra(a1, p1));
        
        this.adiciona(a1);
    }

    public boolean adiciona(Avaliacao avaliacao) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            avaliacoes[proximaPosicaoLivre] = avaliacao;
            return true;
        } else {
            return false;
        }

    }

    public boolean ehVazio() {
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos(Pessoa p) {
        boolean temAv = false;
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao != null && avaliacao.getPessoa().equals(p)) {
                System.out.println(avaliacao.toString());
                temAv = true;
            }
        }
        if (!temAv) {
            System.out.println("Nao ha avaliacao fisica cadastrada.");
        }
    }

    public boolean alterar(Long id, double peso, Pessoa p) {
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao != null && avaliacao.getId() == id && avaliacao.getPessoa().equals(p)) {
                avaliacao.setPeso(peso);
                return true;
            }
        }
        return false;

    }

    public Avaliacao buscaPorID(long id) {
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao != null && avaliacao.getId() == id) {
                return avaliacao;
            }
        }
        return null;
    }

    public boolean remover(long id) {
        for (int i = 0; i < avaliacoes.length; i++) {
            if (avaliacoes[i] != null && avaliacoes[i].equals(id)) {
                avaliacoes[i] = null;
                return true;
            }
        }
        return false;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < avaliacoes.length; i++) {
            if (avaliacoes[i] == null) {
                return i;
            }
        }
        return -1;

    }
}
