package projeto.src;

import java.util.Scanner;

public class InterfaceConsole {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        // var de refências aos objetos
        SistemaCardapio gerenciarCardapio = new SistemaCardapio() ;
        ControleAcesso acesso = new ControleAcesso();

        // var de parada
        boolean continuar0 = true;

        boolean temCadastro = false;

        do{
            System.out.print("""
            \n======= Portal de acesso =======
            {1} - Acesso Cliente 
            {2} - Acesso Gerente (Login)
            {3} - Acesso Dono do Restaurante (Login)
            {0} - Encerrar sistema
            ===================================
            Selecione seu perfil de acesso: """);
            int opcao = entrada.nextInt();

            // BUG do Scanner
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\nOlá! Bem-vindo(a) à nossa pizzaria!\nComo posso te chamar? Digite seu nome: ");
                    String nomeCliente = entrada.nextLine();

                    int opcaoCliente;

                    do {
                        System.out.printf("""
                        \n=== ATENDIMENTO AO CLIENTE (%s) ===
                        {1} - Ver cardápio
                        {2} - Fazer pedido
                        {0} - Encerrar atendimento
                        Escolha: """,nomeCliente);

                        opcaoCliente = entrada.nextInt();
                        entrada.nextLine();

                        switch (opcaoCliente) {
                            case 1:
                                System.out.println("""
                                \n==================================================================
                                                     CARDÁPIO  ATUAL
                                ==================================================================
                                """);   
                                gerenciarCardapio.exibirCadarpio();
                                break;

                            case 2:
                                //fluxo do pedido do cliente

                                break;

                            default:
                                System.out.println("Opção inválida! Digite 1, 2 ou 0");
                                break;
                        }

                    } while(opcaoCliente !=0);

                    break; // final do case 1


                case 2:
                    while (opcao != 3) {
                        System.out.print("""
                        \n==================================
                        |     Tela de Login Gerente      |
                        |  [1] - Se cadastrar            |
                        |  [2] - Fazer login             |
                        |  [3] - Sair                    | 
                        ==================================
                        Digite a opção correspondente:""");
                        opcao = entrada.nextInt();

                        // bug do Scanner
                        entrada.nextLine(); 

                        switch (opcao) {
                            case 1:
                                System.out.println("\n--- TELA DE CADASTRO ---");

                                System.out.print("Digite o nome de usuário: ");
                                String cadastroUsuario = entrada.nextLine();
                                System.out.print("Digite a senha: ");
                                String cadastroSenha = entrada.nextLine();

                                // Chama o método de cadastrar o gerente e passa as variaveis
                                acesso.cadastrarGerente(cadastroUsuario, cadastroSenha);
                                temCadastro = true;
                                            
                                System.out.println("\nCadastro do gerente realizado com sucesso!\n");
                                break;

                            case 2:
                                System.out.println("\n--- TELA DE LOGIN ---");
                                        
                                if (temCadastro) {
                                    System.out.print("Digite o nome de usuário: ");
                                    String usuario = entrada.nextLine();

                                    System.out.print("Digite a senha: ");
                                    String senha = entrada.nextLine();

                                    // Chama o método de autenticação e passa as var
                                    boolean autenticado = acesso.autenticarGerente(usuario, senha);

                                    if (autenticado){
                                        System.out.println("Acesso permitido! Bem-vindo "+ usuario +"!");

                                        // var de parada do loop a seguir
                                        boolean continuar1 = true;

                                        // loop gerente
                                        do{
                                            gerenciarCardapio.exibirSistema ();
                                    
                                            System.out.print("Digite sua opção:");
                                            int opcao1 = entrada.nextInt();

                                            // BUG do Scanner
                                            entrada.nextLine();

                                            int posicao;

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

                                                    continuar1 = gerenciarCardapio.encerrarMenu();
                                                    break; 
                                                
                                                default:
                                                    System.out.println("Opção inválida, digite uma opção existente.");
                                                    break;

                                            } // FInal do switch do gerente
                                    
                                        } while (continuar1); // loop do gerente
                                    }

                                    // Se o gerente não for autenticado
                                    else{
                                        System.out.println("Erro: Usuário ou senha incorretos.");
                                    }
                                }

                                // Se não tiver cadastro
                                else {
                                    System.out.println("Nenhum usuário cadastrado!\nFaça o cadastro na opção 1 primeiro.");
                                }

                                break; // final do case 2 interno
                                                      
                            case 3:
                                System.out.println("Saindo da tela de login do gerente..");                      
                                break;

                            default:
                                System.out.println("Opção inválida! Digite 1, 2 ou 3");
                                break;

                        } // final do switch tela de login do gerente                                 
                    } 
                    break; // final do case 2 tela de login


                case 3:
                    // var de parada do loop a seguir
                    boolean continuar2 = true;

                    while (continuar2) {

                        System.out.print("""
                        \n==================================
                        |     Tela de Login do Dono      |
                        |  [1] - Se cadastrar            |
                        |  [2] - Fazer login             |
                        |  [3] - Sair                    | 
                        ==================================
                        Digite a opção correspondente:""");
                        opcao = entrada.nextInt();

                        // bug do Scanner
                        entrada.nextLine(); 

                        switch (opcao) {
                            case 1:
                                System.out.println("\n--- TELA DE CADASTRO ---");

                                System.out.print("Digite o nome de usuário: ");
                                String cadastroUsuario = entrada.nextLine();
                                System.out.print("Digite a senha: ");
                                String cadastroSenha = entrada.nextLine();

                                // Chama o método de cadastrar o dono e passa as variaveis
                                acesso.cadastrarDono(cadastroUsuario, cadastroSenha);
                                temCadastro = true;
                                            
                                System.out.println("\nCadastro do gerente realizado com sucesso!\n");
                                break;

                            case 2:
                                System.out.println("\n--- TELA DE LOGIN ---");
                                        
                                if (temCadastro) {
                                    System.out.print("Digite o nome de usuário: ");
                                    String usuario = entrada.nextLine();

                                    System.out.print("Digite a senha: ");
                                    String senha = entrada.nextLine();

                                    // Chama o método de autenticação e passa as var
                                    boolean autenticado = acesso.autenticarDono(usuario, senha);

                                    if (autenticado){
                                        System.out.println("Acesso permitido! Bem-vindo "+ usuario +"!");
                                        // Fluxo do dono..
                                    }
                                    else{
                                        System.out.println("Erro: Usuário ou senha incorretos.");
                                    }
                                }

                                else {
                                    System.out.println("Nenhum usuário cadastrado!\nFaça o cadastro na opção 1 primeiro.");
                                }
                                break;

                            case 3:
                                System.out.println("Saindo da tela de login do dono..");  
                                continuar2 = false ;
                                break;

                            default:
                                System.out.println("Opção inválida! Digite 1, 2 ou 3");
                                break;

                            } // switch tela de login do dono

                    } // while da tela do login do dono
                    break; 

                case 0:
                    continuar0 = false;
                    System.out.println("Finalizando..");
                    break;           

                default:
                    System.out.println("Opção inválida! Digite 1, 2, 3 ou 0");
                    break;


            }// primeiro switch


        } while (continuar0);


    }// Main
    

}
