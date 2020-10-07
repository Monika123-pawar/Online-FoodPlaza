package com.Foodplaza.pojo;

public class Food {
private int fid;
private String fname;
private double fprice;
private String fcategory;


public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public double getFprice() {
	return fprice;
}
public void setFprice(double fprice) {
	this.fprice = fprice;
}
public String getFcategory() {
	return fcategory;
}
public void setFcategory(String fcategory) {
	this.fcategory = fcategory;
}
@Override
public String toString() {
	return "Food [id=" + fid + ", fname=" + fname + ", fprice=" + fprice + ", fcategory=" + fcategory + "]";
}
public Food() {
	
}

}
