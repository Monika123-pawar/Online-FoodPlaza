package com.Foodplaza.pojo;

public class Cart {
public Cart()
{
	
}
private int cartid;
private int fid;
private String fname;
private Double fprice;
private int qty;
private String cemail;
@Override
public String toString() {
	return "Cart [cartid=" + cartid + ", fname=" + fname + ", fprice=" + fprice + ", qty=" + qty
			+ "]";
}
public int getCartid() {
	return cartid;
}
public void setCartid(int cartid) {
	this.cartid = cartid;
}
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
public Double getFprice() {
	return fprice;
}
public void setFprice(Double fprice) {
	this.fprice = fprice;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public String getCemail() {
	return cemail;
}
public void setCemail(String cemail) {
	this.cemail = cemail;
}

}
