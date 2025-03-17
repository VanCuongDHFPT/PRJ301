<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <style>
            /* Basic Reset */
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            /* Body styling */
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                padding: 50px;
            }

            /* Form container */
            form {
                background-color: white;
                width: 400px;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
                margin: 0 auto;
            }

            /* Label and input field styling */
            label {
                display: block;
                margin-bottom: 8px;
                font-size: 14px;
                color: #555;
            }

            input[type="text"], input[type="email"], input[type="tel"], input[type="password"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-size: 16px;
            }

            /* Submit button styling */
            input[type="submit"] {
                width: 100%;
                padding: 12px;
                background-color: #4CAF50; /* Green */
                color: white;
                border: none;
                border-radius: 4px;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            input[type="submit"]:hover {
                background-color: #45a049; /* Darker green */
            }

            /* Error message styling */
            p {
                color: red;
                font-size: 14px;
            }

            /* Add some responsiveness */
            @media (max-width: 500px) {
                form {
                    width: 90%;
                }
            }
          
        </style>
    </head>
    <body>
        <form action="MainController" method="POST">
            <h1>Register </h1>
            <label for="userID">User ID:</label>
            <input type="text" id="userID" name="userID" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="fullName">User Name:</label>
            <input type="text" id="fullName" name="username" required>

            <label for="phoneNumber">Phone Number:</label>
            <input type="tel" id="phoneNumber" name="phoneNumber" required>

            <label for="roleID">Role ID:</label>
            <input type="text" id="roleID" name="roleID" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            <label for="cpassword">Confirm Password:</label>
            <input type="password" id="cpassword" name="cpassword" required>
            
            <input type="submit" name="btAction" value="Register"/>

            <!-- Display error message if present -->
            <c:if test="${requestScope.msg != null}">
                <p>${requestScope.msg}</p>
            </c:if>

        </form>
    </body>
</html>
