<%@page import="java.util.Map"%>
<%@page import="Model.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
    </head>
    <body>
        <h1>To Cart includes:</h1>
        <%
            if (session != null) {
                CartObj cart = (CartObj) session.getAttribute("cart");
                if (cart != null) {
                    if (cart.getItems() != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Delete</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
            <form action="CartController">
                <%
                    Map<String, Integer> items = cart.getItems();
                    int count = 1;
                    double totalCartPrice = 0;
                    for (Map.Entry item : items.entrySet()) {
                        String itemsName = (String) item.getKey();
                        int quantity = (int) item.getValue();
                        double price = cart.getItemPrice(itemsName);                  
                        double totalPriceForItem = price * quantity;
                        totalCartPrice += totalPriceForItem;
                %>
                <tr>
                    <td>
                        <%=count++%>
                    </td>
                    <td>
                        <%=item.getKey()%>
                    </td>
                    <td>
                        <%=item.getValue()%> 
                    </td>

                    <td>
                        <input type="checkbox" name="ckItem" value="<%=item.getKey()%>" />
                    </td>

                    <td><%=totalPriceForItem%></td>
                </tr>
                <%
                    }
                %>

                <tr>
                    <td colspan="3">
                        <a href="ShowItems">Add more Items</a>
                    </td>
                    <td>
                        <input type="submit" value="Remove Cart" name="btAction" />
                    </td>
                    <td>
                        <input type="submit" value="Add order details" name="btAction" />
                    </td>
                </tr>

                <td colspan="4" style="text-align:right;">Total Cart Price:</td>
                <td><%= totalCartPrice%></td>

            </form>
        </tbody>
    </table>

    <%
    } else {

    %>
    <h2> Cart Empty</h2>

    <%         }
            }
        }
    %>

</body>
</html>