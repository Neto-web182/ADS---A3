package projeto.src;

import java.util.Scanner;
   
public class Login {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // declarando minha variável de referência ao meu objeto para que eu possa utilizar em todo escopo de vida do código
        Autenticacao verificacao = null; 

        // declarando as variáveis
        int opcao = 0;
        String cadastroUsuario = "";
        String cadastroSenha = "";
        String usuario = "";
        String senha = "";
        boolean temCadastro = false;

        while (opcao != 3) {
            System.out.print("""
            \n==================================
            |         Tela de Login          |
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
                    cadastroUsuario = entrada.nextLine();

                    System.out.print("Digite a senha: ");
                    cadastroSenha = entrada.nextLine();

                    // Objeto recebendo os dados cadastrados
                    verificacao = new Autenticacao(cadastroUsuario, cadastroSenha);

                    verificacao.cadastrar(cadastroUsuario,cadastroSenha);

                    temCadastro = true;
                    

                    break;

                case 2:
                    System.out.println("\n--- TELA DE LOGIN ---");
                 
                    if (temCadastro) {
                        System.out.print("Digite o nome de usuário: ");
                        usuario = entrada.nextLine();

                        System.out.print("Digite a senha: ");
                        senha = entrada.nextLine();

                        // Chama o método de autenticação
                        verificacao.autenticar(usuario, senha);
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
