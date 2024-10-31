package com.mycompany.ecommerce;

import java.util.Date;

/**
 * @author alexandre.rcosta
 */

// código montado por Alexandre, Ester e André

// Alexandre: tentei manter toda a nomenclatura consistente em todo o código.

public class Cliente { // Ester: a classe representa a estrutura dos dados do cliente
    private int clienteId; // Alexandre: identificador único do cliente
    private String nome; // Alexandre: nome do cliente
    private String email; // Alexandre: email do cliente
    private String telefone; // Alexandre: telefone do cliente
    private Date dataCadastro; // Alexandre: data de cadastro do cliente
    
    // André: pra que serve o "this": Objeto em que o código está sendo executado

    // André: construtor da classe Cliente, inicializa as variáveis com os valores recebidos
    public Cliente(int clienteId, String nome, String email, String telefone, Date dataCadastro) {
        this.clienteId = clienteId; // André: "this" se refere ao atributo da instância atual
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    // André: métodos "getter" para acessar as informações do cliente

    public int getClienteId() { 
        return clienteId; // André: retorna o ID do cliente
    }

    public String getNome() { 
        return nome; // André: retorna o nome do cliente
    }

    public String getEmail() { 
        return email; // André: retorna o email do cliente
    }

    public String getTelefone() { 
        return telefone; // André: retorna o telefone do cliente
    }

    public Date getDataCadastro() { 
        return dataCadastro; // André: retorna a data de cadastro do cliente
    }

    // André: métodos "setter" para atualizar as informações do cliente

    public void setNome(String nome) { 
        this.nome = nome; // André: atualiza o nome do cliente
    }

    public void setEmail(String email) { 
        this.email = email; // André: atualiza o email do cliente
    }

    public void setTelefone(String telefone) { 
        this.telefone = telefone; // André: atualiza o telefone do cliente
    }
}
