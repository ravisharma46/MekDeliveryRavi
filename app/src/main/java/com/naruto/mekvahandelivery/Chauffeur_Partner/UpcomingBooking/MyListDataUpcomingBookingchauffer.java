package com.naruto.mekvahandelivery.chauffeur_partner.UpcomingBooking;

public class MyListDataUpcomingBookingchauffer {

    private String description;
    private int imgId;

    public MyListDataUpcomingBookingchauffer(String description) {
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
