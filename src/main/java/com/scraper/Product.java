package com.scraper;

public class Product {
    private String url;
    private String name;
    private double price;
    private String image;

    // Nossos getters, padr'ao. Permitem que acessem os obj sem alterar o estado.
    public String getUrl() {
        return url;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getImage() {
        return image;
    }
    // métodos que permitem a alteração dos valores dos atributos privados.
    // Eles garantem encapsulamento e controle ao modificar os atributos.
    public void setUrl(String url) {
        this.url = url;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "{ \"url\":\"" + url + "\", "
                + " \"image\": \"" + image + "\", "
                + "\"name\":\"" + name + "\", "
                + "\"price\": \"" + price + "\" }";
    }
}
