/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import mvc.model.AvaliacaoFisica;
import java.time.LocalDate;
import java.time.Period;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Ana Cristina e Maria Luisa
 */
public class AvaliacaoCalculos {

    public AvaliacaoCalculos() {
    }

    public double fatorAtividade(int opcao) {
        /*1.2: sedentário (pouco ou nenhum exercício)
	1,375: levemente ativo (exercício leve 1 a 3 dias por semana)
	1,55: moderadamente ativo (exercício moderado 6 a 7 dias por semana)
	1,725: muito ativo (exercício intenso todos os dias ou exercício duas vezes ao dia)
	1,9: extra ativo (exercício muito difícil, treinamento ou trabalho físico)*/

        if (opcao == 1) {
            return 1.2;
        }
        if (opcao == 2) {
            return 1.375;
        }
        if (opcao == 3) {
            return 1.55;
        }
        if (opcao == 4) {
            return 1.725;
        } else {
            return 1.9;
        }
    }

    public int calculaIdade(Pessoa pessoa) {
        LocalDate atual = LocalDate.now();
        Period period = Period.between(pessoa.getNascimento(), atual);
        return period.getYears();
    }

    public double calculaIMC(AvaliacaoFisica avaliacao) {
        //IMC = Peso ÷ (Altura × Altura)
        double alt = avaliacao.getAltura();
        alt = alt / 100;
        double imc = avaliacao.getPeso() / (alt * alt);
        return imc;
    }

    public double calculaTMB(AvaliacaoFisica avaliacao, Pessoa pessoa, double fator) {
        /*Fórmula para homens:
        TMB = fator da taxa de atividade x {66 + [(13,7 x Peso(kg)) + ( 5 x Altura(cm)) – (6,8 x Idade(anos))]}
        Fórmula para mulheres:
        TMB = fator da taxa de atividade x {655 + [(9,6 x Peso(kg)) + (1,8 x Altura(cm)) – (4,7 x Idade(anos))]}
         */
        double tmb = 0;
        if (pessoa.getSexo().equals("M")) {
            tmb = fator * (66 + (13.7 * avaliacao.getPeso())
                    + (5 * avaliacao.getAltura()) - (6.8 * avaliacao.getIdade()));
        } else if (pessoa.getSexo().equals("F")) {

            tmb = fator * (655 + (9.6 * avaliacao.getPeso())
                    + (5 * avaliacao.getAltura()) - (4.7 * avaliacao.getIdade()));
        }
        return tmb;
    }

    /*Deverá ser estimado o valor do percentual de gordura. Da quantidade de massa magra
        e da quantidade de massa gorda.
        Fórmula para mulheres: % body fat = 163.205 x log10 (cintura + quadril – pescoço) – 97.684 x log10 (altura) – 78.387
        Fórmula para homens: % body fat = 86.010 x log10 (abdome – pescoço) – 70.041 x log10 (altura) + 36.76
        Com o % body fat calculado, basta fazer outras multiplicações para descobrir o peso de massa gorda e o restante é de massa magra.
     */
    public double calculaBF(AvaliacaoFisica avaliacao, Pessoa pessoa) {
        double valor = 0;
        if (pessoa.getSexo().equals("F")) {
            double x = avaliacao.getCintura() + avaliacao.getQuadril() - avaliacao.getPescoco();
            valor = 163.205 * Math.log10(x)
                    - 97.684 * Math.log10(avaliacao.getAltura()) - 78.387;

        } else if (pessoa.getSexo().equals("M")) {
            double x = avaliacao.getCintura() - avaliacao.getPescoco();
            valor = 86.010 * Math.log10(x)
                    - 70.041 * Math.log10(avaliacao.getAltura()) + 36.76;
        }
        return valor;
    }

    public double calculaMassaGorda(AvaliacaoFisica avaliacao) {
        double mg = (avaliacao.getPeso() * avaliacao.getBF()) / 100;
        return mg;
    }

    public double calculaMassaMagra(AvaliacaoFisica avaliacao, Pessoa logada) {
        double mm = 0;
        if (logada.getSexo().equals("F")) {
            mm = avaliacao.getPeso() * (1 - (avaliacao.getBF() / 100));
        } else if (logada.getSexo().equals("M")) {
            mm = avaliacao.getPeso() * (100 - avaliacao.getBF()) / 100;
        }
        return mm;
    }

}
