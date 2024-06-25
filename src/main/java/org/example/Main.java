package org.example;

import org.example.model.Funcionario;
import org.example.service.FuncionarioService;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FuncionarioService funcionarioService = new FuncionarioService();
        List<Funcionario> funcionarios = new ArrayList<>();
        Map<String, List<Funcionario>> funcionarioPorFuncao = new HashMap<>();


        funcionarios = funcionarioService.getListaFuncionario();

        System.out.println("\nLista de usuários do sistema:");
        funcionarios.forEach(System.out::println);

        funcionarioService.pausa();

        //requisito 3.2
        System.out.println("\nRemovendo funcionário João.");
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        funcionarioService.pausa();

        System.out.println("\nLista de usuários do sistema Após remover o João:");
        funcionarios.forEach(System.out::println);

        funcionarioService.pausa();
        //requisito 3.3
        System.out.println("\nLista de usuários do sistema:");
        funcionarios.forEach(System.out::println);

        funcionarioService.pausa();

        //requisito 3.4
        System.out.println("\nTodos os funcionarios receberem um aumento de 10%.");
        funcionarios.forEach(funcionario -> funcionario.setSalario(funcionario.getSalario().
                multiply(new java.math.BigDecimal("1.1"))));

        funcionarioService.pausa();

        System.out.println("\nLista de usuários do sistema Após aumento de 10%:");
        funcionarios.forEach(System.out::println);

        funcionarioService.pausa();

        //requisito 3.5
        System.out.println("\ngerando lista de usuários do sistema por função.");
        funcionarioPorFuncao = funcionarioService.getFuncionariosPorFuncao(funcionarios);
        System.out.println("Lista gerada!");

        funcionarioService.pausa();

        //requisito 3.6
        System.out.println("\nLista de usuários do sistema por função:");
        funcionarioPorFuncao.forEach((funcao, funcionariosPorFuncao) -> {
            System.out.println("\nFunção: " + funcao);
            funcionariosPorFuncao.forEach(System.out::println);
        });

        funcionarioService.pausa();

        //requisito 3.8
        System.out.println("\nFuncionários que fazem aniversário no mês de Outubro ou Dezembro:");
        funcionarioService.getAniversariantes(funcionarios, 10, 12).forEach(System.out::println);

        funcionarioService.pausa();

        //requisito 3.9
        System.out.println("\nFuncionário mais velho:");
        funcionarioService.funcionarioMaisVelho(funcionarios);

        funcionarioService.pausa();

        //requisito 3.10
        System.out.println("\nlista de funcionários ordenados por nome:");
        funcionarios.stream().sorted(java.util.Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);

        funcionarioService.pausa();

        //requisito 3.11
        System.out.println("\nLista de salários dos funciários:");
        funcionarioService.getListaSalarios(funcionarios);

        funcionarioService.pausa();

        //requisito 3.12

        System.out.println("\nQuantos salarios mínimos ganha cada funcionario: ");
        funcionarioService.getSalariosMinimos(funcionarios);

        System.out.println("\n\nFim do programa");
    }
}