package projeto.src;

public class Autenticacao {

    // Atributos privados para guardar os dados 
    private String usuarioCadastrado;
    private String senhaCadastrada;

    // Construtor para receber os parametros usuario e senha
    public Autenticacao(String cadastroUsuario, String cadastroSenha) {
        usuarioCadastrado = cadastroUsuario;
        senhaCadastrada   = cadastroSenha;
    }

    // Método para para autenticar o login do usúario
    public void autenticar(String usuario, String senha) {

        if (usuario.equals(usuarioCadastrado) && senha.equals(senhaCadastrada)) {
            System.out.println("Acesso permitido! Bem-vindo "+ usuario +"!");
        } 
        else {
            System.out.println("Erro: Usuário ou senha incorretos.");
        }
    }
}
