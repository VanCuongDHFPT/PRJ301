<%-- 
    Document   : fill
    Created on : Mar 13, 2025, 11:31:17 AM
    Author     : vovan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingredient Page</title>
    </head>
    
    <body>
        <a href="ShowItems" class="home-items-link">HOME ITEMS</a>
        <form action="MainController">
            Ingredient ID: <input type="text" name="IngredientID" value="" /><br>
            Order ID:<input type="text" name="OrderID" value="" /><br>
            Note : <input type="text" name="Note" value="" /><br>
            <input type="submit" name="btAction" value="OK"/>
            
            <c:if test="${requestScope.msg != null}">
                <h3 style="color: blue">${requestScope.msg}</h3>
            </c:if>
        </form>
    </body>
</html>
