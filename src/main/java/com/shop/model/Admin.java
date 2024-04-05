package com.shop.model;

import java.util.Date;

// shop_admin
public class Admin {
    private String adminId;
    private String adminPwd;
    private String adminName;
    private String adminEmail;
    private String adminPhone;
    private Date adminDate;

    // 기본 생성자
    public Admin() {
    }

    // 매개변수가 있는 생성자
    public Admin(String adminId, String adminPwd, String adminName, String adminEmail, String adminPhone, Date adminDate) {
        this.adminId = adminId;
        this.adminPwd = adminPwd;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPhone = adminPhone;
        this.adminDate = adminDate;
    }

    // Getter와 Setter 메소드
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public Date getAdminDate() {
        return adminDate;
    }

    public void setAdminDate(Date adminDate) {
        this.adminDate = adminDate;
    }
}

