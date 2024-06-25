package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa{

    private BigDecimal salario;

    private String funcao;

    public Funcionario(String nome, java.time.LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Funcionario:" +
                "nome: '" + getNome() + ' ' +
                ", data de nascimento: " + getDataNascimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", salario: " + String.format("%,.2f", salario) +
                ", funcao: '" + funcao + ' ' +
                ';';
    }
}
