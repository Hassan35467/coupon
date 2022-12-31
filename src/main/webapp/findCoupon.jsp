<%@page import="com.model.Coupon"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Coupon</title>
</head>
<body>
<h1>find Coupon</h1>
<form action="coupon" method="post">

Coupon Code:<input type="text" name="couponCode"/>
<input type="hidden" name="action" value="find"/>
<input type="submit" value="Find"/>
</form>
<%-- <% 
Coupon cop =(Coupon)request.getAttribute("coupon");
if(cop!=null){
%>
<h1><%= cop.getCoupon_name() %></h1>
<h1><%= cop.getExp_date() %></h1>

<%} %> --%>
</body>
</html>