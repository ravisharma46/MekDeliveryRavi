package com.naruto.mekvahandelivery.UpcomingOrders;

public class MyListDataUpcomingBooking {
    private String description;
    private int imgId;

    public MyListDataUpcomingBooking(String description) {
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
