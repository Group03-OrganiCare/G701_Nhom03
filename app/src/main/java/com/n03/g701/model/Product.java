package com.n03.g701.model;

public class Product {
    private String ProductId;
    private String ProductName;
    private String ProductCompany;
    private double ProductPrice;
    private int ProductThumb;

    public Product(String productId, String productName, String productCompany, double productPrice, int productThumb) {
        ProductId = productId;
        ProductName = productName;
        ProductCompany = productCompany;
        ProductPrice = productPrice;
        ProductThumb = productThumb;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductCompany() {
        return ProductCompany;
    }

    public void setProductCompany(String productCompany) {
        ProductCompany = productCompany;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public int getProductThumb() {
        return ProductThumb;
    }

    public void setProductThumb(int productThumb) {
        ProductThumb = productThumb;
    }
}
