package projeto.src;

public class ControleAcesso {

    // Atributos para guardar os dados 
    private String usuarioGerente ;
    private String senhaGerente ;

    private String usuarioDono ;
    private String senhaDono ;

    public boolean gerenteCadastrado() {
        return usuarioGerente != null;
    }

    public boolean donoCadastrado() {
        return usuarioDono != null;
    }


    // metódo que aplica as regras de cadastro e cadastra o gerente
    public void cadastrarGerente(String cadastroGerente, String cadastroSenha  ) {
        if (usuarioGerente == null) {
            this.usuarioGerente = cadastroGerente;
            this.senhaGerente   = cadastroSenha;
            System.out.println("\nCadastro do gerente realizado com sucesso!\n");
        }
        else{
            System.out.println("Acesso inválido! O gerente já está cadastrado.");
        }    
    }


    // metódo que aplica as regras de cadastro e cadastra o dono
    public void cadastrarDono(String cadastroDono, String cadastroSenha  ) {
        if (usuarioDono == null){
            this.usuarioDono = cadastroDono;
            this.senhaDono   = cadastroSenha;
            System.out.println("\nCadastro do dono realizado com sucesso!\n");
        }
        else{
            System.out.println("Acesso inválido! O dono já está cadastrado.");
        }
    }


    // Método para para autenticar o login do GERENTE
    public boolean autenticarGerente(String usuarioGerente, String senhaGerente) {
        if ( usuarioGerente.equals (this.usuarioGerente) && senhaGerente.equals (this.senhaGerente) ) {
            return true;
        } 
        else {
            return false;
        }
    }


     // Método para para autenticar o login do DONO
    public boolean autenticarDono(String usuarioDono, String senhaDono) {
        if ( usuarioDono.equals (this.usuarioDono) && senhaDono.equals (this.senhaDono) ) {
            return true;
        } 
        else {
            System.out.println("Erro: Usuário ou senha incorretos.");
            return false;
        }
    }


    public String getUsuarioGerente(){
        return this.usuarioGerente ;
    }

    public String getSenhaGerente(){
        return this.senhaGerente;
    }

}
