package br.com.conversor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaExchangeRate {

    // API gratuita - sem necessidade de chave para consultas básicas
    // Alternativa com chave gratuita: https://www.exchangerate-api.com/
    private static final String BASE_URL = "https://api.exchangerate-api.com/v4/latest/";

    private final HttpClient httpClient;
    private final Gson gson;

    public ConsultaExchangeRate() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    /**
     * Obtém a taxa de câmbio entre duas moedas em tempo real.
     *
     * @param moedaOrigem  Código da moeda de origem (ex: "USD")
     * @param moedaDestino Código da moeda de destino (ex: "BRL")
     * @return Taxa de conversão
     * @throws IOException          Se houver erro de conexão
     * @throws InterruptedException Se a requisição for interrompida
     */
    public double obterTaxa(String moedaOrigem, String moedaDestino) throws IOException, InterruptedException {
        String url = BASE_URL + moedaOrigem;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Erro ao acessar a API. Código HTTP: " + response.statusCode());
        }

        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
        JsonObject rates = jsonObject.getAsJsonObject("rates");

        if (rates == null || !rates.has(moedaDestino)) {
            throw new IOException("Moeda de destino não encontrada: " + moedaDestino);
        }

        return rates.get(moedaDestino).getAsDouble();
    }
}
