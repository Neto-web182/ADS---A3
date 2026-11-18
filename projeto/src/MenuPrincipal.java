package projeto.src;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        SistemaCardapio gerenciarCardapio = new SistemaCardapio() ;

        //var2
        boolean continuar  = true ;
        int posicao, opcao ;

        // loop principal
        do {
            System.out.print("""
            \n======= Sistema da Pizzaria =====
            {1} - Gerente
            {2} - Cliente
            {0} - Encerrar sistema
            =================================

            Selecione seu perfil de acesso
            opção: """);
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:

                    // loop gerente
                    do{
                        gerenciarCardapio.exibirSistema ();
                
                        System.out.print("Digite sua opção:");
                        int opcao1 = entrada.nextInt();

                        // BUG do Scanner
                        entrada.nextLine();

                        switch (opcao1){
                            case 1:
                                System.out.println("""
                                \n==================================================================
                                                     CARDÁPIO  ATUAL
                                ==================================================================
                                """);   
                                gerenciarCardapio.exibirCadarpio();
                                break;


                            case 2:
                                 System.out.println("""
                                \n=================================================================
                                                    ADICIONAR PRODUTO  
                                ==================================================================
                                """);

                                System.out.print("Digite o novo produto: ");
                                String produto = entrada.nextLine();

                                System.out.print("Digite a descrição do produto: ");
                                String descricao = entrada.nextLine();

                                System.out.print("Digite o valor do novo produto: R$");
                                double preco = entrada.nextDouble();
                                
                                // METÓDO para adicionar o produtoObject no arrayList
                                gerenciarCardapio.adicionarProduto(produto, descricao , preco);

                                System.out.println("\nNovo produto adicionado com sucesso!");
                                
                                break;


                            case 3:
                                System.out.println("""
                                \n=================================================================
                                                    ALTERAR PRODUTO  
                                =================================================================    
                                """);

                                System.out.print("Primeiro digite a posição do produto que você quer alterar.\nPosição: ");
                                posicao = entrada.nextInt();

                                // bug do Scanner
                                entrada.nextLine();

                                    System.out.print("\nAgora digite o novo produto para a posição ["+posicao+"]: ");
                                    String novoProduto = entrada.nextLine();
                                 
                                    System.out.print("Digite a nova descrição do produto: ");
                                    String novaDescricao = entrada.nextLine();
                                
                                    System.out.print("Digite o novo valor do produto: R$");
                                    double novoPreco = entrada.nextDouble();

                                    //METÓDO para alterar o produto
                                    gerenciarCardapio.alterarProduto(posicao, novoProduto, novaDescricao, novoPreco);
                                    
                                    System.out.println("\nProduto alterado com sucesso!");
                                break;

                            case 4:
                                System.out.println("""
                                \n=================================================================
                                                    REMOVER PRODUTO  
                                =================================================================  
                                """);

                                System.out.print("Digite a posição do produto que deseja remover: ");
                                posicao = entrada.nextInt();

                                gerenciarCardapio.removerProduto(posicao);
                                break;

                            case 5:
                                System.out.println("""
                                \n=================================================================
                                                    LIMPAR TODO CARDÁPIO  
                                ================================================================= 
                                """);

                                System.out.print("Deseja mesmo limpar todo cardápio? Se sim, escreva 'sim'.\nSe não, digite qualquer outra coisa.\nConfirme: ");
                                String confirmacao = entrada.nextLine().toLowerCase();

                                 switch (confirmacao) {
                                    case "sim":
                                        gerenciarCardapio.limparCardapio();
                                        System.out.println("\nTodo o cardápio foi limpado com sucesso!");

                                        break; 
                                                
                                    default:
                                        System.out.println("\nO cardápio não foi limpo!");
                                        break;
                                }
                                break;

                            case 0:
                                System.out.println("""
                                \n=================================================================
                                                    ENCERRANDO O SISTEMA...
                                ================================================================= """);

                                continuar = gerenciarCardapio.encerrarMenu();
                                break;                    
                        }

                    } while (continuar);

                    break; // caso 1


                case 2:
                    System.out.println("Em desenvolvimento..\n");    
                    break;
            
                case 0:
                    System.out.println("Menu encerrado!");
                    break;
            
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);

    }// main
}
