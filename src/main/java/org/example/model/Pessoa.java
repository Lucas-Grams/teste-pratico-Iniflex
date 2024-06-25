package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    private String nome;

    private LocalDate dataNascimento;

    @Override
    public String toString() {
        return "Pessoa: " +
                "nome: '" + nome + ' ' +
                ", data de nascimento: " + dataNascimento +
                ';';
    }
}
