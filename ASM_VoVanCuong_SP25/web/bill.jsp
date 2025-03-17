<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Model.Orders"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>

    </head>
    <body>
        <a href="ShowItems" class="home-items-link">HOME ITEMS</a>
        <h1>Order Details</h1>
        <c:if test="${not empty data}">
            <table border = 1>
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>User ID</th>
                        <th>Order Date</th>
                        <th>Payment Method</th>
                        <th>Payment Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="orders" items="${requestScope.data}">
                        <tr>
                            <td>${orders.orderID}</td>
                            <td>${orders.userID}</td>
                            <td>${orders.date}</td>
                            <td>${orders.paymentMethod}</td>
                            <td>${orders.paymentStatus}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty data}">
            <p>No order found.</p>
        </c:if>

    </body>
</html>
