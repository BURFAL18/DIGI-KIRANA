package com.example.digikirana;
import java.util.List;

public class Homepagemodel {
    public static final int STRIP_AD_BANNER = 0;
    public static final int HORIZONTAL_PRODUCT_VIEW = 1;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    ///// STRIP LAYOUT//////////

    private int resource;
    private String backgroundcolor;
    //////// HORIZONTAL LAYOUT ///
    //  private String title;
    private List<Horizontalproductmodel> horizontalproductmodelList;

    public Homepagemodel(int type, int resource, String backgroundcolor) {
        this.type = type;
        this.resource = resource;
        this.backgroundcolor = backgroundcolor;
    }

    public Homepagemodel(int type, List<Horizontalproductmodel> horizontalproductmodelList) {
        this.type = type;
        // this.title = title;
        this.horizontalproductmodelList = horizontalproductmodelList;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    ///// STRIP LAYOUT//////////

    public String getBackgroundcolor() {
        return backgroundcolor;
    }

    public void setBackgroundcolor(String backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }

    //  public String getTitle() {
    //    return title;
    //  }
    //  public void setTitle(String title) {
    //     this.title = title;
    //  }
    public List<Horizontalproductmodel> getHorizontalproductmodelList() {
        return horizontalproductmodelList;
    }
    public void setHorizontalproductmodelList(List<Horizontalproductmodel> horizontalproductmodelList) {
        this.horizontalproductmodelList = horizontalproductmodelList;
    }
//////// HORIZONTAL LAYOUT ///

}