package com.model;

import java.math.BigDecimal;

public class Coupon {
private int id;
private String coupon_name;
private BigDecimal discount;
private String exp_date;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCoupon_name() {
	return coupon_name;
}
public void setCoupon_name(String coupon_name) {
	this.coupon_name = coupon_name;
}
public BigDecimal getDiscount() {
	return discount;
}
public void setDiscount(BigDecimal discount) {
	this.discount = discount;
}
public String getExp_date() {
	return exp_date;
}
public void setExp_date(String exp_date) {
	this.exp_date = exp_date;
}
@Override
public String toString() {
	return "Coupon [id=" + id + ", coupon_name=" + coupon_name + ", discount=" + discount + ", exp_date=" + exp_date
			+ "]";
}

}
