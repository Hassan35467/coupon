package com.cnpDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Coupon;
import com.util.ConnectionUtil;

public class CouponDaoImp implements CouponDao {

	@Override
	public void save(Coupon coup) {
		Connection con = ConnectionUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into coupon(coupon_name,discount,exp_date) values(?,?,?)");
			//ps.setInt(1, coup.getId());
			ps.setString(1, coup.getCoupon_name());
			ps.setBigDecimal(2, coup.getDiscount());
			ps.setString(3, coup.getExp_date());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Coupon findByCode(String coupon_name) {
		Coupon cop =new Coupon();
		Connection con = ConnectionUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from coupon where coupon_name=?");
			ps.setString(1, coupon_name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cop.setId(rs.getInt(1));
				cop.setCoupon_name(rs.getString(2));
				cop.setDiscount(rs.getBigDecimal(3));
				cop.setExp_date(rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cop;
		
	}

}
