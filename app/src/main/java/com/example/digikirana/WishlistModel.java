package com.example.digikirana;

public class WishlistModel {
    private int xproductImage;
    private String xproductTitle;
    private String xproductPrice;

    public WishlistModel(int xproductImage, String xproductTitle, String xproductPrice) {
        this.xproductImage = xproductImage;
        this.xproductTitle = xproductTitle;
        this.xproductPrice = xproductPrice;
    }

    public int getXproductImage() {
        return xproductImage;
    }

    public void setXproductImage(int xproductImage) {
        this.xproductImage = xproductImage;
    }

    public String getXproductTitle() {
        return xproductTitle;
    }

    public void setXproductTitle(String xproductTitle) {
        this.xproductTitle = xproductTitle;
    }

    public String getXproductPrice() {
        return xproductPrice;
    }

    public void setXproductPrice(String xproductPrice) {
        this.xproductPrice = xproductPrice;
    }
}
