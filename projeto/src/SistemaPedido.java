package projeto.src;

import java.util.ArrayList;

public class SistemaPedido {

    // Atributos
    ArrayList<String> resumoPedido = new ArrayList<>();
    ArrayList<String> resumoDescricao = new ArrayList<>();
    ArrayList<Double> resumoPreco = new ArrayList<>();

    // ATRIBUTOS                
    public double subTotal;
    public int quantidadeItens;
    public double taxaEntrega = 0;
    public String endereco;
    public double valorTotal = subTotal;

    public void adicionarProduto(int posicaoPedido, ArrayList<String> produto, ArrayList<String> descricao, ArrayList<Double> preco) {
        // if para verifiar se a posição informada existe no array
        if (posicaoPedido >= 0 && posicaoPedido < produto.size()) {

            resumoPedido.add(produto.get(posicaoPedido));
            resumoDescricao.add(descricao.get(posicaoPedido));
            resumoPreco.add(preco.get(posicaoPedido));

            subTotal += preco.get(posicaoPedido);
            quantidadeItens += 1;

            System.out.printf("\nPedido adicionado com sucesso!!\n");
        } else {
            System.out.print("\nPosição inválida!");
        }
    }

    public void calcularEntrega(String opcaoBairro, String endereco) {
        switch (opcaoBairro) {
            case "planalto":
                taxaEntrega = 10;
                valorTotal = +taxaEntrega;

                break;

            case "pitimbu":
                taxaEntrega = 15;
                valorTotal = +taxaEntrega;

                break;

            default:
                System.out.println("\nOpção inválida!");
                break;
        }
        this.endereco = endereco;
    }

    public void exibirResumoPedido() {
        for (int i = 0; i < resumoPedido.size(); i++) {
            System.out.printf("""
            Item: %s
            Descrição: %s
            Preço: %.2f \n             
            """, resumoPedido.get(i), resumoDescricao.get(i), resumoPreco.get(i));
        }
        System.out.print("Quantidade de itens: " + quantidadeItens);
        if (taxaEntrega > 0) {
            System.out.printf("Subtotal dos produtos: R$%.2f", subTotal);
            System.out.printf("Taxa de entrega: R$%.2f / endereço: %s", taxaEntrega, this.endereco);
        }

        System.out.printf("Total: R$%.2f\n", valorTotal);
    }

    public boolean confirmarPedido(String confirmacao, String cliente) {
        switch (confirmacao) {
            case "sim":
                System.out.println("Perfeito "+cliente);
                return true;

            case "não":
                System.out.println("");
                return false;
    }

            case "sim":
                System.out.printf("Precisa de troco? ");
                String respostaTroco = entrada.next().toLowerCase();

                switch (respostaTroco) {

                    case "sim":
                        System.out.print("\nTroco pra quanto?\nValor: R$");
                        double valor = entrada.nextInt();

                        if (valor > valorPedido) {
                            double troco = valor - valorPedido;
                            System.out.printf("\nOk, seu troco: R$%.2f \n%sSeu atendimento foi finalizado!!\nAgradecemos a sua prefêrencia.%s", troco, verde, limpaCor);
                            continuar = false;
                        } else if (valor == valorPedido) {
                            System.out.printf(cliente + " nesse caso não é necessário troco. %sSeu atendimento foi finalizado!!\nAgradecemos a sua prefêrencia.%s", verde, limpaCor);
                            continuar = false;
                        } else {
                            System.out.println("O valor informado é inferior ao valor do pedido.\nDigite o valor correto..");
                            System.out.print("\nTroco pra quanto?\nValor: R$");
                            valor = entrada.nextInt();

                            if (valor > valorPedido) {
                                double troco = valor - valorPedido;
                                System.out.printf("\nOk, seu troco: R$%.2f \n%sSeu atendimento foi finalizado!!\nAgradecemos a sua prefêrencia.%s", troco, verde, limpaCor);
                                continuar = false;
                            } else if (valor == valorPedido) {
                                System.out.printf(cliente + " nesse caso não é necessário troco. %sSeu atendimento foi finalizado!!\nAgradecemos a sua prefêrencia.%s", verde, limpaCor);
                                continuar = false;
                            } else {
                                System.out.println("\nValor informado inferior ao pedido!\nReiniciando o atendimento..");
                                continue;
                            }
                        }

                        break;

                    case "não":
                    case "nao":
                        System.out.println(verde + "\nOk.\nSeu pedido está finalizado!!\nAgradecemos a sua prefêrencia." + limpaCor);
                        continuar = false;
                        break;

                    //default para checar se a opção existe dentro do menu, se não existir o loop reinicia.
                    default:
                        System.out.println("\nOpção inválida. Por favor digite uma opção existente!!\nReiniciando o atendimento..\n\n\n");
                        continue;
                }

                break;

            case "não":
            case "nao":
                System.out.println("\nReiniciando o atendimento..\n\n\n");
                continue;

            //default para checar se a opção existe dentro do menu, se não existir o loop reinicia.
            default:
                System.out.println("\nOpção inválida. Por favor digite uma opção existente!!\nReiniciando o atendimento..\n\n\n");
                continue;

        }

    }
