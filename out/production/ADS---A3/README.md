# ADS---A3
 /*  Metódo para impedir o cadastro de usúario ou senha que já existe
    public void cadastrar(String cadastroUsuario, String cadastroSenha){
        if ( cadastroUsuario.equals(this.usuarioCadastrado) || cadastroSenha.equals(this.senhaCadastrada) ){
            System.out.println("Esse usúario já existe.");
        }
        else {
            System.out.println("Cadastro realizado com sucesso!");
        }
    }*/
 // Construtor para receber os parametros usuario e senha
    public Autenticacao(String cadastroUsuario, String cadastroSenha) {
        usuarioCadastrado = cadastroUsuario;
        senhaCadastrada   = cadastroSenha;
    }