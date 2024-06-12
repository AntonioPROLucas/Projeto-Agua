package com.mycompany.projeto.agua;

import java.util.Scanner;
/**
 *
 * @author ggnpf
 */
class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private int idade;
    private String cpf;
    private String senha;

    // Construtor
    public Cliente(String nome, String endereco, int idade, String cpf, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.cpf = cpf;
        this.senha = senha;
    }
    
    public Cliente(String nome, String endereco, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.senha = senha;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}