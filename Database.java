/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.database;

/**
 *
 * @author alexandre.rcosta
 */
public class Database {
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/seu_banco"; 
//notas do Alexandre: Isso define a URL de conexão com o banco de dados
        String user = "usuario";
        String password = "senha";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
