package com.shop.model;
//shop_category
public class Category {
    private int categoryNum;
    private String categoryCode;
    private String categoryName;

    // 기본 생성자
    public Category() {
    }
    // 매개변수가 있는 생성자
    public Category(String categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    // 매개변수가 있는 생성자
    public Category(int categoryNum, String categoryCode, String categoryName) {
        this.categoryNum = categoryNum;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    // Getter와 Setter 메소드
    public int getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(int categoryNum) {
        this.categoryNum = categoryNum;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

