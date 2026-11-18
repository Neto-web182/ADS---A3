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

    // Metódo para impedir o cadastro de usúario ou senha que já existe
    public void cadastrar(String cadastroUsuario, String cadastroSenha){
        if ( cadastroUsuario.equals(this.usuarioCadastrado) || cadastroSenha.equals(this.senhaCadastrada) ){
            System.out.println("Esse usúario já existe.");
        }
        else {
            System.out.println("Cadastro realizado com sucesso!");
        }
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
