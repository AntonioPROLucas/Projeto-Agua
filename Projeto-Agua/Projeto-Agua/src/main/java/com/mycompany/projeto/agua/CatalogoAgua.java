/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.agua;

import java.util.ArrayList;

/**
 *
 * @author ggnpf
 */
public class CatalogoAgua {

    private ArrayList<Produto> produtos = new ArrayList<>(); // ArrayList inicializado aqui!

    public void adicionarAgua(Produto produto) {
        this.produtos.add(produto);
    }

    public void exibirCatalogo() {
        System.out.println("\nCatálogo de Águas:");
        if (produtos.isEmpty()) {
            System.out.println("O catálogo está vazio.");
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                System.out.println((i + 1) + " - "
                        + "Codigo: " + produto.getCodigoProduto() + " - "
                        + produto.getMarca() + " - "
                        + produto.getVolume() + "L - R$"
                        + produto.getPreco() + " - "
                        + "UND: " + produto.getUnidades() + " - "
                        + "Data de validade: "
                        + produto.getDataValidade());
            }
        }
    }

    Produto getProduto(int indice) {
        if (indice >= 0 && indice < produtos.size()) {
            return produtos.get(indice);
        } else {
            return null; // Retorna null se o índice estiver fora do intervalo válido
        }
    }
}
