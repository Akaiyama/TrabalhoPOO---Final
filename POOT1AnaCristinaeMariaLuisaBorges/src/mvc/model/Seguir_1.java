/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Ana Cristina e Maria Luísa -> Seguir - Parte 2
 */
public class Seguir {
    private long id;
    private Pessoa pessoaOrigem;
    private Pessoa pessoaDestino;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
 
    public Seguir(){
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pessoa getPessoaOrigem() {
        return pessoaOrigem;
    }

    public void setPessoaOrigem(Pessoa pessoaOrigem) {
        this.pessoaOrigem = pessoaOrigem;
    }

    public Pessoa getPessoaDestino() {
        return pessoaDestino;
    }

    public void setPessoaDestino(Pessoa pessoaDestino) {
        this.pessoaDestino = pessoaDestino;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    
    @Override
    public String toString() {
        return "\n========================================"
                + "\nSeguidores: " + pessoaDestino.getNome() + "\ndataModificacao: " + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 13 * hash + Objects.hashCode(this.pessoaOrigem);
        hash = 13 * hash + Objects.hashCode(this.pessoaDestino);
        hash = 13 * hash + Objects.hashCode(this.dataCriacao);
        hash = 13 * hash + Objects.hashCode(this.dataModificacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Seguir other = (Seguir) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.pessoaOrigem, other.pessoaOrigem)) {
            return false;
        }
        if (!Objects.equals(this.pessoaDestino, other.pessoaDestino)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }
}
