package com.Foodplaza.pojo;


public class FoodOrder {
	public FoodOrder()
	{
		
	}
private int orderid;
private Double totalbill;
private String cemail;
private String orderdate;
private String status;
@Override
public String toString() {
	return "FoodOrder [orderid=" + orderid + ", totalbill=" + totalbill + ", cemail=" + cemail + ", orderdate="
			+ orderdate + ", status=" + status + "]";
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public Double getTotalbill() {
	return totalbill;
}
public void setTotalbill(Double totalbill) {
	this.totalbill = totalbill;
}
public String getCemail() {
	return cemail;
}
public void setCemail(String cemail) {
	this.cemail = cemail;
}
public String getOrderdate() {
	return orderdate;
}
public void setOrderdate(String orderdate) {
	this.orderdate = orderdate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}



}
