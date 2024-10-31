/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clienteado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author alexandre.rcosta
 */

//quem montou todo o código foi o alexandre e a ester

public class ClienteADO {
    private Connection connection;
    
    public ClienteADO(){
        connection = Database.getconnection(); // "database.getconnection" para obter a conexão
    }
    // --- Utilizei o "Throws SQLException" para que, caso tenha problemas, que seja necessário arrumá-los.
    public void criarCliente(Cliente cliente) throws SQLException{
        
        String sql = "insert into clientes (nome, email, telefone, data_cadastro) values (?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getEmail());
        pstmt.setString(3, cliente.getTelefone());
        pstmt.setDate(4, new java.sql.Date(cliente.getDataCadastro().getTime()));
        pstmt.executeUpdate();
         
    }
    //Notas do Alexandre: Logo abaixo tentei deixar as linhas de código mais funcionais e pequenas possíveis, para evitar bagunça e várias linhas de códigos descenessários, tentei usar o Chatgpt mas não ficava do jeito que queria, então fiz tudo na "raça"
     public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            clientes.add(new Cliente(
                rs.getInt("cliente_id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getDate("data_cadastro")
            ));
        }
        return clientes;
    }

    public Cliente buscarCliente(int clienteId) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE cliente_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, clienteId);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new Cliente(
                rs.getInt("cliente_id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getDate("data_cadastro")
            );
        }
        return null;
    }

    public void atualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ? WHERE cliente_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getEmail());
        pstmt.setString(3, cliente.getTelefone());
        pstmt.setInt(4, cliente.getClienteId());
        pstmt.executeUpdate();
    }

    public void excluirCliente(int clienteId) throws SQLException {
        String sql = "DELETE FROM clientes WHERE cliente_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, clienteId);
        pstmt.executeUpdate();
    }
}

**NOTAS DO ALEXANDRE: ESTER O CÓDIGO ESTÁ COMPLETO, MAS DÊ UMA OLHADA E MODIFIQUE ALGUMAS COISAS.
