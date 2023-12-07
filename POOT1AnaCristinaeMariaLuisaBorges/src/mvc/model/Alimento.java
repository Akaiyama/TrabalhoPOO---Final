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
public class Alimento {
    private long id;
    private String nome;
    private double carboidratos;
    private double proteinas;
    private double gorduras;
    private int porcao;
    private double calorias;
    private  LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Alimento() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }
    
    double calcCalorias(){
        return this.calorias = (4 * this.carboidratos) + (4 * this.proteinas) + (9 * this.gorduras);
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

    public void setNome(String nome) {
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

    public int getPorcao() {
        return porcao;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }

    public double getCalorias() {
        calcCalorias();
        return calorias;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
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
                + "\nAlimento{" + "\nid=" + id + "\n nome=" + nome + "\n carboidratos=" + carboidratos + "\n proteinas=" + proteinas + "\n gorduras=" + gorduras + "\n porcao=" + porcao + "\n calorias=" + calorias + "\n dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Alimento other = (Alimento) obj;
        return this.id == other.id;
    }
    
    
}
