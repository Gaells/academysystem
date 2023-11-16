package com.trabalholpoo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Academia {
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;
    private List<Servico> servicos;

    public Academia() {
        this.clientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.servicos = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void cadastrarServico(Servico servico) {
        servicos.add(servico);
    }

    public List<String> listarNomesClientes() {
        return clientes.stream()
                .map(Cliente::getNome)
                .collect(Collectors.toList());
    }

    public List<String> listarNomesFuncionarios() {
        return funcionarios.stream()
                .map(Funcionario::getNome)
                .collect(Collectors.toList());
    }

    public List<String> listarNomesServicos() {
        return servicos.stream()
                .map(Servico::getNome)
                .collect(Collectors.toList());
    }

    public Pessoa fazerLogin(String usuario, String senha) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            return clientes.stream()
                    .map(cliente -> executor.submit(() -> cliente.verificarCredenciais(usuario, senha) ? cliente : null))
                    .map(futuro -> {
                        try {
                            return futuro.get();
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .filter(pessoa -> pessoa != null)
                    .findFirst()
                    .orElse(null);
        } finally {
            executor.shutdown();
        }
    }
}
