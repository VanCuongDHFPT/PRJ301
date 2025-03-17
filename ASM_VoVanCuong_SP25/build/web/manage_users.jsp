<%@page import="Model.Users"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Information</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f9f9f9;
                margin: 0;
                padding: 0;
                color: #333;
            }
            .table-container {
                width: 80%;
                margin: 50px auto;
                padding: 30px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
                overflow-x: auto;
            }
            h2 {
                text-align: center;
                color: #4CAF50;
                font-size: 26px;
                margin-bottom: 30px;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            th, td {
                padding: 12px 15px;
                text-align: left;
                border-bottom: 1px solid #ddd;
                font-size: 16px;
            }
            th {
                background-color: #4CAF50;
                color: white;
                text-transform: uppercase;
            }
            tr:nth-child(even) {
                background-color: #f9f9f9;
            }
            tr:hover {
                background-color: #e6f4e6;
            }
            .delete-btn {
                color: white;
                background-color: #ff4444;
                padding: 8px 16px;
                text-decoration: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 14px;
                transition: background-color 0.3s ease;
            }
            .delete-btn:hover {
                background-color: #e63e3e;
            }
            .update-btn {
                padding: 8px 16px;
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
                border-radius: 4px;
                font-size: 14px;
                transition: background-color 0.3s ease;
            }
            .update-btn:hover {
                background-color: #45a049;
            }
            .search-container {
                width: 80%;
                margin: 20px auto;
                display: flex;
                justify-content: flex-start;
            }
            .search-container input[type="text"] {
                width: 60%;
                margin-right: 10px;
                padding: 8px;
                font-size: 14px;
                border-radius: 4px;
                border: 1px solid #ddd;
            }
            .search-container button {
                padding: 8px 16px;
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
                border-radius: 4px;
                font-size: 14px;
                transition: background-color 0.3s ease;
            }
            .search-container button:hover {
                background-color: #45a049;
            }
            .home-items-link {
                display: inline-block;
                margin-left: 20px;
                padding: 8px 16px;
                background-color: #007bff;
                color: white;
                text-decoration: none;
                border-radius: 4px;
                font-size: 14px;
                transition: background-color 0.3s ease;
            }
            .home-items-link:hover {
                background-color: #0056b3;
            }
            input[type="text"], input[type="password"] {
                padding: 8px;
                width: 100%;
                border: 1px solid #ddd;
                border-radius: 4px;
                box-sizing: border-box;
                margin: 4px 0;
                font-size: 14px;
            }
        </style>
    </head>
    <body>
        <div class="search-container">
            <form action="MainController" method="get">
                <input type="text" name="txtSearchValue" placeholder="Search users" value="${requestScope.txtSearchValue}" />
                <input type="submit" name="btAction" value="SearchValue">
            </form>
            <a href="ShowItems" class="home-items-link">HOME ITEMS</a>
        </div>

        <%
            String searchValue = request.getParameter("txtSearchValue");
        %>

        <div class="table-container">
            <h2>Users Information</h2>                 
            <form action="MainController" method="get">
                <table>
                    <thead>
                        <tr>
                            <th>User ID</th>
                            <th>User Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Role</th>
                            <th>Password</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${requestScope.data}">
                            <form action="MainController" method="get">
                                <tr>
                                    <td>
                                        ${user.getUserID()}
                                        <input type="hidden" name="txtUserID" value="${user.getUserID()}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtUserName" value="${user.getUserName()}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtemail" value="${user.getEmail()}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtPhoneNumber" value="${user.getPhoneNumber()}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtRole" value="${user.getRoleID()}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtPassword" value="${user.getPassword()}" />
                                    </td>
                                    <td>
                                        <a href="MainController?pk=${user.getUserID()}&btAction=Del&lastSearchValue=${requestScope.txtSearchValue}" class="delete-btn">
                                            Delete
                                        </a>
                                    </td>
                                    <td>
                                        <input type="submit" name="btAction" value="UpdateValue" class="update-btn" />
                                        <input type="hidden" name="lastSearchValue" value="${requestScope.txtSearchValue}" />
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>

















<!--   <a href="MainController?pk= {user.getUserID()}&btAction=Del&lastSearchValue= {requestScope.txtSearchValue}" class="delete-btn">
                                            Delete
                                        </a>-->