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
    private static long serialRf;

    public Refeicoes() {
        Refeicoes.serialRf = Refeicoes.serialRf +1;
        this.id = Refeicoes.serialRf;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public double getCaloriaMAX() {
        return caloriaMAX;
    }

    public void setCaloriaMAX(double caloriaMAX) {
        this.caloriaMAX = caloriaMAX;
    }

    public double getCarbMAX() {
        return carbMAX;
    }

    public void setCarbMAX(double carbMAX) {
        this.carbMAX = carbMAX;
    }

    public double getProMAX() {
        return proMAX;
    }

    public void setProMAX(double proMAX) {
        this.proMAX = proMAX;
    }

    public double getGordMAX() {
        return gordMAX;
    }

    public void setGordMAX(double gordMAX) {
        this.gordMAX = gordMAX;
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

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public String getNomeRefeicao() {
        return nomeRefeicao;
    }

    public void setNomeRefeicao(int opc) {
        switch (opc) {
            case 1:
                this.nomeRefeicao = "Cafe da manha";
                break;
            case 2:
                this.nomeRefeicao = "Almoco";
                break;
            case 3:
                this.nomeRefeicao = "Cafe da tarde";
                break;
            case 4:
                this.nomeRefeicao = "Janta";
                break;
            case 5:
                this.nomeRefeicao = "Ceia";
                break;
        }
        
        // café da manhã, almoço, café da tarde, janta, ceia ou outro nome.

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
                + "\nRefeicoes{" + "\nid=" + id + "\n nomeRefeicao=" + nomeRefeicao + "\n dieta=" + dieta.getTipo().getNome() + "\n carboidratos=" + carboidratos 
                + "\n proteinas=" + proteinas + "\n gorduras=" + gorduras + "\n calorias=" + calorias 
                + "\n CaloriasMax="+ caloriaMAX + "\ndataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
        return this.id == other.id;
    }

}
