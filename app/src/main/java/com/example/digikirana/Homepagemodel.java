package com.example.digikirana;

import java.util.List;

public class Homepagemodel {
    public static final int HORIZONTAL_PRODUCT_VIEW = 0;
    private int type;
    private String title;
    private List<Horizontalproductmodel> horizontalproductmodelList;

    ///horizontal layout

    // constructor
    public Homepagemodel(int type, String title, List<Horizontalproductmodel> horizontalproductmodelList) {
        this.type = type;
        this.title = title;
        this.horizontalproductmodelList = horizontalproductmodelList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    // getter setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Horizontalproductmodel> getHorizontalproductmodelList() {
        return horizontalproductmodelList;
    }

    public void setHorizontalproductmodelList(List<Horizontalproductmodel> horizontalproductmodelList) {
        this.horizontalproductmodelList = horizontalproductmodelList;
    }
///
}