package com.minhhieu.testsqlite.model;

public class Student {
    private int mID;
    private String mName;
    private String mAddress;
    private String mPhone;
    private String mEmail;

    public Student() {
    }

    // contructor để ghi dữ liệu vào, ID tự tăng
    public Student(String mName, String mAddress, String mPhone, String mEmail) {
        this.mName = mName;
        this.mAddress = mAddress;
        this.mPhone = mPhone;
        this.mEmail = mEmail;
    }
    // contructor xuất dữ liệu lấy giá trị ID
    public Student(int mID, String mName, String mAddress, String mPhone, String mEmail) {
        this.mID = mID;
        this.mName = mName;
        this.mAddress = mAddress;
        this.mPhone = mPhone;
        this.mEmail = mEmail;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
