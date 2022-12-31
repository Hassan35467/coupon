package com.cnpDao;

import java.sql.Connection;

import com.model.Coupon;

public interface CouponDao {
public void save(Coupon coup);
public Coupon findByCode(String coupon_name);
}
