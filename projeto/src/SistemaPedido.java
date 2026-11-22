package projeto.src;

import java.util.ArrayList;

public class SistemaPedido {

    ArrayList<String> resumoPedido = new ArrayList<>();
    ArrayList<String> resumoDescricao = new ArrayList<>();
    ArrayList<Double> resumoPreco = new ArrayList<>();

    // ATRIBUTOS          
    public int quantidadeItens = 0;

    public double subTotal = 0;
    public double taxaEntrega = 0;
    public double valorTotal = 0;

    public String bairro ;
    public String endereco ;


    public void adicionarProduto(int posicaoPedido, ArrayList<String> produto, ArrayList<String> descricao, ArrayList<Double> preco) {
        // if para verifiar se a posição informada existe no array
        if (posicaoPedido >= 0 && posicaoPedido < produto.size()) {

            resumoPedido.add ( produto.get (posicaoPedido) );
            resumoDescricao.add ( descricao.get (posicaoPedido) );
            resumoPreco.add ( preco.get (posicaoPedido) );

            subTotal += preco.get ( posicaoPedido );
            valorTotal += preco. get ( posicaoPedido );
            quantidadeItens += 1;

            System.out.printf("\nPedido adicionado com sucesso!!\n");
        } else {
            System.out.print("\nPosição inválida!\n");
        }
    }


    public void calcularEntrega(String opcaoBairro, String endereco) {
        bairro = opcaoBairro;

        switch (opcaoBairro) {
            case "planalto":
                taxaEntrega = 10;
                valorTotal = subTotal + taxaEntrega;
                break;

            case "pitimbu":
                taxaEntrega = 15;
                valorTotal = subTotal + taxaEntrega;
                break;

            default:
                System.out.println("\nOpção inválida!");
                break;
        }
        this.endereco = endereco;
    }


    public void exibirResumoPedido() {
        // for para percorrer as três arrayList da classe atual
        for (int i = 0; i < resumoPedido.size(); i++) {
            System.out.printf("""
            Item: %s
            Descrição: %s
            Preço: %.2f\n              
            """, resumoPedido.get(i), resumoDescricao.get(i), resumoPreco.get(i));
        }
        System.out.print("Quantidade de itens: " + quantidadeItens);
        if (taxaEntrega > 0) {
            System.out.printf("\nSubtotal dos produtos: R$%.2f", subTotal);
            System.out.printf("\nTaxa de entrega: R$%.2f / Bairro: %s / Endereço: %s", taxaEntrega, bairro , endereco);
        }
        System.out.printf("\nTotal: R$%.2f \n", valorTotal);
        System.out.println("_________________________________________________________");
    }


    public boolean confirmarPedido(String confirmacao) {
        switch (confirmacao) {
            case "sim":
                return true;

            case "não":
            case "nao":
                return false;

            default:
                return false; 
        }
    }


    public boolean caulcularTroco (double valor, String nomeCliente){
        if (valor > valorTotal) {
            double troco = valor - valorTotal;
            System.out.printf("\nOk, seu troco: R$%.2f ", troco );
            return true;
        } 

        else if (valor == this.valorTotal ) {
            System.out.printf(nomeCliente + " nesse caso não é necessário troco." );
            return true;
        } 

        else {
            return false;
        }          
    }      

    // Metódo usado para limpar o pedido pós o atendimento finalizado
    public void limparPedido (){
        // Limpando as arrayList
        resumoPedido.clear();
        resumoDescricao.clear();
        resumoPreco.clear();
        
        // Limpando os atributos
        quantidadeItens = 0;
        subTotal = 0;
        taxaEntrega = 0;
        valorTotal = 0;
        bairro = null;
        endereco = null;
    }


}



