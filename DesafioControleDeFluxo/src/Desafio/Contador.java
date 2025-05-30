package Desafio;

import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler entrada do teclado
        Scanner terminal = new Scanner(System.in);
        
        // Solicita e lê o primeiro parâmetro
        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt(); // Lê um número inteiro do usuário
        
        // Solicita e lê o segundo parâmetro
        System.out.println("Digite o segundo parâmetro");
        int parametroDois = terminal.nextInt(); // Lê outro número inteiro
        
        try {
            // Chama o método contar que pode lançar uma exceção
            contar(parametroUm, parametroDois);
        
        } catch (ParametrosInvalidosException exception) {
            // Captura a exceção caso o segundo parâmetro seja menor que o primeiro
            System.out.println(exception.getMessage()); // Imprime a mensagem de erro
        } finally {
            // Fecha o Scanner para liberar recursos
            terminal.close();
        }
    }
    
    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Verifica se o primeiro parâmetro é maior que o segundo
        if (parametroUm > parametroDois) {
            // Se for, lança a exceção personalizada com a mensagem de erro
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }
        
        // Calcula quantos números serão impressos (diferença entre os parâmetros)
        int contagem = parametroDois - parametroUm;
        
        // Loop para imprimir os números de 1 até o valor da contagem
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}

// Classe da exceção personalizada
class ParametrosInvalidosException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Construtor que recebe a mensagem de erro
    public ParametrosInvalidosException(String mensagem) {
        super(mensagem); // Passa a mensagem para a classe pai (Exception)
    }
}