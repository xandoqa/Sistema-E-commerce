package com.mycompany.ecommerce;

import java.util.Scanner;
import java.util.List;

/**
 * @author alexandre.rcosta
 */

// código montado por Alexandre e Ester

public class Principal { // Ester: a classe é responsável por interagir com o usuário, permitindo cadastrar, listar, atualizar e excluir clientes no sistema do e-commerce
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Alexandre: objeto para capturar entrada do usuário
        ClienteADO clienteADO = new ClienteADO(); // Alexandre: instância de ClienteADO para manipular dados de clientes
        
        // Alexandre: loop principal do menu
        while (true) {
            System.out.println("Selecione uma opção: 1. Cadastrar 2. Listar 3. Atualizar 4. Excluir 5. Sair");
            int opcao = scanner.nextInt(); // Alexandre: lê a opção escolhida pelo usuário
            scanner.nextLine(); // Alexandre: limpa o buffer do scanner

            switch (opcao) {
                case 1: // Alexandre: serve para cadastro
                    System.out.println("Nome:");
                    String nome = scanner.nextLine(); // Alexandre: recebe o nome do cliente
                    System.out.println("E-mail:");
                    String email = scanner.nextLine(); // Alexandre: recebe o e-mail do cliente
                    System.out.println("Telefone:");
                    String telefone = scanner.nextLine(); // Alexandre: recebe o telefone do cliente

                    // Alexandre: cria uma nova instância de Cliente com data atual
                    Cliente cliente = new Cliente(0, nome, email, telefone, new java.util.Date());
                    clienteADO.criarCliente(cliente); // Alexandre: chama o método para cadastrar o cliente no banco
                    System.out.println("Cliente cadastrado com sucesso!");
                    break; // Alexandre: o break encerra o case atual e volta para o menu

                case 2: // Alexandre: isso é para a listagem
                    List<Cliente> clientes = clienteADO.listarClientes(); // Alexandre: obtém lista de clientes
                    for (Cliente c : clientes) { // Alexandre: itera sobre a lista e exibe cada cliente
                        System.out.println(c.getClienteId() + " - " + c.getNome());
                    }
                    break;

                case 3: // Ester: para a atualização
                    System.out.println("ID do cliente para atualizar:");
                    int idAtualizar = scanner.nextInt(); // Ester: lê o ID do cliente a ser atualizado
                    scanner.nextLine(); // Ester: consumir a nova linha do scanner

                    Cliente clienteAtual = clienteADO.buscarCliente(idAtualizar); // Busca o cliente pelo ID
                    if (clienteAtual != null) { // Ester: verifica se o cliente existe
                        System.out.println("Novo nome (atual: " + clienteAtual.getNome() + "):");
                        String novoNome = scanner.nextLine(); // Ester: recebe o novo nome
                        clienteAtual.setNome(novoNome); // Ester: atualiza o nome do cliente

                        clienteADO.atualizarCliente(clienteAtual); // Ester: chama o método para atualizar o cliente
                        System.out.println("Cliente atualizado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado."); // Ester: mensagem de erro caso o cliente não exista
                    }
                    break;

                case 4: // Ester: para excluir
                    System.out.println("ID do cliente para excluir:");
                    int idExcluir = scanner.nextInt(); // Ester: lê o ID do cliente a ser excluído
                    clienteADO.excluirCliente(idExcluir); // Ester: chama o método para excluir o cliente
                    System.out.println("Cliente excluído com sucesso!");
                    break;

                case 5: // Ester: para sair
                    scanner.close(); // Ester: fecha o scanner antes de sair
                    System.out.println("Saindo... Aguarde um instante.");
                    return; // Ester: encerra o programa

                default:
                    System.out.println("Opção inválida."); // Ester: mensagem para opções inválidas
                    break;
            }
        }
    }
}
