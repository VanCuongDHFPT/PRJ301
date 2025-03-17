<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hugo Coffee House</title>
        <style>

            /* Reset default styles */
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: Arial, sans-serif;
                line-height: 1.6;
                background-color: #f5f5f5;
            }

            /* Header Styles */
            .page-title {
                text-align: center;
                padding: 20px;
                color: #2c3e50;
                font-size: 2.5em;
            }

            /* Top Bar */
            .top-bar {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 15px 20px;
                background-color: #fff;
                border-bottom: 1px solid #eee;
                flex-wrap: nowrap; /* Đảm bảo không xuống dòng */
            }

            .top-bar form {
                display: flex;
                align-items: center;
                gap: 10px;
                margin-right: 20px; /* Khoảng cách giữa các form */
            }

            .header-actions {
                display: flex;
                align-items: center;
                gap: 15px;
                white-space: nowrap; /* Ngăn text xuống dòng */
            }

            .auth-links a {
                margin: 0 10px;
                text-decoration: none;
                color: #3498db;
                font-weight: bold;
            }

            .auth-links a:hover {
                color: #2980b9;
            }

            /* Form Styles */
            input[type="text"], 
            select {
                padding: 8px;
                border: 1px solid #ddd;
                border-radius: 4px;
                width: auto; /* Đảm bảo không bị co giãn quá mức */
            }

            input[type="submit"] {
                padding: 8px 15px;
                background-color: #3498db;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            input[type="submit"]:hover {
                background-color: #2980b9;
            }

            /* Admin Panel */
            .admin-container {
                display: flex;
                justify-content: space-between;
                padding: 20px;
                max-width: 1200px;
                margin: 0 auto;
            }

            .admin-panel, .items {
                background-color: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0,0,0,0.1);
                width: 48%;
            }

            .admin-panel h3, .items h3 {
                color: #2c3e50;
                margin-bottom: 15px;
            }

            /* Table Styles */
            table {
                width: 90%;
                margin: 20px auto;
                border-collapse: collapse;
                background-color: white;
                box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            }

            th, td {
                padding: 12px 15px;
                text-align: left;
                border-bottom: 1px solid #eee;
            }

            th {
                background-color: #3498db;
                color: white;
            }

            tr:hover {
                background-color: #f8f9fa;
            }

            img {
                max-width: 80px;
                height: auto;
                border-radius: 4px;
            }

            /* Footer */
            footer {
                text-align: center;
                padding: 20px;
                background-color: #2c3e50;
                color: white;
                width: 100%;
            }

            /* Responsive Design */
            @media (max-width: 768px) {
                .top-bar {
                    flex-direction: column;
                    gap: 10px;
                    padding: 10px;
                }

                .top-bar form {
                    margin-right: 0;
                    width: 100%;
                    justify-content: center;
                }

                .header-actions {
                    width: 100%;
                    justify-content: center;
                }

                .admin-container {
                    flex-direction: column;
                }

                .admin-panel, .items {
                    width: 100%;
                    margin-bottom: 20px;
                }

                table {
                    width: 100%;
                }
            }
        </style>


    </head>
    <body>
        <h2 class="page-title">HUGO COFFEE HOUSE</h2>

        <c:if test="${sessionScope.roleID eq 1}" >
            <a href="CreateNewItem.jsp">Create New Items</a>
        </c:if>

        <div class="top-bar">
            <!-- Search -->
            <form action="MainController" method="get">
                <input type="text" name="txtsearch" placeholder="Search Items...">
                <input type="submit" name="btAction" value="Search">
            </form>

            <!--Category-->
            <form action="MainController" method="get">
                <select name="category">
                    <option>COFFEE</option>
                    <option>JUICE</option>
                    <option>WATER</option>
                    <option>SODA</option>
                    <option>SMOOTHIE</option>
                    <option>TEA</option>
                </select>
                <input type="submit" name="btAction" value="Filter by Category">
            </form>

            <form action="CartController" method="get">
                <select name="productSelection">
                    <option value="">Choose Product</option>
                    <c:forEach var="item" items="${requestScope.data}">
                        <option>${item.itemsName}</option>
                    </c:forEach>
                </select>
                <br>
                <input type="submit" name="btAction" value="Add Cart">
                <input type="submit" name="btAction" value="View Cart">
            </form>

            <div class="header-actions">
                <c:if test="${sessionScope.username != null}">
                    <span>Hello, ${sessionScope.username}</span>
                    <form action="MainController" method="get">
                        <input type="submit" name="btAction" value="Logout">
                    </form>    
                </c:if>

                <c:if test="${sessionScope.username == null}">
                    <div class="auth-links">
                        <a href="login.jsp">LOGIN</a>
                        <a href="register.jsp">REGISTER</a>     
                    </div>
                </c:if>
            </div>
        </div>

        <div class="admin-container">
            <c:if test="${sessionScope.roleID eq 1}">
                <div class="admin-panel">
                    <h3>Admin Panel</h3>
                    <ul>
                        <li><a href="manage_items.jsp">Manage Items</a></li>
                        <li><a href="ShowUserController">Manage Users</a></li>
                        <li><a href="OrderController">Manage Orders</a></li>
                    </ul>
                </div>
            </c:if>

            <c:if test="${sessionScope.roleID eq 2}">
                <div class="admin-panel">
                    <h3>NOTE ITEMS</h3>
                    <ul>
                        <li><a href="fill.jsp">Fill In Ingredient</a></li>
                    </ul>
                </div>
            </c:if>



            <div class="items">
                <h3>Items Detail</h3>
                <form action="ItemDetailController" method="get">
                    <select name="items">
                        <option>COFFEE</option>
                        <option>JUICE</option>
                        <option>WATER</option>
                        <option>SODA</option>
                        <option>SMOOTHIE</option>
                        <option>TEA</option>
                    </select>
                    <input type="submit" name="btAction" value="Choice">
                </form>
            </div>
        </div>

        <table>
            <thead>
                <tr>
                    <th>Item ID</th>
                    <th>Item Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Category</th>
                    <th>Image</th>
                        <c:if test="${sessionScope.roleID eq 1}" >
                        <th>Action</th>
                        </c:if>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${requestScope.data}">
                    <tr>
                        <td>${item.itemsID}</td>
                        <td>${item.itemsName}</td>
                        <td>${item.price}</td>
                        <td>${item.quantity}</td>
                        <td>${item.categoryID}</td>
                        <td><img src="${item.itemsImagePath}" alt="Item Image" /></td>
                            <c:if test="${sessionScope.roleID eq 1}" >
                            <td>
                                <form action="MainController" method="get">
                                    <input type="hidden" name="itemID" value="${item.itemsID}" />
                                    <input type="submit" name="btAction" value="Delete" style="background-color: #ff4d4d; color: white; padding: 6px 10px; border-radius: 5px; cursor: pointer;" />
                                </form>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <footer>
            <p>© 2025 Hugo Coffee House. All rights reserved.</p>
        </footer>
    </body>
</html>
