<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Page</title>
    </head>
    <body>
        <h1>Checkout Page</h1>
        <%String msg = (String) request.getAttribute("msg");%>
        <h3 style="color: red"> <%= msg != null ? msg : ""%></h3>

        <form action="TotalController" method="get">
            <label for="orderID">Order ID:</label>
            <input type="text" id="orderID" name="OID" required /><br>

            <label for="userID">User ID:</label>
            <input type="text" id="userID" name="UID" required /><br>


            <label for="date">Date</label>
            <input type="date" id="date" name="date" required placeholder="yyyy-MM-dd HH:mm:ss" /><br>

            <label for="paymentMethod">Payment Method:</label>
            <select name="paymentMethod">
                <option>Cash</option>
                <option>PayPal</option>
            </select><br>
            <label for="paymentStatus">Payment Status:</label>
            <select name="paymentStatus">
                <option>Pending</option>
                <option>Paid</option>
            </select><br>
            <input type="submit" value="Complete Payment" />
        </form>
        <a href="ShowItems" class="home-items-link">HOME ITEMS</a>
    </body>
</html>
