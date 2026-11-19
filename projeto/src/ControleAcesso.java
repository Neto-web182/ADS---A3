package projeto.src;

public class ControleAcesso {

    // Atributos para guardar os dados 
    public String usuarioGerente ;
    public String senhaGerente ;

    public String usuarioDono ;
    public String senhaDono ;

    public void cadastrarGerente(String cadastroUsuario, String cadastroSenha  ) {
        this.usuarioGerente = cadastroUsuario;
        this.senhaGerente = cadastroSenha;
    }

    // Método para para autenticar o login do GERENTE
    public boolean autenticarGerente(String usuario, String senha) {
        if ( usuario.equals (this.usuarioGerente) && senha.equals (this.senhaGerente) ) {
            return true;
        } 
        else {
            return false;
        }
    }

     // Método para para autenticar o login do DONO
    public boolean autenticarDono(String usuario, String senha) {
        if ( usuario.equals (this.usuarioDono) && senha.equals (this.senhaDono) ) {
            System.out.println("Acesso permitido! Bem-vindo "+ usuario +"!");
            return true;
        } 
        else {
            System.out.println("Erro: Usuário ou senha incorretos.");
            return false;
        }
    }

}
