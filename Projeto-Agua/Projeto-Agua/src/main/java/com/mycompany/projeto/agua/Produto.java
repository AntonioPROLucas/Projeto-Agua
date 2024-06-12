/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto.agua;



public class Produto {

    private String marca;
    private double preco;
    private double volume;
    private int unidades;
    private String dataValidade;
    private String codigoProduto;
    
    public Produto(String marca, double preco, double volume, int unidades, String dataValidade, String codigoProduto) {
        this.marca = marca;
        this.preco = preco;
        this.volume = volume;
        this.unidades = unidades;
        this.dataValidade = dataValidade;
        this.codigoProduto = codigoProduto;
        
    }

    public String getMarca() {
        return marca;
    }

    public double getPreco() {
        return preco;
    }

    public double getVolume() {
        return volume;
    }

    public int getUnidades() {
        return unidades;
    }
    
     public String getDataValidade() {
        return dataValidade;
     }
      public String getCodigoProduto() {
        return codigoProduto;
      }
}

