package com.cnp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnpDao.CouponDaoImp;
import com.model.Coupon;

@WebServlet("/coupon")
public class CouponController extends HttpServlet {
	private CouponDaoImp dao =new CouponDaoImp();

	public CouponController() {
		super();
	}
	
	private void findCoupon(HttpServletRequest req,HttpServletResponse res) {
		String code = req.getParameter("coupon_name");
		Coupon cop=dao.findByCode(code);
		req.setAttribute("coupon", code);
		
		try {
			req.getRequestDispatcher("findCoupon.jsp").forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ac = req.getParameter("action");
		if(ac.equals("create")) {
			createCoupon(req, resp);
			//createCoupon(req, resp);		
		}
        else if (ac.equals("find")) {
        	String code = req.getParameter("couponCode");
    		Coupon cop=dao.findByCode(code);

			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.print(cop);
		}

	}
	
	private void createCoupon(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		String couponname = req.getParameter("coupon_name");
		String discount = req.getParameter("discount");
		String expdate = req.getParameter("exp_date");
		Coupon coup =new Coupon();
		
		coup.setCoupon_name(couponname);
		
		coup.setDiscount(new BigDecimal(discount));
		coup.setExp_date(expdate);
		dao.save(coup);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<b>Coupon Created!!<b>");
		out.print("<b/><a href='/CouponProject'>Home</a>");
		
		out.print("<h1>Coupon added successful</h1>");
		
	}
	

}
