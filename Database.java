package com.mycompany.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author alexandre.rcosta
 */

// código montado por Alexandre e Artur

public class Database { // Ester: a classe realiza a conexão com o banco de dados através do JDBC
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/ecommerce"; 
        // Artur: isso define a URL de conexão com o banco de dados
        String user = "artur.braz"; // Artur: aqui a gente coloca o usuário do banco
        String password = "senha123"; // Artur: e a senha do banco também
        
        try {
            // Artur: realiza a tentativa de conexão
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // Artur: mensagem de erro caso a conexão não dê certo
            System.err.println("Erro ao conectar com o banco de dados: Verifique a URL, usuário ou senha.");
            e.printStackTrace(); // Artur: exibe detalhes do erro
            return null; // Artur: retorna nulo se a conexão falhar
        }
    }
}
