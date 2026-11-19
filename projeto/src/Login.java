package projeto.src;

import java.util.Scanner;
   
public class Login {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // declarando minha variável de referência ao meu objeto para que eu possa utilizar em todo escopo de vida do código
        ControleAcesso acesso = new ControleAcesso();

        // declarando as variáveis
        int opcao = 0;
        boolean temCadastro = false;

        while (opcao != 3) {
            System.out.print("""
            \n==================================
            |     Tela de Login Gerente      |
            |  [1] - Cadastro                |
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

                    // Chama o método de cadastrar o gerente e passa as var
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
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha 1, 2 ou 3.");
                    break;
            }

        } // fechamento do loop

        System.out.println("\nPrograma encerrado!!");

    }// fechamento do main
}
