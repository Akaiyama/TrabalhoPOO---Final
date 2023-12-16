/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import mvc.model.Mensagem;
import mvc.model.MensagemDAO;
import mvc.model.Pessoa;
import mvc.model.PessoaDAO;

/**
 *
 * @author Ana e Maria
 */
public class TesteMensagem {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new TesteMensagem();
    }

    public TesteMensagem() {
        MensagemDAO mensagemDAO = new MensagemDAO();
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Mensagem> mensagens = null;

        //mensagemDAO.adicionaERetornaId(this.criaMensagem());
        mensagens = mensagemDAO.mostrarTodos(null, pessoaDAO.buscaPorID(1));
        this.imprimeLista(mensagens);
        //Mensagem m = mensagemDAO.buscaPorID(5, pessoaDAO.buscaPorID(1));
        //System.out.println("Mensagem retornada: ");
        //System.out.println(m);
        //Mensagem m = mensagemDAO.exclui(this.obtemContatoExemploExclui());

    }

    private void imprimeLista(List<Mensagem> mensagens) {
        for (Mensagem m : mensagens) {
            System.out.println(m);
        }
    }

    private Mensagem obtemContatoExemploExclui() {

        Mensagem mensagem = new Mensagem();
        mensagem.setId(2);
        return mensagem;
    }

    public Mensagem criaMensagem() {
        PessoaDAO pessoaDAO = new PessoaDAO();

        Mensagem m = new Mensagem();
        m.setPessoaOrigem(pessoaDAO.buscaPorID(4));
        m.setPessoaDestino(pessoaDAO.buscaPorID(2));
        m.setMensagem("Pode mandar o trabalho mesmo assim");

        return m;
    }

}
