/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author mb780
 */
public class AvaliacaoFisica {
    private long id;
    private Pessoa pessoa;
    private double peso;
    private double altura;
    private int idade;
    private double pescoco;
    private double cintura;
    private double quadril;
    private double massaGorda;
    private double massaMagra;
    private double IMC;
    private double TMB;
    private double BF;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public AvaliacaoFisica(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPescoco() {
        return pescoco;
    }

    public void setPescoco(double pescoco) {
        this.pescoco = pescoco;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public double getMassaGorda() {
        return massaGorda;
    }

    public void setMassaGorda(double massaGorda) {
        this.massaGorda = massaGorda;
    }

    public double getMassaMagra() {
        return massaMagra;
    }

    public void setMassaMagra(double massaMagra) {
        this.massaMagra = massaMagra;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public double getTMB() {
        return TMB;
    }

    public void setTMB(double TMB) {
        this.TMB = TMB;
    }

    public double getBF() {
        return BF;
    }

    public void setBF(double BF) {
        this.BF = BF;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    @Override
    public String toString() {
        return "\n========================================"
                + "\nAvaliacao{" + "\nid=" + id + "\n peso=" + peso + "\n altura=" + altura + "\n idade=" 
                + idade + "\n pescoco=" + pescoco + "\n cintura=" + cintura + "\n quadril=" + quadril + "\n massaGorda=" + massaGorda + "\n massaMagra=" + massaMagra 
                + "\n IMC=" + IMC + "\n TMB=" + TMB + "\n BF=" + BF + "\n dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.altura) ^ (Double.doubleToLongBits(this.altura) >>> 32));
        hash = 37 * hash + this.idade;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.pescoco) ^ (Double.doubleToLongBits(this.pescoco) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.cintura) ^ (Double.doubleToLongBits(this.cintura) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.quadril) ^ (Double.doubleToLongBits(this.quadril) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.massaGorda) ^ (Double.doubleToLongBits(this.massaGorda) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.massaMagra) ^ (Double.doubleToLongBits(this.massaMagra) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.IMC) ^ (Double.doubleToLongBits(this.IMC) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.TMB) ^ (Double.doubleToLongBits(this.TMB) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.BF) ^ (Double.doubleToLongBits(this.BF) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.dataCriacao);
        hash = 37 * hash + Objects.hashCode(this.dataModificacao);
        hash = 37 * hash + Objects.hashCode(this.pessoa);
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
        final AvaliacaoFisica other = (AvaliacaoFisica) obj;
        return true;
    }
}