package com.mycompany.projeto.agua;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
    private String nome;
    private String cnpj;
    private String contato;
    private List<Produto> produtosFornecidos;
    private int estoque; // Armazena o estoque dos produtos fornecidos

    public Fornecedor(String nome, String cnpj, String contato) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
        this.produtosFornecidos = new ArrayList<>();
        this.estoque = 0; // Inicializa o estoque com 0
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void adicionarProdutoFornecido(Produto produto) {
    this.produtosFornecidos.add(produto);
}

    // Remove um produto da lista de produtos fornecidos
    public void removerProdutoFornecido(Produto produto) {
        this.produtosFornecidos.remove(produto);
    }

    // Retorna a lista de produtos fornecidos
    public List<Produto> getProdutosFornecidos() {
        return this.produtosFornecidos;
    }

    // Retorna a quantidade de um determinado produto fornecido (opcional)
    public int getQuantidadeProdutoFornecido(Produto produto) {
        int quantidade = 0;
        for (Produto p : produtosFornecidos) {
            if (p.equals(produto)) {
            quantidade++;
            }
        }
        return quantidade;
    }
}
