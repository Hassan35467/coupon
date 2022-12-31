<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Create Coupon</h1>
<form action="coupon" method="post">
<table>

<tr>
<td>Coupon name:<input type="text" name="coupon_name"></td>
<td>Discount:<input type="text" name="discount"></td>
<td>Expiry Date:<input type="text" name="exp_date"></td>

<input type="hidden" name="action" value="create">

</tr>
</table>
<input type="submit" value="save">

</form>
</body>
</html>