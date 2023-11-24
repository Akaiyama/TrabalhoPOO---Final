/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
/**
 *
 * @author Ana Cristina e Maria Luisa
 */
public class Avaliacao{
    /*id, pessoa, peso, altura, 
idade, pescoco, cintura, quadril, IMC, TMB, BF, 
massa gorda kg, massa magra kg, dataCriacao, dataModificacao.*/
    
    private long id;
    private static long serialAv;
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
    private Pessoa pessoa;
      
     public Avaliacao(Pessoa pessoa) {
        this.pessoa = pessoa;
        Avaliacao.serialAv = Avaliacao.serialAv+1;
        this.id = Avaliacao.serialAv;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public long getId() {
        return id;
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

    public Pessoa getPessoa() {
        return pessoa;
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
                + "\nAvaliacao{" + "\nid=" + id + "\n peso=" + peso + "\n altura=" + altura + "\n idade=" 
                + idade + "\n pescoco=" + pescoco + "\n cintura=" + cintura + "\n quadril=" + quadril + "\n massaGorda=" + massaGorda + "\n massaMagra=" + massaMagra 
                + "\n IMC=" + IMC + "\n TMB=" + TMB + "\n BF=" + BF + "\n dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Avaliacao other = (Avaliacao) obj;
        return this.id == other.id;
    }

    
   

    
}