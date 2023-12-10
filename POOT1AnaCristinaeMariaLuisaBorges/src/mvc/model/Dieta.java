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
public class Dieta {

    private long id;
    private Pessoa pessoa;
    private AvaliacaoFisica avaliacaoFisica;
    private TipoDieta tipo;
    private String objetivo;
    private double calorias;
    private int nroRefeicoes;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Dieta(Pessoa pessoa, AvaliacaoFisica av, TipoDieta tipo) {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
        this.setPessoa(pessoa);
        this.setAvaliacaoFisica(av);
        this.setTipo(tipo);
    }
    
    public Dieta(){
        
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

    public AvaliacaoFisica getAvaliacaoFisica() {
        return avaliacaoFisica;
    }

    public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
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

    public void setObjetivo(int obj) {
        switch (obj) {
            case 1:
                this.objetivo = "Diminuir o peso";
                break;
            case 2:
                this.objetivo = "Manter o peso";
                break;
            case 3:
                this.objetivo = "Aumentar o peso";
                break;
            default:
                break;
        }
        //DIMINUIR O PESO, MANTER O PESO, MELHORAR COMPOSIÇÃO CORPORAL e AUMENTAR O PESO
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double tmb) {
        if(this.objetivo.equals("Diminuir o peso"))
        {
            this.calorias = tmb - 500;
        }else if(this.objetivo.equals("Manter o peso")){
            this.calorias = tmb;
        }else if(this.objetivo.equals("Aumentar o peso")){
                this.calorias = tmb + 500;
        }     
    }
    
    public void setCalorias(Double calorias){
        this.calorias = calorias;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "\n========================================"
                + "\nDieta{" + "\nid=" + id + "\n tipo=" + tipo.getNome() + "\n objetivo=" + objetivo + "\n calorias=" 
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
        final Dieta other = (Dieta) obj;
        return this.id == other.id;
    }


}
