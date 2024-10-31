/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cliente
import java.util.Date
/**
 *
 * @author alexandre.rcosta
 */
        //Notas do Alexandre: tentei manter toda a nomenclatura consistente em todo o código.
public class Cliente  {
    private int clienteId;
    private String nome;
    private String email;
    private String telefone;
    private Date dataCadastro;   
    //pra que serve o "this": Objeto em que o código está sendo executado
    public cliente(int clienteId, String nome, String email, String telefone, Date dateCadastro){
        this.clienteId = clienteId;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }
    
    public int getClienteId() { return clienteId; }
    public String getNome() { return nome;}
    public String getEmail() { return email;}
    public String getTelefone() { return telefone;}
    public Date getDataCadastro() { return dataCadastro; }
    
    public void setNome(String nome) { this.nome = nome;}
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) {this.telefone = telefone;}
}
