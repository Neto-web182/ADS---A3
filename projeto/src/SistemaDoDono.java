package projeto.src;
import java.util.ArrayList;

public class SistemaDoDono {
    
    private ArrayList <String> relatorioClientes = new ArrayList<>();
    private ArrayList <String> relatorioItemComprado = new ArrayList<>();
    private ArrayList <Double> relatorioPrecoItem = new ArrayList<>();

    // Atributos
    private double relatorioTaxaEntrega = 0;
    private double faturamentoPizzaria = 0 ;


    //Metódo para registrar o pedido após a confirmação da classe interfaceConsole
    public void registrarPedido ( String cliente, ArrayList<String> resumoPedido ,  ArrayList<Double> resumoPreco, double valorTotal, double taxaEntrega ){
        // for para percorrer toda a arrayList da classe atual
        for (int i = 0 ; i < resumoPedido.size(); i ++){
            relatorioClientes.add (cliente);
            relatorioItemComprado.add (resumoPedido. get(i));
            relatorioPrecoItem.add (resumoPreco. get(i));
        }
        faturamentoPizzaria += valorTotal ;
        relatorioTaxaEntrega += taxaEntrega ;
    }


    // Metódo para exibir o faturamento total da pizzaria
    public void exibirFaturamento (){
        System.out.printf("Faturamento do dia: R$%.2f\n", faturamentoPizzaria);
    }

    
    // Metódo para exibir o histórico da pizzaria
    public void exibirHistorico (){
        for (int i = 0; i < relatorioClientes.size(); i ++){
            System.out.println("\n[ "+ i +" ] Cliente: "+ relatorioClientes.get(i));
            System.out.printf("        Item: %s  Preço: R$%.2f \n", relatorioItemComprado.get(i) , relatorioPrecoItem.get(i));
            System.out.println("\n________________________________________________________________");
        }
        System.out.printf ("\nTotal taxa de entrega no dia: R$%.2f\n",relatorioTaxaEntrega);
    }


    // Metódo para modificar nome da pizzaria
    public String modificarNome(String novoNome){
        return novoNome ;
    }

}