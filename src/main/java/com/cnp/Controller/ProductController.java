package com.cnp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnpDao.CouponDao;
import com.cnpDao.CouponDaoImp;
import com.cnpDao.ProductDaoImpl;
import com.model.Coupon;
import com.model.Product;

@WebServlet("/products")
public class ProductController extends HttpServlet{
	
	CouponDaoImp cdao =new CouponDaoImp();
	ProductDaoImpl pdao =new ProductDaoImpl();
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	String desc = req.getParameter("description");
	String price = req.getParameter("price");
	String cop = req.getParameter("couponCode");
	Coupon coup = cdao.findByCode(cop);
	Product pd =new Product();
	pd.setCouponcode(cop);
	pd.setName(name);
	pd.setDescription(desc);
	pd.setPrice(new BigDecimal(price).subtract(coup.getDiscount()));
	pdao.save(pd);
	
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	
	out.print("<b>Product Created</b>");
	out.println(pd);
    out.print("<h1><b/><a href='/CouponProject'>Home</h1></a>");
	
}
}
