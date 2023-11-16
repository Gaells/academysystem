package com.trabalholpoo;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String nome, String usuario, String senha, String cargo) {
        super(nome, usuario, senha);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
}
