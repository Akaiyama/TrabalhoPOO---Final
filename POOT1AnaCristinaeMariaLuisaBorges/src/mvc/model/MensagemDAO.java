/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author Ana Cristina e Maria Luisa
 */
public class MensagemDAO {

    Mensagem[] mensagens = new Mensagem[100];

    public MensagemDAO() {
    }
    
    public MensagemDAO(PessoaDAO origem, PessoaDAO destino){
        Pessoa p1 = origem.buscaPessoaLogin("ana", "teste");
        Pessoa p2 = origem.buscaPessoaLogin("maria", "teste");
        
        Mensagem m1 = new Mensagem();
        m1.setMensagem("Oi, como vai?");
        m1.setPessoaOrigem(p1);
        m1.setPessoaDestino(p2);
        this.adiciona(m1);
        
        Mensagem m2 = new Mensagem();
        m2.setMensagem("Vou bem e voce?");
        m2.setPessoaOrigem(p2);
        m2.setPessoaDestino(p1); 
        this.adiciona(m2);
        
        Mensagem m3 = new Mensagem();
        m3.setMensagem("Voce viu o video da capybara? Capybara, capybara, capybara~");
        m3.setPessoaOrigem(p1);
        m3.setPessoaDestino(p2);
        this.adiciona(m3);
        
        Mensagem m4 = new Mensagem();
        m4.setMensagem("SIMMM! Uso a musica desse video para fazer meus treinos matinais, fico muito mais empolgada!");
        m4.setPessoaOrigem(p2);
        m4.setPessoaDestino(p1);
        this.adiciona(m4);
    }
    
    public boolean mandarMensagem(Pessoa origem, Pessoa destino, String novaMensagem) {
        Mensagem mensagem = new Mensagem();
        boolean check = false;
        for (Mensagem m : mensagens) {
            if(m != null){
                if (m.getPessoaOrigem().equals(origem) && m.getPessoaDestino().equals(destino)) {
                    mensagem.setMensagem(m.getMensagem());
                    m.setMensagem(mensagem.getMensagem()+ "\n" + novaMensagem);
                    check = true;
                } 
                else {
                }
            }
        }
        return check;
    }
    
    public boolean adiciona(Mensagem mensagem) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            mensagens[proximaPosicaoLivre] = mensagem;
            return true;
        } else {
            return false;
        }
    }

    public boolean ehVazio() {
        for (Mensagem mensagem : mensagens) {
            if (mensagem != null) {
                return false;
            }
        }
        return true;

    }

    public void mostrarTodos() {
        boolean tem = false;
        for (Mensagem mensagem : mensagens) {
            if (mensagem != null) {
                System.out.println(mensagem.getMensagem());
                tem = true;
            }
        }
        if (!tem) {
            System.out.println("Não há mensagem cadastrada.");
        }
    }

    public String buscaPorMensagem(long id) {
        for (Mensagem mensagem : mensagens) {
            if (mensagem != null && mensagem.getId() == id) {
                return mensagem.getMensagem();
            }
        }
        return null;
    }

    public boolean remover(String mensagem) {
        for (int i = 0; i < mensagens.length; i++) {
            if (mensagens[i] != null && mensagens[i].getMensagem().equals(mensagem)) {
                mensagens[i] = null;
                return true;
            }
        }
        return false;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < mensagens.length; i++) {
            if (mensagens[i] == null) {
                return i;
            }
        }
        return -1;

    }
}