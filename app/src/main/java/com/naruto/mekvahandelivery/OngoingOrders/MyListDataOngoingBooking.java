package com.naruto.mekvahandelivery.OngoingOrders;


public class MyListDataOngoingBooking {
    private String status;
    private String orderId;
    private String date,time;
    private String payment_status;
    private String service_name;
    private String logo;
    private String modelName;
    private String numberPlate;
    private String mobile;
    private String image_url,otp,name,address,latitude,longitude,drop_date,drop_time,amount;




    public MyListDataOngoingBooking( String status,
                                     String date,
                                     String time,
                                     String logo,
                                     String mobile,
                                     String modelName,
                                     String numberPlate,
                                     String orderId,
                                     String payment_status,
                                     String service_name,
                                     String image_url,String otp,String name,String address,String latitude,String longitude,String drop_date,String drop_time,String amount
                                    ) {
        this.status = status;
        this.date=date;
        this.time=time;
        this.logo=logo;
        this.mobile=mobile;
        this.modelName=modelName;
        this.numberPlate=numberPlate;
        this.orderId=orderId;
        this.payment_status=payment_status;
        this.service_name=service_name;
        this.image_url = image_url;
        this.otp = otp;
        this.name = name;
        this.address= address;
        this.latitude= latitude;
        this.longitude= longitude;
        this.drop_date= drop_date;
        this.drop_time= drop_time;
        this.amount= amount;

    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDrop_time(String drop_time) {
        this.drop_time = drop_time;
    }

    public void setDrop_date(String drop_date) {
        this.drop_date = drop_date;
    }

    public String getDrop_time() {
        return drop_time;
    }

    public String getDrop_date() {
        return drop_date;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}