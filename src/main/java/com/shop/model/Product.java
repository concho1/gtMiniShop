package com.shop.model;

public class Product {
    private int pnum;
    private String pname;
    private String pcategoryFk;
    private String pcompany;
    private String pimage;
    private int pqty;
    private double price;
    private String pspec;
    private String pcontents;
    private int point;
    private String pinputDate;

    // 기본 생성자
    public Product() {
    }

    // 매개변수가 있는 생성자
    public Product(String pname, String pcategoryFk, String pcompany, String pimage, int pqty, double price, String pspec, String pcontents, int point) {
        this.pname = pname;
        this.pcategoryFk = pcategoryFk;
        this.pcompany = pcompany;
        this.pimage = pimage;
        this.pqty = pqty;
        this.price = price;
        this.pspec = pspec;
        this.pcontents = pcontents;
        this.point = point;
    }
 public Product(int pnum, String pname, String pcategoryFk, String pcompany, String pimage, int pqty, double price, String pspec, String pcontents, int point, String pinputDate) {
        this.pnum =pnum;
        this.pname = pname;
        this.pcategoryFk = pcategoryFk;
        this.pcompany = pcompany;
        this.pimage = pimage;
        this.pqty = pqty;
        this.price = price;
        this.pspec = pspec;
        this.pcontents = pcontents;
        this.point = point;
        this.pinputDate = pinputDate;
    }
 	public int getPnum() {
		return pnum;
	}
 	public void setPnum(int pnum) {
		this.pnum =pnum;
	}
    public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcategoryFk() {
		return pcategoryFk;
	}

	public void setPcategoryFk(String pcategoryFk) {
		this.pcategoryFk = pcategoryFk;
	}

	public String getPcompany() {
		return pcompany;
	}

	public void setPcompany(String pcompany) {
		this.pcompany = pcompany;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPspec() {
		return pspec;
	}

	public void setPspec(String pspec) {
		this.pspec = pspec;
	}

	public String getPcontents() {
		return pcontents;
	}

	public void setPcontents(String pcontents) {
		this.pcontents = pcontents;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getPinputDate() {
		return pinputDate;
	}

	public void setPinputDate(String pinputDate) {
		this.pinputDate = pinputDate;
	}
    
}
