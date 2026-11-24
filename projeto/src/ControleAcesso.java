package projeto.src;

public class ControleAcesso {

    // Atributos para guardar os dados 
    public String usuarioGerente ;
    public String senhaGerente ;

    public String usuarioDono ;
    public String senhaDono ;


    // metódo que aplica as regras de cadastro e cadastra o gerente
    public void cadastrarGerente(String cadastroUsuario, String cadastroSenha  ) {
        if (usuarioGerente == null) {
            this.usuarioGerente = cadastroUsuario;
            this.senhaGerente   = cadastroSenha;
            System.out.println("\nCadastro do gerente realizado com sucesso!\n");
        }
        else{
            System.out.println("Acesso inválido! O gerente já está cadastrado.");
        }    
    }


    // metódo que aplica as regras de cadastro e cadastra o dono
    public void cadastrarDono(String cadastroUsuario, String cadastroSenha  ) {
        if (usuarioDono == null){
            this.usuarioDono = cadastroUsuario;
            this.senhaDono   = cadastroSenha;
            System.out.println("\nCadastro do dono realizado com sucesso!\n");
        }
        else{
            System.out.println("Acesso inválido! O dono já está cadastrado.");
        }
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
            return true;
        } 
        else {
            System.out.println("Erro: Usuário ou senha incorretos.");
            return false;
        }
    }

}