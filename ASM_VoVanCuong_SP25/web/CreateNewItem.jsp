<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Items Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }

            h1 {
                text-align: center;
                color: #333;
            }

            form {
                background-color: #fff;
                padding: 20px;
                margin: 20px auto;
                border-radius: 8px;
                width: 300px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            label {
                font-weight: bold;
                margin-bottom: 8px;
                display: inline-block;
            }

            input[type="text"] {
                width: 100%;
                padding: 10px;
                margin: 8px 0 15px 0;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 15px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
                font-size: 16px;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            .form-container {
                width: 70%;
                margin: 0 auto;
            }

            .form-section {
                margin-bottom: 40px;
            }
        </style>
    </head>
    <body>
        <div class="form-container">
            <div class="form-section">
                <h1>Create New Item</h1>
                <form action="InsertItemController" method="post">
                    <label for="itemsID">Item ID:</label>
                    <input type="text" id="itemsID" name="itemsID"><br>

                    <label for="itemsName">Item Name:</label>
                    <input type="text" id="itemsName" name="itemsName"><br>

                    <label for="price">Price:</label>
                    <input type="text" id="price" name="price"><br>

                    <label for="quantity">Quantity:</label>
                    <input type="text" id="quantity" name="quantity"><br>

                    <label for="categoryID">Category ID:</label>
                    <input type="text" id="categoryID" name="categoryID"><br>

                    <label for="itemsImagePath">Image Path:</label>
                    <input type="text" id="itemsImagePath" name="itemsImagePath"><br>

                    <input type="submit" value="Insert Item">
                </form>
            </div>

            <div class="form-section">
                <h1>Create New Category</h1>

                <form action="InsertCategoryController" method="post">
                    <label for="itemsID">Category ID:</label>
                    <input type="text" id="categoryID" name="categoryID"><br>

                    <label for="itemsName">Category Name:</label>
                    <input type="text" id="Categoryname" name="Categoryname"><br>
                    <input type="submit" value="Insert Category">

                    <%String msg = (String) request.getAttribute("Msg");%>
                    <h2 style="color: aqua"><%=msg != null ? msg : ""%></h2>
                </form>
            </div>
        </div>
    </body>
</html>
