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
public class Pedido {
    private Cliente cliente;
    private ArrayList<Produto> itens;
    private double valorTotal;
    private String formaPagamento;
    // Outros dados relevantes do pedido, como data, status, etc.

    // Construtor, getters e setters

    public void adicionarItem(Produto agua) {
        itens.add(agua);
        // Atualizar valorTotal
    }

    public void removerItem(Produto agua) {
        itens.remove(agua);
        // Atualizar valorTotal
    }
}
