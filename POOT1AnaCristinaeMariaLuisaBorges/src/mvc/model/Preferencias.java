/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.time.LocalDate;

/**
 *
 * @author Ana Cristina e Maria Luisa
 */
public class Preferencias {

    private long id;
    private Pessoa pessoa;
    private Alimento alimento;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private static long serialPr;

    public Preferencias(Pessoa pessoa) {
        this.pessoa = pessoa;
        Preferencias.serialPr = Preferencias.serialPr+1;
        this.id = Preferencias.serialPr;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
        /*
        Escolha pelo menos 3 alimentos como fonte principal de carboidrato.
        Escolha pelo menos 3 alimentos como fonte principal de proteína.
        Escolha pelo menos 3 alimentos como fonte principal de gordura.

         */
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    @Override
    public String toString() {
        return "\n========================================"
                + "\nPreferencias{" + "\nid=" + id + "\n" + alimento.getNome() + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Preferencias other = (Preferencias) obj;
        return this.id == other.id;
    }

    
}
