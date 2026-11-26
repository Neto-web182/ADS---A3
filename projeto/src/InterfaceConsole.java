package projeto.src;
import java.util.Scanner;

/**
 * @author do código: João Moura da Fonseca Neto
 * Data de finalização: 25/11/26
 * @version 3.0
 * 
**/

public class InterfaceConsole {
    public static void main(String[] args) {

        // Objetos (variáveis de refência)
        Scanner entrada = new Scanner(System.in);
        LeitorEntrada leitor              = new LeitorEntrada();
        ControleAcesso acesso             = new ControleAcesso();
        SistemaCardapio gerenciarCardapio = new SistemaCardapio() ;
        SistemaPedido pedidoCliente       = new SistemaPedido();
        SistemaDoDono dono                = new SistemaDoDono();

        // var de customização da classe InterfaceConsole
        String corVermelha = "\u001B[91m";
        String corVerde    = "\u001B[92m";
        String corAmarelo  = "\u001B[93m";
        String corRoxo     = "\u001B[94m";
        String corCiano    = "\u001B[96m";
        String limpar      = "\u001B[0m";
        String negrito     = "\u001B[1m";

        // Declarando variáveis para poder usar em todo corpo do código
        String nomeCliente ;
        String nomePizzaria = "nossa pizzaria";

        // Declarando var de parada do loop principal a seguir
        int opcao;

        do{
            System.out.printf("""
            \n=======%s%s PORTAL DE ACESSO %s=======
            %s{1}%s - Acesso Cliente 
            %s{2}%s - Acesso Gerente (Login)
            %s{3}%s - Acesso Dono do Restaurante (Login)
            %s{0}%s - Encerrar sistema
            ===================================
            Selecione seu perfil de acesso: """, negrito, corRoxo, limpar, corRoxo ,limpar, corRoxo, limpar, corRoxo, limpar, corRoxo, limpar);
            opcao = leitor.lerInteiro(entrada);

            // BUG do Scanner
            entrada.nextLine();

            switch (opcao) {
              
                case 1:
                    //fluxo do pedido do cliente

                    System.out.print("\nOlá! Bem-vindo(a) à "+ nomePizzaria +"!\nComo posso te chamar? Digite seu nome: ");
                    nomeCliente = entrada.nextLine();

                    // Declarando minha var para poder utilizar no corpo do código do-while
                    int opcaoCliente;

                    do {
                        System.out.printf("""
                        \n%s=======%s ATENDIMENTO AO CLIENTE (%s) %s=======
                        {1} - Ver cardápio
                        {2} - Fazer pedido
                        {0} - Encerrar atendimento
                        Escolha: """,negrito , corCiano, nomeCliente ,limpar);

                        opcaoCliente = leitor.lerInteiro(entrada);
                        entrada.nextLine();

                        switch (opcaoCliente) {
                            case 1:
                                System.out.printf("""
                                \n%s==================================================================
                                                          CARDÁPIO  
                                ==================================================================%s
                                """, negrito, limpar);   
                                gerenciarCardapio.exibirCardapio();
                                break;

                            case 2:
                                // se o cardápio estiver vazio esse if impede do cliente continuar o fluxo
                                if (gerenciarCardapio.produto.size() == 0) {
                                    System.out.println("\nNão é possível fazer o pedido no momento");
                                    break;
                                }

                                System.out.printf("""
                                \n%s==================================================================
                                                      CARDÁPIO  
                                ==================================================================%s
                                """, negrito, limpar);   
                                gerenciarCardapio.exibirCardapio();

                                int continuarAdicionando = 1;  // Mantém o loop ativo para pedir uma nova posição válida
                                do{ 
                                    System.out.print("\n"+nomeCliente+", digite o número do seu pedido por gentileza: ");
                                    int posicaoPedido = leitor.lerInteiro(entrada);

                                    // if para verifiar se a posição informada existe no array
                                    if (posicaoPedido >= 0 && posicaoPedido < gerenciarCardapio.produto.size()) {

                                        pedidoCliente.adicionarPedido(
                                            posicaoPedido,
                                            gerenciarCardapio.produto,
                                            gerenciarCardapio.descricao,
                                            gerenciarCardapio.preco
                                        );  

                                        System.out.printf(corVerde+"\nPedido adicionado com sucesso!!\n"+limpar);
                                        
                                        do{
                                            System.out.print("""
                                            Deseja adicionar um novo item?
                                            [1] para sim
                                            [0] para não
                                            Opção: """);
                                            continuarAdicionando = leitor.lerInteiro(entrada); 
                                                
                                            switch(continuarAdicionando){
                                                case 1:
                                                    System.out.print("\nDigite o número do seu próximo pedido por gentileza: ");
                                                    posicaoPedido = leitor.lerInteiro(entrada);

                                                    // if para verifiar se a posição informada existe no array
                                                    if (posicaoPedido >= 0 && posicaoPedido < gerenciarCardapio.produto.size()) {

                                                        pedidoCliente.adicionarPedido(
                                                            posicaoPedido,
                                                            gerenciarCardapio.produto,
                                                            gerenciarCardapio.descricao,
                                                            gerenciarCardapio.preco
                                                        );  

                                                        System.out.printf(corVerde+"\nPedido adicionado com sucesso!!\n"+limpar);
                                                    }

                                                    else{
                                                        System.out.print("\nPosição inválida!\n");
                                                    }
                                                    break;

                                                case 0:
                                                    System.out.println("\nOk.");
                                                    break;

                                                default:
                                                    System.out.println(corVermelha+"\nOpção inválida!! Por favor digite '1' para sim ou '0' para não.\n"+limpar);
                                                    break;
                                                }
                                        } while (continuarAdicionando != 0);
                                                                        
                                    }                            
                                    else{
                                        System.out.print("\nPosição inválida!\n");
                                    }

                                } while(continuarAdicionando != 0);
                                                                                                                         
                                // Bug do scanner
                                entrada.nextLine();

                                // var de parada do loop a seguir
                                boolean opcaoInvalida = true ;

                                do {
                                    System.out.print("""
                                    \n(Obs: Oferecemos entrega para os seguintes bairros: Planalto e Pitimbu.)
                                    Seu pedido vai ser para retirada ou entrega? """);
                                    String modoDeEntrega = entrada.nextLine().toLowerCase();

                                    switch (modoDeEntrega) {
                                        case "retirada":
                                            System.out.println("ok.");
                                            opcaoInvalida = false;
                                            break;

                                        case "entrega":
                                            boolean bairroInvalido;

                                            do {
                                                System.out.print("""
                                                \nTaxa de entrega:
                                                Bairro Planalto : R$10,00
                                                Bairro Pitimbu  : R$15,00

                                                Seu bairro: """);
                                                String opcaoBairro = entrada.nextLine().toLowerCase();

                                                System.out.print("endereço: ");
                                                String endereco = entrada.nextLine();

                                                bairroInvalido = pedidoCliente.calcularEntrega(opcaoBairro, endereco);

                                                if (bairroInvalido) {
                                                    System.out.println("Digite exatamente 'Planalto' ou 'Pitimbu'.");
                                                }

                                            } while (bairroInvalido);

                                            opcaoInvalida = false;
                                            break;

                                        default:
                                            System.out.println("\nOpção inválida! Digite exatamente 'retirada' ou 'entrega'.\n");
                                            break;
                                    }

                                } while (opcaoInvalida);

                                System.out.printf("\n%s____________________Resumo do pedido_____________________%s\n", negrito, limpar);
                                System.out.println(corAmarelo);
                                pedidoCliente.exibirResumoPedido(); 
                                System.out.print(limpar);
                                System.out.println("_________________________________________________________");

                                System.out.print("\nObs: responda com sim ou não\nSeu pedido está correto? ");
                                String confirmacao = entrada.nextLine().toLowerCase();

                                boolean confirmacaoPedido = pedidoCliente.confirmarPedido(confirmacao);

                                if (confirmacaoPedido == true){
                                    System.out.println("Perfeito "+ nomeCliente +"!!");

                                    // chamando o metódo para registrar o pedido no sistema de relatório do dono
                                    dono.registrarPedido(
                                        nomeCliente, 
                                        pedidoCliente.getResumoPedido(), 
                                        pedidoCliente.getResumoPreco() ,
                                        pedidoCliente.getValorTotal() ,
                                        pedidoCliente.getTaxaEntrega() 
                                    );

                                    //var de parada do loop a seguir 
                                    boolean continuarLoopTroco = true;

                                    do{
                                        System.out.printf("\nPrecisa de troco? ");
                                        String respostaTroco = entrada.nextLine().toLowerCase();

                                        switch (respostaTroco) {
                                            case "sim":
                                                System.out.print("\nTroco pra quanto?\nValor: R$");
                                                double valor = leitor.lerDouble(entrada);

                                                boolean trocoRealizado = pedidoCliente.calcularTroco(valor, nomeCliente);

                                                while (trocoRealizado == false){
                                                    System.out.println("\nO valor informado é inferior ao valor do pedido. Digite o valor correto..");
                                                    
                                                    System.out.print("\nTroco pra quanto?\nValor: R$");
                                                    valor = leitor.lerDouble(entrada);

                                                    trocoRealizado = pedidoCliente.calcularTroco(valor, nomeCliente);
                                                }

                                                System.out.printf("""
                                                \n%s%s seu atendimento foi finalizado!!
                                                Agradecemos a sua prefêrencia.%s \n""", corVerde , nomeCliente, limpar );

                                                continuarLoopTroco = false ;
                                                pedidoCliente.limparPedido();
                                                break;
                                        
                                            case "não":
                                            case "nao":

                                                System.out.printf("""
                                                \n%sOk.
                                                Seu pedido está finalizado %s!!
                                                Agradecemos a sua prefêrencia.%s \n""", corVerde, nomeCliente, limpar );

                                                continuarLoopTroco = false ;
                                                pedidoCliente.limparPedido();
                                                break;

                                            //default para checar se a opção existe dentro do menu 
                                            default:
                                                System.out.println(corVermelha+"\nOpção inválida!! Por favor digite 'sim' ou 'não'.\n"+limpar);
                                                continuarLoopTroco = true ;
                                                break;
                                        }
                                        
                                    } while (continuarLoopTroco);

                                }
                                else{
                                    System.out.println(corVermelha+"Reinicie o atendimento!"+limpar); 
                                    pedidoCliente.limparPedido();
                                }

                                break; // final do case interno

                            case 0:
                                System.out.println("Saindo do atendimento..");
                                break;

                            default:
                                System.out.println(corVermelha+"Opção inválida! Digite 1, 2 ou 0."+limpar);
                                break;
                        }

                    } while(opcaoCliente !=0);

                    break; // final do fluxo cliente


                case 2:
                    // fluxo gerente
                    int opcaoGerente;
                    
                    do {
                        System.out.printf("""
                        \n==================================
                        |     %s%sTela de Login Gerente%s      |
                        |  %s[1]%s - Se cadastrar            |
                        |  %s[2]%s - Fazer login             |
                        |  %s[0]%s - Sair                    | 
                        ==================================
                        Digite a opção correspondente: """, negrito, corAmarelo, limpar, corAmarelo, limpar, corAmarelo, limpar, corAmarelo, limpar);
                        opcaoGerente = leitor.lerInteiro(entrada);

                        // bug do Scanner
                        entrada.nextLine(); 

                        switch (opcaoGerente) {
                            case 1:
                                System.out.println("\n___ TELA DE CADASTRO ___");

                                System.out.print("Digite o seu nome: ");
                                String cadastroGerente = entrada.nextLine();
                                System.out.print("Digite a senha: ");
                                String cadastroSenha = entrada.nextLine();

                                // Chama o método de cadastrar o gerente e passa as variaveis
                                acesso.cadastrarGerente(cadastroGerente, cadastroSenha);
                                            
                                break;

                            case 2:
                                System.out.println("\n___ TELA DE LOGIN ___");
                                        
                                if (acesso.gerenteCadastrado()) {
                                    System.out.print("Digite o seu nome: ");
                                    String usuarioGerente = entrada.nextLine();

                                    System.out.print("Digite a senha: ");
                                    String senhaGerente = entrada.nextLine();

                                    // Chama o método de autenticação e passa as var
                                    boolean autenticado = acesso.autenticarGerente(usuarioGerente, senhaGerente);

                                    if (autenticado){
                                        System.out.println("Acesso permitido! Bem-vindo "+ usuarioGerente +"!");

                                        // var de parada do loop a seguir
                                        boolean continuarSistema = true;

                                        // loop gerente
                                        do{
                                            System.out.printf("""
                                            \n%s==================================================================
                                                                SISTEMA DE CARDÁPIO
                                            ==================================================================%s
                                            {1} - Listar cardápio.
                                            {2} - Adicionar novo produto.
                                            {3} - Alterar produto.
                                            {4} - Remover produto.
                                            {5} - Limpar cardápio.
                                            {0} - Sair do menu.
                                            -----------------------------------------------------------------
                                            """, negrito, limpar);  

                                            System.out.print("Digite sua opção: ");
                                            int opcaoSistema = leitor.lerInteiro(entrada);

                                            // BUG do Scanner
                                            entrada.nextLine();
                            
                                            int posicao;

                                            switch (opcaoSistema){
                                                case 1:
                                                    System.out.printf("""
                                                    \n%s==================================================================
                                                                        CARDÁPIO  ATUAL
                                                    ==================================================================%s
                                                    """, negrito, limpar);   
                                                    gerenciarCardapio.exibirCardapio();

                                                    break;


                                                case 2:
                                                    System.out.printf("""
                                                    \n%s=================================================================
                                                                        ADICIONAR PRODUTO  
                                                    ==================================================================%s
                                                    """, negrito, limpar);

                                                    System.out.print("Digite o novo produto: ");
                                                    String produto = entrada.nextLine();

                                                    System.out.print("Digite a descrição do produto: ");
                                                    String descricao = entrada.nextLine();

                                                    System.out.print("Digite o valor do novo produto: R$");
                                                    double preco = leitor.lerDouble(entrada);

                                                    while(preco <= 0){
                                                        System.out.println("Preço inválido!\n");

                                                        System.out.print("Digite o valor do novo produto: R$");
                                                        preco = leitor.lerDouble(entrada);
                                                    }
                                                    
                                                    // METÓDO para adicionar o produtoObject no arrayList
                                                    gerenciarCardapio.adicionarProduto(produto, descricao , preco);

                                                    System.out.println("\nNovo produto adicionado com sucesso!");
                                                    break;


                                                case 3:
                                                    if (gerenciarCardapio.produto.size() == 0) {
                                                        System.out.println("Não há produtos para alterar! Adicione um produto no cardápio primeiro.");
                                                    }

                                                    else{                                                       
                                                        System.out.printf("""
                                                        \n%s=================================================================
                                                                            ALTERAR PRODUTO  
                                                        =================================================================%s 
                                                        """, negrito, limpar);

                                                        gerenciarCardapio.exibirCardapio();

                                                        System.out.print("Primeiro digite a posição do produto que você quer alterar.\nPosição: ");
                                                        posicao = leitor.lerInteiro(entrada);

                                                        // bug do Scanner
                                                        entrada.nextLine();

                                                        // Condicional para verificar se a posição informada pelo usúario realmente existe no ArrayList.
                                                        if (posicao >= 0 && posicao < gerenciarCardapio.produto.size() ){
                                                            System.out.print("\nAgora digite o novo produto para a posição ["+posicao+"]: ");
                                                            String novoProduto = entrada.nextLine();
                                                        
                                                            System.out.print("Digite a nova descrição do produto: ");
                                                            String novaDescricao = entrada.nextLine();
                                                        
                                                            System.out.print("Digite o novo valor do produto: R$");
                                                            double novoPreco = leitor.lerDouble(entrada);

                                                             while(novoPreco <= 0){
                                                                System.out.println("Preço inválido!\n");

                                                                System.out.print("Digite o valor do novo produto: R$");
                                                                novoPreco = leitor.lerDouble(entrada);
                                                            }

                                                            //METÓDO para alterar o produto
                                                            gerenciarCardapio.alterarProduto(posicao, novoProduto, novaDescricao, novoPreco);
                                                            
                                                            System.out.println("\nProduto alterado com sucesso!");  
                                                        }
                                                        else{
                                                            System.out.print("\nPosição inválida!");
                                                        }
                                                                                                         
                                                    }
                                                    break;

                                                case 4:
                                                    if (gerenciarCardapio.produto.size() == 0) {
                                                        System.out.println("Não há produtos para remover! Adicione um produto no cardápio primeiro.");
                                                    }

                                                    else{
                                                        System.out.printf("""
                                                        \n%s=================================================================
                                                                            REMOVER PRODUTO  
                                                        =================================================================%s
                                                        """, negrito, limpar);

                                                        gerenciarCardapio.exibirCardapio();

                                                        System.out.print("Digite a posição do produto que deseja remover: ");
                                                        posicao = leitor.lerInteiro(entrada);

                                                        gerenciarCardapio.removerProduto(posicao);
                                                    }

                                                    break;

                                                case 5:
                                                    if (gerenciarCardapio.produto.size() == 0) {
                                                        System.out.println("Não há cardápio para limpar! Cadastre um cardápio primeiro.");
                                                    }

                                                    else{
                                                        System.out.printf("""
                                                        \n%s=================================================================
                                                                            LIMPAR TODO CARDÁPIO  
                                                        ================================================================= %s
                                                        """, negrito , limpar);

                                                        System.out.print("""
                                                        Deseja mesmo limpar todo cardápio? Se sim, escreva 'sim'.
                                                        Se não, digite qualquer outra coisa.
                                                        Confirme: """);
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
                                                        
                                                    }

                                                    break;

                                                case 0:
                                                    System.out.printf("""
                                                    \n%s=================================================================
                                                                        ENCERRANDO O SISTEMA...
                                                    ================================================================= %s
                                                    """, negrito, limpar);

                                                    continuarSistema = gerenciarCardapio.encerrarMenu();
                                                    break; 
                                                
                                                default:
                                                    System.out.println(corVermelha +"Opção inválida, digite uma opção existente."+ limpar);
                                                    break;

                                            } // Final do switch do gerente
                                    
                                        } while (continuarSistema); // loop do sistema gerente
                                    }

                                    // Se o gerente não for autenticado
                                    else{
                                        System.out.println(corVermelha +"Erro: Usuário ou senha incorretos."+ limpar);
                                    }
                                }

                                // Se não tiver cadastro
                                else {
                                    System.out.println("Nenhum usuário cadastrado!\nFaça o cadastro na opção 1 primeiro.");
                                }

                                break; // final do case 2 interno
                                                      
                            case 0:
                                System.out.println("Saindo da tela de login do gerente..");                      
                                break;

                            default:
                                System.out.println(corVermelha +"Opção inválida! Digite 1, 2 ou 0."+ limpar);
                                break;

                        } // final do switch tela de login do gerente  

                    } while (opcaoGerente != 0);  // loop da tela de login Gerente

                    break; // final do fluxo do gerente


                case 3:
                    // fluxo do dono
                    int opcaoDono;

                    do {
                        System.out.printf("""
                        \n==================================
                        |     %s%sTela de Login do Dono%s      |
                        |  %s[1]%s - Se cadastrar            |
                        |  %s[2]%s - Fazer login             |
                        |  %s[0]%s - Sair                    | 
                        ==================================
                        Digite a opção correspondente: """, negrito, corVerde, limpar, corVerde, limpar, corVerde, limpar, corVerde, limpar);
                        opcaoDono = leitor.lerInteiro(entrada);

                        // bug do Scanner
                        entrada.nextLine(); 

                        switch (opcaoDono) {
                            case 1:
                                System.out.println("\n___ TELA DE CADASTRO ___");

                                System.out.print("Digite o seu nome: ");
                                String cadastroDono = entrada.nextLine();
                                System.out.print("Digite a senha: ");
                                String cadastroSenha = entrada.nextLine();

                                // Chama o método de cadastrar o dono e passa as variaveis
                                acesso.cadastrarDono(cadastroDono, cadastroSenha);
                                            
                                break;

                            case 2:
                                System.out.println("\n___ TELA DE LOGIN ___");
                                        
                                if (acesso.donoCadastrado()) {
                                    System.out.print("Digite o seu nome: ");
                                    String usuarioDono = entrada.nextLine();

                                    System.out.print("Digite a senha: ");
                                    String senhaDono = entrada.nextLine();

                                    // Chama o método de autenticação e passa as var
                                    boolean autenticado = acesso.autenticarDono(usuarioDono, senhaDono);

                                    if (autenticado){
                                        System.out.println("Acesso permitido! Bem-vindo "+ usuarioDono +"!");

                                        int opcaoSistemaRelatorio;

                                        do { 
                                            System.out.printf("""
                                            \n%s==================================================================
                                                                SISTEMA DO DONO
                                            ==================================================================%s
                                            {1} - Acessar Faturamento do dia
                                            {2} - Acessar Histórico da pizzaria
                                            {3} - Modificar nome da pizzaria
                                            {0} - Sair do sistema

                                            -----------------------------------------------------------------
                                            """, negrito, limpar);  

                                            System.out.print("Digite sua opção: ");
                                            opcaoSistemaRelatorio = leitor.lerInteiro(entrada);

                                            // Bug do scanner
                                            entrada.nextLine();

                                            switch (opcaoSistemaRelatorio){
                                                case 1:
                                                    System.out.printf("""
                                                    \n%s=================================================================
                                                                        FATURAMENTO DA PIZZARIA
                                                    =================================================================%s
                                                    """, negrito, limpar);

                                                    dono.exibirFaturamento();
                                                    break;

                                                case 2:
                                                    System.out.printf("""
                                                    \n%s=================================================================
                                                                        HISTÓRICO DA PIZZARIA
                                                    =================================================================%s
                                                    """, negrito, limpar);

                                                    dono.exibirHistorico(acesso.getUsuarioGerente(), acesso.getSenhaGerente());
                                                    break;

                                                case 3:
                                                    System.out.printf("""
                                                    \n%s=================================================================
                                                                        NOVO NOME DA PIZZARIA   
                                                    =================================================================%s 
                                                    """, negrito , limpar);

                                                    System.out.print("Digite o novo nome da pizaria (ex: pizzaria do..)\nNovo nome: ");
                                                    String novoNome = entrada.nextLine();

                                                    nomePizzaria = dono.modificarNome(novoNome);
                                                    break;    

                                                case 0:
                                                    System.out.println("Saindo do sistema de relatório..");
                                                    break;

                                                default:
                                                    System.out.println(corVermelha+"Opção inválida! Digite 1, 2, 3 ou 0."+limpar);
                                                    break;
                                            }

                                        } while (opcaoSistemaRelatorio != 0);
                                    }

                                }
                                else {
                                    System.out.println("Nenhum usuário cadastrado!\nFaça o cadastro na opção 1 primeiro.");
                                }
                                break;

                            case 0:
                                System.out.println("Saindo da tela de login do dono..");  
                                break;

                            default:
                                System.out.println(corVermelha+"Opção inválida! Digite 1, 2 ou 0."+limpar);
                                break;

                            } // switch tela de login do dono

                    } while (opcaoDono != 0); // loop da tela do login do dono

                    break; // final do fluxo do dono


                case 0:
                    System.out.println("Saindo do portal de acesso..");

                    break;           

                default:
                    System.out.println(corVermelha+"Opção inválida! Digite 1, 2, 3 ou 0"+limpar);
                    break;


            }// primeiro switch


        } while (opcao != 0); // loop do portal de acesso

        System.out.println(corVerde+"\nSistema encerrado!!"+limpar);

    }// Main

}