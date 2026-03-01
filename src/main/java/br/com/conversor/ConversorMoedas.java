package br.com.conversor;

import java.io.IOException;

public class ConversorMoedas {

    private final ConsultaExchangeRate consultaAPI;

    // Pares de moedas para cada opção do menu
    private static final String[][] PARES_MOEDAS = {
            {"USD", "BRL"},  // Opção 1
            {"BRL", "USD"},  // Opção 2
            {"EUR", "BRL"},  // Opção 3
            {"BRL", "EUR"},  // Opção 4
            {"USD", "EUR"},  // Opção 5
            {"EUR", "USD"},  // Opção 6
    };

    public ConversorMoedas() {
        this.consultaAPI = new ConsultaExchangeRate();
    }

    public void converter(int opcao, double valor) {
        if (opcao < 1 || opcao > PARES_MOEDAS.length) {
            System.out.println("❌ Opção de conversão inválida.");
            return;
        }

        String moedaOrigem = PARES_MOEDAS[opcao - 1][0];
        String moedaDestino = PARES_MOEDAS[opcao - 1][1];

        System.out.println("\n⏳ Consultando taxa de câmbio em tempo real...");

        try {
            double taxa = consultaAPI.obterTaxa(moedaOrigem, moedaDestino);
            double valorConvertido = valor * taxa;

            ResultadoConversao resultado = new ResultadoConversao(
                    moedaOrigem,
                    moedaDestino,
                    valor,
                    valorConvertido,
                    taxa
            );

            System.out.println(resultado);

        } catch (IOException e) {
            System.out.println("❌ Erro de conexão: " + e.getMessage());
            System.out.println("   Verifique sua conexão com a internet e tente novamente.");
        } catch (InterruptedException e) {
            System.out.println("❌ Requisição interrompida. Tente novamente.");
            Thread.currentThread().interrupt();
        }
    }
}
