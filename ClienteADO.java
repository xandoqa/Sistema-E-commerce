package com.mycompany.ecommerce;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alexandre.rcosta
 */

// código montado por Alexandre, Ester e Vinicius

public class ClienteADO { // Ester: a classe gerencia todas as operações de CRUD para a tabela Cliente no banco de dados
    private Connection connection; // Vinicius: conexão com o banco de dados
    
    // Vinicius: construtor da classe ClienteADO
    public ClienteADO(){
        connection = Database.getConnection(); // Vinicius: método para estabelecer a conexão com o banco de dados
    }

    // Vinicius: método pra criar um novo cliente no banco de dados
    // Vinicius: usamos o "Throws SQLException" para caso tenha problemas, que seja necessário arrumá-los
    public void criarCliente(Cliente cliente) throws SQLException {
        // Vinicius: SQL para inserir um novo cliente na tabela 'clientes'
        String sql = "insert into clientes (nome, email, telefone, data_cadastro) values (?, ?, ?, ?)";
        
        // Vinicius: preparação do statement para evitar injeção SQL
        PreparedStatement pstmt = connection.prepareStatement(sql);
        // Vinicius: definindo os parâmetros do statement com os dados do cliente
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getEmail());
        pstmt.setString(3, cliente.getTelefone());
        pstmt.setDate(4, new java.sql.Date(cliente.getDataCadastro().getTime())); // Convertendo a data

        // Vinicius: executando a atualização (inserção) no banco de dados
        pstmt.executeUpdate();
    }

    // Alexandre: Tentei deixar as linhas de código mais funcionais e pequenas possíveis, para evitar bagunça e várias linhas de códigos descenessários. 
    // Alexandre: Tentei usar o ChatGPT, mas não ficava do jeito que queria, então fiz tudo na "raça"...
    public List<Cliente> listarClientes() throws SQLException { // Vinicius: método para listar todos os clientes do banco de dados
        List<Cliente> clientes = new ArrayList<>(); // Vinicius: lista para armazenar os clientes
        String sql = "SELECT * FROM clientes"; // Vinicius: SQL para selecionar todos os clientes
        Statement stmt = connection.createStatement(); // Vinicius: criando um statement para executar a consulta
        ResultSet rs = stmt.executeQuery(sql); // Vinicius: fazendo a consulta e armazenando os resultados
        
        // Vinicius: loop para iterar sobre os resultados
        while (rs.next()) {
            // Vinicius: adicionando cada cliente à lista de clientes
            clientes.add(new Cliente(
                rs.getInt("cliente_id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getDate("data_cadastro")
            ));
        }
        return clientes; // Vinicius: retornando a lista de clientes
    }

    // Alexandre: método para buscar um cliente específico pelo ID
    public Cliente buscarCliente(int clienteId) throws SQLException {
        // Alexandre: SQL para selecionar um cliente específico pelo ID
        String sql = "SELECT * FROM clientes WHERE cliente_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql); // Alexandre: preparando o statement
        pstmt.setInt(1, clienteId); // Alexandre: definindo o parâmetro do ID do cliente
        ResultSet rs = pstmt.executeQuery(); // Alexandre: executando a consulta
        
        // Alexandre: verificando se o cliente foi encontrado
        if (rs.next()) {
            // Alexandre: retornando o cliente encontrado
            return new Cliente(
                rs.getInt("cliente_id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getDate("data_cadastro")
            );
        }
        return null; // Alexandre: retornando null se o cliente não for encontrado
    }

    // Alexandre: método para atualizar as informações de um cliente existente
    public void atualizarCliente(Cliente cliente) throws SQLException {
        // Alexandre: SQL para atualizar os dados do cliente
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ? WHERE cliente_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql); // Preparando o statement
        // Alexandre: definindo os parâmetros com os novos dados do cliente
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getEmail());
        pstmt.setString(3, cliente.getTelefone());
        pstmt.setInt(4, cliente.getClienteId()); // Alexandre: ID do cliente a ser atualizado
        
        // Alexandre: fazendo a atualização no banco de dados
        pstmt.executeUpdate();
    }

    // Alexandre: método para excluir um cliente pelo ID
    public void excluirCliente(int clienteId) throws SQLException {
        // Alexandre: SQL para deletar um cliente específico pelo ID
        String sql = "DELETE FROM clientes WHERE cliente_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql); // Alexandre: preparando o statement
        pstmt.setInt(1, clienteId); // Alexandre: definindo o ID do cliente a ser excluído
        
        // Alexandre: fazendo a exclusão no banco de dados
        pstmt.executeUpdate();
    }
}
