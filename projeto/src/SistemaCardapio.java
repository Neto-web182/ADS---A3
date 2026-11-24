package projeto.src;
import java.util.ArrayList;

public class SistemaCardapio {
    
    // var de referencias a objetos
     ArrayList <String> produto = new ArrayList<>();
     ArrayList <String> descricao = new ArrayList<>();
     ArrayList <Double> preco = new ArrayList<>();
    

    // {1} METÓDO para exibir o cardápio
    public void exibirCardapio (){
        // Se o tamanho da ArrayList for igual a zero:
        if (produto.size() == 0){
            System.out.println("O cardápio está vazio no momento.");
        }
        else{
            // For para percorrer a ArrayList
            for (int i = 0; i < produto.size(); i++){
                System.out.printf("[ "+i+" ] %s \n      Descrição: %s \n      Preço: R$%.2f \n", produto.get(i) , descricao.get(i) , preco.get(i));
                System.out.println("\n----------------------------------------------------------------");
            }
        }
    }
    

    // {2} METÓDO para adionar um novo produto
    public void adicionarProduto (String produto, String descricao, double preco){
        // add para adicionar meu novo produto na ArrayList
        this.produto.add (produto);
        this.descricao.add (descricao);
        this.preco.add (preco);
    }


    // {3} METÓDO para alterar produto
    public void alterarProduto (int posicao, String novoProduto, String novaDescricao, double novoPreco){

        // Condicional para verificar se a posição informada pelo usúario realmente existe no ArrayList.
        if (posicao >= 0 && posicao < this.produto.size() ){
            produto.set (posicao , novoProduto);
            descricao.set (posicao , novaDescricao);
            preco.set (posicao , novoPreco);

            System.out.println("\nProduto alterado com sucesso!");
        }
        else{
            System.out.print("\nPosição inválida!");
        }
    }


    // {4} METÓDO para remover produto
    public void removerProduto (int posicao){
        
        // Condicional para verificar se a posição informada pelo usúario realmente existe no ArrayList.
        if (posicao >= 0 && posicao < produto.size() ){
            produto.remove (posicao);
            descricao.remove (posicao);
            preco.remove (posicao);

            System.out.println("Produto removido com sucesso!");
        }         
        else{
            System.out.print("\nPosição inválida!");
        }
    }


    // {5} METÓDO para limpar o cardapio
    public void limparCardapio (){
        produto.clear();
        descricao.clear();
        preco.clear();
    }


    // {0} METÓDO para encerrar o menu 
    public boolean encerrarMenu (){
        return false ;
    }

}//Fim da classe SistemaCardapio