/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Ana e Maria
 */
public class Refeicoes {
    private long id;
    private Dieta dieta;
    private double carboidratos;
    private double carbMAX;
    private double proteinas;
    private double proMAX;
    private double gorduras;
    private double gordMAX;
    private double calorias;
    private double caloriaMAX;
    private String nomeRefeicao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Refeicoes() {
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public double getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(double carboidratos) {
        this.carboidratos = carboidratos;
    }

    public double getCarbMAX() {
        return carbMAX;
    }

    public void setCarbMAX(double carbMAX) {
        this.carbMAX = carbMAX;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getProMAX() {
        return proMAX;
    }

    public void setProMAX(double proMAX) {
        this.proMAX = proMAX;
    }

    public double getGorduras() {
        return gorduras;
    }

    public void setGorduras(double gorduras) {
        this.gorduras = gorduras;
    }

    public double getGordMAX() {
        return gordMAX;
    }

    public void setGordMAX(double gordMAX) {
        this.gordMAX = gordMAX;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getCaloriaMAX() {
        return caloriaMAX;
    }

    public void setCaloriaMAX(double caloriaMAX) {
        this.caloriaMAX = caloriaMAX;
    }

    public String getNomeRefeicao() {
        return nomeRefeicao;
    }

    public void setNomeRefeicao(String nomeRefeicao) {
        this.nomeRefeicao = nomeRefeicao;
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
                + "\nRefeicoes{" + "\nid=" + id + "\n nomeRefeicao=" + nomeRefeicao + "\n dieta=" + dieta.getTipo().getNome() + "\n carboidratos=" + carboidratos 
                + "\n proteinas=" + proteinas + "\n gorduras=" + gorduras + "\n calorias=" + calorias 
                + "\n CaloriasMax="+ caloriaMAX + "\ndataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.dieta);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.carboidratos) ^ (Double.doubleToLongBits(this.carboidratos) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.carbMAX) ^ (Double.doubleToLongBits(this.carbMAX) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.proteinas) ^ (Double.doubleToLongBits(this.proteinas) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.proMAX) ^ (Double.doubleToLongBits(this.proMAX) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.gorduras) ^ (Double.doubleToLongBits(this.gorduras) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.gordMAX) ^ (Double.doubleToLongBits(this.gordMAX) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.calorias) ^ (Double.doubleToLongBits(this.calorias) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.caloriaMAX) ^ (Double.doubleToLongBits(this.caloriaMAX) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.nomeRefeicao);
        hash = 71 * hash + Objects.hashCode(this.dataCriacao);
        hash = 71 * hash + Objects.hashCode(this.dataModificacao);
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
        final Refeicoes other = (Refeicoes) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.carboidratos) != Double.doubleToLongBits(other.carboidratos)) {
            return false;
        }
        if (Double.doubleToLongBits(this.carbMAX) != Double.doubleToLongBits(other.carbMAX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.proteinas) != Double.doubleToLongBits(other.proteinas)) {
            return false;
        }
        if (Double.doubleToLongBits(this.proMAX) != Double.doubleToLongBits(other.proMAX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gorduras) != Double.doubleToLongBits(other.gorduras)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gordMAX) != Double.doubleToLongBits(other.gordMAX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.calorias) != Double.doubleToLongBits(other.calorias)) {
            return false;
        }
        if (Double.doubleToLongBits(this.caloriaMAX) != Double.doubleToLongBits(other.caloriaMAX)) {
            return false;
        }
        if (!Objects.equals(this.nomeRefeicao, other.nomeRefeicao)) {
            return false;
        }
        if (!Objects.equals(this.dieta, other.dieta)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }
    
    
}
