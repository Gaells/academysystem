package com.trabalholpoo;

public class Cliente extends Pessoa {
    private int idade;

    public Cliente(String nome, String usuario, String senha, int idade) {
        super(nome, usuario, senha);
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }
}
