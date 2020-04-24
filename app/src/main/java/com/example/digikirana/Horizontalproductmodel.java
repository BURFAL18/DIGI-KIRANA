package com.example.digikirana;

public class Horizontalproductmodel {
    private int productimage;
    private String producttitle;
    private String productdescription;
    private String productprice;


    public Horizontalproductmodel(int productimage, String producttitle, String productdescription, String productprice) {
        this.productimage = productimage;
        this.producttitle = producttitle;
        this.productdescription = productdescription;
        this.productprice = productprice;
    }

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }
}
