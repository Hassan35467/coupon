package com.cnpDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Product;
import com.util.ConnectionUtil;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void save(Product product) {
		Connection con = ConnectionUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into product_coupon(name,description,price) values(?,?,?)");
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setBigDecimal(3, product.getPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
