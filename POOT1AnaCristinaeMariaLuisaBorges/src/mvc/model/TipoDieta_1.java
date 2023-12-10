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
public class TipoDieta {
    private long id;
    private String nome;
    private double carboidratos;
    private double proteinas;
    private double gorduras;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public TipoDieta() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(int opc) {
    
        if(opc == 1)
        {
            this.nome = "Equilibrada";
            this.setCarboidratos(40);
            this.setProteinas(30);
            this.setGorduras(30);
        }else if(opc == 2)
        {
            this.nome = "Low Carb";          
            this.setCarboidratos(30);
            this.setProteinas(50);
            this.setGorduras(20);
        }else if(opc == 3)
        {
            this.nome = "Cetogenica";
            this.setCarboidratos(15);
            this.setProteinas(15);
            this.setGorduras(70);
        }
    }

    public void setNome2(String nome){
        this.nome = nome;
    }
    
    public double getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(double carboidratos) {
        this.carboidratos = carboidratos;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getGorduras() {
        return gorduras;
    }

    public void setGorduras(double gorduras) {
        this.gorduras = gorduras;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    
    public LocalDate getDataModificacao() {
        return dataModificacao;
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
                + "\nTipoDieta{" + "\nid=" + id + "\n nome=" + nome + "\n carboidratos=" 
                + carboidratos + "\n proteinas=" + proteinas + "\n gorduras=" + gorduras 
                + "\n dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final TipoDieta other = (TipoDieta) obj;
        return this.id == other.id;
    }


}
