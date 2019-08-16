package com.naruto.mekvahandelivery.customer_report;

import android.net.Uri;

class AddCustomerReportData {

    private String buttonId, btnstate;
    private Uri photoUri;

    AddCustomerReportData(String buttonId, Uri photoUri, String btnstate) {
        this.buttonId = buttonId;
        this.photoUri = photoUri;
        this.btnstate = btnstate;
    }

    public AddCustomerReportData() {
    }

    public String getButtonId() {
        return buttonId;
    }

    public Uri getPhotoUri() {
        return photoUri;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    void setPhotoUri(Uri photoUri) {
        this.photoUri = photoUri;
    }

    String getBtnstate() {
        return btnstate;
    }

    void setBtnstate(String btnstate) {
        this.btnstate = btnstate;
    }

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        AddCustomerReportData other = (AddCustomerReportData) obj;
//        if (!this.buttonId.equals(other.buttonId))
//            return false;
//        if (!this.btnstate.equals(other.btnstate))
//            return false;
//        if (!this.photoUri.equals(other.photoUri))
//            return false;
//        return true;
//    }
}
