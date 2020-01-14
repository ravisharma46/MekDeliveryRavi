package com.naruto.mekvahandelivery.upcoming_orders;

public class MyListDataUpcomingBooking {

    private String status;
    private String orderId;
    private String date,time;
    private String payment_status;
    private String service_name;
    private String logo;
    private String modelName;
    private String numberPlate;
    private String mobile;
    private String image_url,otp,name,address,latitude,longitude,drop_date,drop_time,amount,service_type,vehicleBrand;
    private String action1;
    private String action2;
    private String action3;
    private String action4;
    private String action5;
    private String action6;
    private String action7;
    private String action8;
    private String action9;
    private String action10;
    private String action11;
    private String action12;
    private String action13;
    private String action14;
    private String action15;
    private int status_id;
    private String vehicle_type;
    private String my_amount;


    public MyListDataUpcomingBooking(String status,
                                     String date,
                                     String time,
                                     String logo,
                                     String mobile,
                                     String modelName,
                                     String numberPlate,
                                     String orderId,
                                     String payment_status,
                                     String service_name,
                                     String image_url,String otp,String name,String address,String latitude,
                                     String longitude,String drop_date,String drop_time,String amount,String  vehicleBrand,String service_type,String action1, String action2, String action3,
                                     String action4, String action5, String action6, String action7, String action8, String action9,
                                     String action10, String action11, String action12, String action13, String action14, String action15,int status_id,String vehicle_type,String my_amount) {
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
        this.vehicleBrand=vehicleBrand;
        this.service_type=service_type;
        this.action1 = action1;
        this.action2 = action2;
        this.action3 = action3;
        this.action4 = action4;
        this.action5 = action5;
        this.action6 = action6;
        this.action7 = action7;
        this.action8 = action8;
        this.action9 = action9;
        this.action10 = action10;
        this.action11 = action11;
        this.action12 = action12;
        this.action13 = action13;
        this.action14 = action14;
        this.action15 = action15;
        this.status_id=status_id;
        this.vehicle_type=vehicle_type;
        this.my_amount=my_amount;

    }

    public String getMy_amount() {
        return my_amount;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public int getStatus_id() {
        return status_id;
    }

    public String getAction1() {
        return action1;
    }

    public String getAction2() {
        return action2;
    }

    public String getAction3() {
        return action3;
    }

    public String getAction4() {
        return action4;
    }

    public String getAction5() {
        return action5;
    }

    public String getAction6() {
        return action6;
    }

    public String getAction7() {
        return action7;
    }

    public String getAction8() {
        return action8;
    }

    public String getAction9() {
        return action9;
    }

    public String getAction10() {
        return action10;
    }

    public String getAction11() {
        return action11;
    }

    public String getAction12() {
        return action12;
    }

    public String getAction13() {
        return action13;
    }

    public String getAction14() {
        return action14;
    }

    public String getAction15() {
        return action15;
    }

    public String getStatus() {
        return status;
    }

    public String getService_type() {
        return service_type;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDrop_date() {
        return drop_date;
    }

    public void setDrop_date(String drop_date) {
        this.drop_date = drop_date;
    }

    public String getDrop_time() {
        return drop_time;
    }

    public void setDrop_time(String drop_time) {
        this.drop_time = drop_time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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
