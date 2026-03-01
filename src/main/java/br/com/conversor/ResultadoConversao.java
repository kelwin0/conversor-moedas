package br.com.conversor;

public record ResultadoConversao(
        String moedaOrigem,
        String moedaDestino,
        double valorOriginal,
        double valorConvertido,
        double taxaUtilizada
) {
    @Override
    public String toString() {
        return String.format(
                "\n✅ Conversão realizada com sucesso!\n" +
                "   %.2f %s = %.2f %s\n" +
                "   (Taxa utilizada: 1 %s = %.4f %s)",
                valorOriginal, moedaOrigem,
                valorConvertido, moedaDestino,
                moedaOrigem, taxaUtilizada, moedaDestino
        );
    }
}
