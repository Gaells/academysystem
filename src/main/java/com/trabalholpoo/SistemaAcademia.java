package com.trabalholpoo;

import java.util.Scanner;

public class SistemaAcademia {

    public static void main(String[] args) {
        Academia academia = new Academia();

        // Cadastro de clientes
        Cliente cliente1 = new Cliente("João", "joao123", "senha123", 25);
        Cliente cliente2 = new Cliente("Maria", "maria456", "senha456", 30);
        academia.cadastrarCliente(cliente1);
        academia.cadastrarCliente(cliente2);

        // Cadastro de funcionários
        Funcionario funcionario1 = new Funcionario("Ana", "ana789", "senha789", "Instrutor");
        Funcionario funcionario2 = new Funcionario("Carlos", "carlos010", "senha010", "Recepcionista");
        academia.cadastrarFuncionario(funcionario1);
        academia.cadastrarFuncionario(funcionario2);

        // Cadastro de serviços
        Servico servico1 = new Servico("Treino Personalizado", 100.0);
        Servico servico2 = new Servico("Aulas de Grupo", 50.0);
        academia.cadastrarServico(servico1);
        academia.cadastrarServico(servico2);

        // Simulação de login
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        Pessoa usuarioLogado = academia.fazerLogin(usuario, senha);

        if (usuarioLogado != null) {
            if (usuarioLogado instanceof Cliente) {
                Cliente clienteLogado = (Cliente) usuarioLogado;
                System.out.println("Bem-vindo, " + clienteLogado.getNome() + "! Você tem " + clienteLogado.getIdade() + " anos.");
            } else if (usuarioLogado instanceof Funcionario) {
                Funcionario funcionarioLogado = (Funcionario) usuarioLogado;
                System.out.println("Bem-vindo, " + funcionarioLogado.getNome() + "! Cargo: " + funcionarioLogado.getCargo());
            }
        } else {
            System.out.println("Usuário ou senha incorretos. Tente novamente.");
        }
    }
}
