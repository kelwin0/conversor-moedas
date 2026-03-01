# 💱 Conversor de Moedas em Java

Projeto de conversão de moedas com menu interativo via console, utilizando Java 17+
e consumindo uma API externa de câmbio em tempo real.

A aplicação usa:
- Java HttpClient
- Gson (para conversão de JSON)
- ExchangeRate-API (sem necessidade de cadastro ou API KEY)

---

## 🚀 Como funciona

1. O usuário escolhe uma das **6 opções de conversão** no menu:

```
1. Dólar (USD)  → Real (BRL)
2. Real (BRL)   → Dólar (USD)
3. Euro (EUR)   → Real (BRL)
4. Real (BRL)   → Euro (EUR)
5. Dólar (USD)  → Euro (EUR)
6. Euro (EUR)   → Dólar (USD)
7. Sair
```

2. O usuário informa o valor a ser convertido.
3. O sistema consulta a API de câmbio em tempo real.
4. Calcula a conversão com a taxa atualizada.
5. Exibe o resultado no terminal.

---

## 🛠 Tecnologias utilizadas

- Java 17+
- Gson 2.10.1
- ExchangeRate-API (gratuita, sem API KEY)

---

## 📦 Dependência Maven

Adicione no `pom.xml`:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
```

---

## ▶️ Como executar

Compile e execute a classe principal:

```
Principal.java
```

Ou execute pelo Maven:

```
mvn clean package
java -jar target/conversor-moedas-1.0-SNAPSHOT-jar-with-dependencies.jar
```

---

## 📂 Estrutura do projeto

```
src/
 └── main/
      └── java/
           └── br/com/conversor/
                ├── Principal.java               ← menu e entrada do usuário
                ├── ConversorMoedas.java          ← lógica de conversão
                ├── ConsultaExchangeRate.java     ← consumo da API + parse JSON
                └── ResultadoConversao.java       ← record com o resultado
```

---

## 📌 Objetivo do projeto

Projeto feito para prática de:

- Consumo de API REST
- Manipulação de JSON com Gson
- Organização em camadas
- Interação via console (menu textual)
- Estrutura básica backend em Java

---

## ✍ Autor

Kelwin Zambarda
