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
public class RegistroDieta {

    private long id;
    private Pessoa pessoa;
    private Avaliacao avaliacaoFisica;
    private TipoDieta tipo;
    private String objetivo;
    private double calorias;
    private int nroRefeicoes;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private static long serial;

    public RegistroDieta() {
        RegistroDieta.serial = RegistroDieta.serial + 1;
        this.id = RegistroDieta.serial;
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

    public Avaliacao getAvaliacaoFisica() {
        return avaliacaoFisica;
    }

    public void setAvaliacaoFisica(Avaliacao avaliacaoFisica) {
        this.avaliacaoFisica = avaliacaoFisica;
    }

    public TipoDieta getTipo() {
        return tipo;
    }

    public void setTipo(TipoDieta tipo) {
        this.tipo = tipo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
        //DIMINUIR O PESO, MANTER O PESO, MELHORAR COMPOSIÇÃO CORPORAL e AUMENTAR O PESO
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double tmb) {
        if(this.objetivo.equals("DIMINUIR O PESO"))
        {
            this.calorias = tmb - 500;
        }else if(this.objetivo.equals("MANTER O PESO")){
            this.calorias = tmb;
        }else if(this.objetivo.equals("GANHAR PESO")){
                this.calorias = tmb + 500;
        }     
    }

    public int getNroRefeicoes() {
        return nroRefeicoes;
    }

    public void setNroRefeicoes(int nroRefeicoes) {
        this.nroRefeicoes = nroRefeicoes;
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
                + "\nRegistroDieta{" + "\nid=" + id + "\n pessoa=" + pessoa + "\n avaliacaoFisica=" 
                + avaliacaoFisica + "\n tipo=" + tipo + "\n objetivo=" + objetivo + "\n calorias=" 
                + calorias + "\n nroRefeicoes=" + nroRefeicoes + "\n dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final RegistroDieta other = (RegistroDieta) obj;
        return this.id == other.id;
    }


}
