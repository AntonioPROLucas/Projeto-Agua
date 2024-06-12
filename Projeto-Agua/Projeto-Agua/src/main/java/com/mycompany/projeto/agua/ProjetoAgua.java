 package com.mycompany.projeto.agua;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;

public class ProjetoAgua {
    // Defina a classe LoginInvalidoException fora do método main
    public static class LoginInvalidoException extends Exception {

        public LoginInvalidoException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws SQLException {
        CatalogoAgua catalog = new CatalogoAgua();
        Scanner input = new Scanner(System.in);

        // Adicionando produtos ao catálogo (Exemplos)
        catalog.adicionarAgua(new Produto("Santa Joana", 10.0, 1.5, 20, "02/05/2025", "SJ000 "));
        catalog.adicionarAgua(new Produto("Cristalina", 7.0, 0.5, 30, "05/06/2025", "SJ0000 "));
        catalog.adicionarAgua(new Produto("Terra Santa", 5.5, 1.5, 15, "06/04/2025", "SJ000 "));
        // ... adicione os outros produtos do seu catálogo

        System.out.println("Bem-vindo a Loja de Agua Online!");

        // Fluxo da aplicação baseado no diagrama
        boolean sair = false;
        while (!sair) {
            System.out.println("\nMenu Principal:");
            System.out.println("1 - Explorar Produtos");
            System.out.println("2 - Login");
            System.out.println("3 - Cadastro");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = input.nextInt();
            input.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    catalog.exibirCatalogo();
                    System.out.println("Escolha o número do produto:");
                    int escolhaProduto = input.nextInt();
                    input.nextLine(); // Consumir a quebra de linha
                    Produto produtoSelecionado = catalog.getProduto(escolhaProduto - 1);
                    if (produtoSelecionado != null) {
                        System.out.println("Compra efetuada! Obrigado por escolher " + produtoSelecionado.getMarca() + ".");
                    } else {
                        System.out.println("Escolha Incorreta");
                    }
                    break;
                case 2:
                    // Implementar lógica de cadastro ou login
                    System.out.println("\nDigite seu nome:");
                    String nomeCliente = input.nextLine();
                    System.out.println("\nDigite seu endereço:");
                    String endereco = input.nextLine();
                    System.out.println("\nDigite sua senha:");
                    String senha = input.nextLine();
                    Cliente cliente = new Cliente(nomeCliente, endereco, senha); // Criando um novo cliente
                    try {
                        // Conexão com o banco de dados (use a mesma URL para login e cadastro)
                        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoAgua", "usuario", "senha"); // Use as credenciais do seu banco
                        Statement stmt = conn.createStatement();

                        // Executar a consulta (incluindo a senha)
                        String query = "SELECT * FROM client WHERE nome = '" + cliente.getNome() + "' AND endereco = '" + cliente.getEndereco() + "' AND senha = '" + senha + "'";
                        ResultSet rs = stmt.executeQuery(query);

                        // Verificar se o usuário existe
                        boolean usuarioEncontrado = rs.next(); 

                        if (!usuarioEncontrado) {
                            throw new LoginInvalidoException("Nome, endereço ou senha inválidos."); 
                        } else {
                            System.out.println("Login efetuado com sucesso!"); 
                            // Gere um token de autenticação (se necessário)
                            // ...
                        }

                        // Fechar a conexão
                        rs.close();
                        stmt.close();
                        conn.close();
                    } catch (SQLException | LoginInvalidoException e) {
                        System.out.println("Erro de login: " + e.getMessage());
                    } 
                    break;
                case 3:
                    // Logica de criar uma conta!!
                    System.out.println("\nDigite seu nome:");
                    String nomeCliente2 = input.nextLine();
                    System.out.println("\nDigite seu endereço:");
                    String endereco2 = input.nextLine();
                    System.out.println("\nDigite sua idade:");
                    int idade = input.nextInt();
                    input.nextLine(); // Consumir a quebra de linha
                    System.out.println("\nDigite seu CPF:");
                    String cpf2 = input.nextLine();
                    System.out.println("\nDigite sua senha:");
                    String senha2 = input.nextLine();
                    Cliente cliente2 = new Cliente(nomeCliente2, endereco2, idade, cpf2, senha2); // Criando um novo cliente

                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoAgua", "usuario", "senha")) { // Substitua credenciais
                        try (PreparedStatement stmt = conn.prepareStatement(
                                "INSERT INTO client (nome, endereco, idade, cpf, senha) VALUES (?, ?, ?, ?, ?)"
                        )) {
                            stmt.setString(1, cliente2.getNome());
                            stmt.setString(2, cliente2.getEndereco());
                            stmt.setInt(3, cliente2.getIdade()); 
                            stmt.setString(4, cliente2.getCpf());
                            stmt.setString(5, cliente2.getSenha());

                            int rowsAffected = stmt.executeUpdate();
                            if (rowsAffected > 0) {
                                System.out.println("Cadastro realizado com sucesso!");
                            } else {
                                System.out.println("Erro ao cadastrar usuário.");
                            }
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                    } 
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        System.out.println("Obrigado por usar a loja de água online!");
        input.close();
    }
}