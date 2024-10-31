/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.principal;
import java.util.Scanner;
/**
 *
 * @author alexandre.rcosta
 */
//toda esse código foi escrito pelo Alexandre e a Ester Yasmin
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteADO clienteADO = new ClienteADO();
        
        while (true){
            System.out.println("Selecione uma : 1. Cadastrar 2. Listar 3. Atualizar 4. Excluir 5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcao){
                //Notas alexandre: serve para cadastro
                  case 1:
                    System.out.println("Nome:");
                    String nome = scanner.nextLine();
                    System.out.println("E-mail:");
                    String email = scanner.nextLine();
                    System.out.println("Telefone:");
                    String telefone = scanner.nextLine();
                    Cliente cliente = new Cliente(0, nome, email, telefone, new java.util.Date());
                    clienteADO.criarCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                    //utilizei o break para que, quando um comando break é encontrado, o controle é transferido para o comando após o loop ou o switch.
                    
                  case 2:
                      //isso é para a listagem.
                     List<Cliente> clientes = clienteADO.listarClientes();
                    for (Cliente c : clientes) {
                        System.out.println(c.getClienteId() + " - " + c.getNome());
                    }
                    break;
                  case 3: // para a aualização
                    System.out.println("ID do cliente para atualizar:");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    Cliente clienteAtual = clienteADO.buscarCliente(idAtualizar);
                    if (clienteAtual != null) {
                        System.out.println("Novo nome (atual: " + clienteAtual.getNome() + "):");
                        String novoNome = scanner.nextLine();
                        clienteAtual.setNome(novoNome);
                        clienteADO.atualizarCliente(clienteAtual);
                        System.out.println("Cliente atualizado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                
                case 4: // Para exlcuir
                    System.out.println("ID do cliente para excluir:");
                    int idExcluir = scanner.nextInt();
                    clienteADO.excluirCliente(idExcluir);
                    System.out.println("Cliente excluído com sucesso!");
                    break;

                case 5: // Para sair.
                    scanner.close();
                    System.out.println("Saindo... Aguarde um instante.");
                    return;

                default:
                    System.out.println("inválida.");
                    break;    
            }
        }
    }
}
