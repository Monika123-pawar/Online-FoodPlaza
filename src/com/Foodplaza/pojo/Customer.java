package com.Foodplaza.pojo;

public class Customer {
	public Customer()
	{
		
	}
private int cid;
private String cname;
private String caddress;
private String ccontact;
private String cemail;
private String cpassword;

public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCaddress() {
	return caddress;
}
public void setCaddress(String caddress) {
	this.caddress = caddress;
}
public String getCcontact() {
	return ccontact;
}
public void setCcontact(String ccontact) {
	this.ccontact = ccontact;
}
public String getCemail() {
	return cemail;
}
public void setCemail(String cemail) {
	this.cemail = cemail;
}
public String getCpassword() {
	return cpassword;
}
public void setCpassword(String cpassword) {
	this.cpassword = cpassword;
}
@Override
public String toString() {
	return "Customer [cid=" + cid + ", cname=" + cname + ", caddress=" + caddress + ", ccontact=" + ccontact
			+ ", cemail=" + cemail + ", cpassword=" + cpassword + "]";
}


}
