package com.naruto.mekvahandelivery.chauffeur_partner.NewBooking;

public class MyListDataNewBooking {
    private String description;
    private int imgId;

    public MyListDataNewBooking(String description) {
        this.description = description;
        //  this.imgId = imgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
