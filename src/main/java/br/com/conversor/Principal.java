package br.com.conversor;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoedas conversor = new ConversorMoedas();
        int opcao = 0;

        System.out.println("===========================================");
        System.out.println("   Bem-vindo ao Conversor de Moedas 💱     ");
        System.out.println("===========================================");

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Opção inválida. Digite um número.\n");
                continue;
            }

            if (opcao == 7) {
                System.out.println("\nObrigado por usar o Conversor de Moedas! Até logo 👋");
                break;
            }

            if (opcao < 1 || opcao > 6) {
                System.out.println("❌ Opção inválida. Escolha entre 1 e 7.\n");
                continue;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor;
            try {
                valor = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
                if (valor <= 0) {
                    System.out.println("❌ O valor deve ser maior que zero.\n");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Valor inválido. Digite um número válido.\n");
                continue;
            }

            conversor.converter(opcao, valor);

        } while (opcao != 7);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n-------------------------------------------");
        System.out.println("         MENU DE CONVERSÕES                ");
        System.out.println("-------------------------------------------");
        System.out.println("  1. Dólar (USD)        → Real (BRL)       ");
        System.out.println("  2. Real (BRL)         → Dólar (USD)      ");
        System.out.println("  3. Euro (EUR)         → Real (BRL)       ");
        System.out.println("  4. Real (BRL)         → Euro (EUR)       ");
        System.out.println("  5. Dólar (USD)        → Euro (EUR)       ");
        System.out.println("  6. Euro (EUR)         → Dólar (USD)      ");
        System.out.println("  7. Sair                                   ");
        System.out.println("-------------------------------------------");
    }
}
