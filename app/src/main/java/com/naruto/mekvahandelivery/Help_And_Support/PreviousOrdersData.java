package com.naruto.mekvahandelivery.Help_And_Support;

public class PreviousOrdersData {

    public PreviousOrdersData(String carName, String numberPlate, String reason, String progress, int carlogo, int reasonImg) {
        this.carName = carName;
        this.numberPlate = numberPlate;
        this.reason = reason;
        this.progress = progress;
        this.carlogo = carlogo;
        this.reasonImg = reasonImg;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public int getCarlogo() {
        return carlogo;
    }

    public void setCarlogo(int carlogo) {
        this.carlogo = carlogo;
    }

    public int getReasonImg() {
        return reasonImg;
    }

    public void setReasonImg(int reasonImg) {
        this.reasonImg = reasonImg;
    }

    private String carName,numberPlate,reason,progress;
    private int carlogo,reasonImg;
}
