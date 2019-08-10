package com.naruto.mekvahandelivery.UpcomingOrders;

public class MyListDataUpcomingBooking {

    private String description;
    private String orderId;
    private String date,time;
    private String payment_status;
    private String service_name;
    private String logo;
    private String modelName;
    private String numberPlate;
    private String mobile;



    public MyListDataUpcomingBooking(String date,
                                     String time,
                                     String mobile,
                                     String modelName,
                                     String numberPlate,
                                     String orderId,
                                     String payment_status,
                                     String service_name) {
        this.description = description;

        this.date=date;
        this.time=time;
//        this.logo=logo;
        this.mobile=mobile;
        this.modelName=modelName;
        this.numberPlate=numberPlate;
        this.orderId=orderId;
        this.payment_status=payment_status;
        this.service_name=service_name;

        //  this.imgId = imgId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getDateAndTime() {
        return date;
    }

    public void setDateAndTime(String date) {
        this.date = date;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
//
//    public int getImgId() {
//        return imgId;
//    }
//
//    public void setImgId(int imgId) {
//        this.imgId = imgId;
//    }
}
