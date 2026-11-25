package projeto.src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeitorEntrada {

    // Tratamento de erro utilizando try catch e uma estrutura de repetição
    public int lerInteiro(Scanner entrada) {
        while (true) {
            try {
                return entrada.nextInt(); // Tenta ler um numero inteiro
            }

            catch (InputMismatchException e) {    // se vier texto, cai aqui
                System.out.print("Valor inválido! Digite apenas números inteiros: ");

                entrada.next();                     // joga fora o texto errado 
            }
        }
    }


    // Tratamento de erro utilizando try catch so que agora com double
    public double lerDouble(Scanner entrada) {
        while (true) {
            try {
                return entrada.nextDouble(); // Tenta ler um numero com vírgula
            }

            catch (InputMismatchException e) {    // se vier texto, cai aqui
                System.out.print("Valor inválido! Digite um número (ex: 10,50): ");

                entrada.next();                     // joga fora o texto errado
            }
        }
    }

}


