package org.example.service;

import org.example.model.Funcionario;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FuncionarioService {

    Scanner scanner = new Scanner(System.in);

    //função que retorna uma lista de funcionários do sistema
    public List<Funcionario> getListaFuncionario() {
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
                new Funcionario("Maria", LocalDate.parse("18/10/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.parse("12/05/1990", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new BigDecimal("2238.38"), "Operador"),
                new Funcionario("Caio", LocalDate.parse("02/05/1961", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.parse("14/10/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.parse("05/01/1995", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.parse("19/11/1999", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.parse("31/03/1993", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.parse("08/07/1994", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.parse("24/05/2003", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.parse("02/09/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")), new BigDecimal("2799.93"), "Gerente")
        ));
        return funcionarios;
    }

    //função que retorna funcionarios mapeados por função
    public Map<String, List<Funcionario>> getFuncionariosPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream().collect(java.util.stream.Collectors.groupingBy(Funcionario::getFuncao));
    }

    //função que retorna funcionarios que fazem aniversário em certo mês
    public List<Funcionario> getAniversariantes(List<Funcionario> funcionarios, Integer... meses) {
        List<Funcionario> aniversariantes = new ArrayList<>();
        funcionarios.forEach(funcionario -> {
            int aniversarioMes = funcionario.getDataNascimento().getMonthValue();
            if (aniversarioMes == meses[0] || aniversarioMes == meses[1]) {
                aniversariantes.add(funcionario);
            }
        });
        return aniversariantes;
    }

    //função que printa o funcionário mais velho
    public void funcionarioMaisVelho(List<Funcionario> funcionarios) {
        funcionarios.stream().min(java.util.Comparator.comparing(Funcionario::getDataNascimento))
                .ifPresent(System.out::println);
    }

    public void getListaSalarios(List<Funcionario> funcionarios) {
        funcionarios.forEach(funcionario ->
                System.out.println("Nome: " + funcionario.getNome() + " Salário: " + funcionario.getSalario())
        );

        BigDecimal totalSalarios = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }

        System.out.println("Soma total: ");
        System.out.println("\nTotal dos Salários: " + totalSalarios);
    }

    public void getSalariosMinimos(List<Funcionario> funcionarios) {
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(funcionario.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        });
    }

    public void pausa() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
}