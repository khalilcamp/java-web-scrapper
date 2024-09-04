package com.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scrapper {

    // Construtor da classe Scrapper
    public Scrapper(String url) {
        // Variável para armazenar o documento HTML
        Document doc;
        try {
            // Fetching website
            doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36")
                    .header("Accept-Language", "*")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao conectar ao website: " + e.getMessage(), e);
        }

        // Init prod list
        List<Product> products = new ArrayList<>();

        // Select elements
        Elements productElements = doc.select("li.product");


        for (Element productElement : productElements) {
            Product product = new Product();

            // Extraindo os dados de interesse
            product.setUrl(productElement.selectFirst("a").attr("href"));
            product.setImage(productElement.selectFirst("img").attr("src"));
            product.setName(productElement.selectFirst("h2").text());
            String priceText = productElement.selectFirst("span").text().replaceAll("[^\\d.]", "");

            try {
                product.setPrice(Double.parseDouble(priceText)); // Convertendo o texto para double
            } catch (NumberFormatException e) {
                product.setPrice(0.0); //
            }

            // Adicionando o produto à lista
            products.add(product);
        }


        products.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a URL do site de e-commerce: ");
        String url = scanner.nextLine();
        new Scrapper(url);
        scanner.close();
    }
}
