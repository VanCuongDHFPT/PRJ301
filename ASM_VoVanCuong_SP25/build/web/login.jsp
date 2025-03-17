<%-- 
Document   : login
Created on : Mar 2, 2025, 7:10:13 AM
Author     : vovan
--%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login Form</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                padding: 50px;
            }

            /* Login container styling */
            .login-container {
                background-color: #fff;
                width: 400px;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
                margin: 0 auto;
            }

            /* Heading style */
            h2 {
                text-align: center;
                margin-bottom: 20px;
                font-size: 24px;
                color: #333;
            }

            /* Label and input field styling */
            label {
                display: block;
                margin-bottom: 8px;
                font-size: 14px;
                color: #555;
            }

            input[type="text"], input[type="password"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-size: 16px;
            }

            /* Login button styling */
            input[type="submit"].login-btn {
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

            input[type="submit"].login-btn:hover {
                background-color: #45a049; /* Darker green */
            }

            /* Register link styling */
            .register-link {
                color: #4CAF50;
                text-decoration: none;
            }

            .register-link:hover {
                text-decoration: underline;
            }

            /* Add some responsiveness */
            @media (max-width: 500px) {
                .login-container {
                    width: 90%;
                }
            }
        </style>
    </head>
    <body>
        <div class="login-container">
            <h2>Login</h2>
            <form action="MainController" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" value="${cookie.COOKIE_USERNAME.value}" required>

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>

                <label for="remember Me">Remember me:</label>
                <input type="checkbox" id="rememberMe"  name="rememberMe" value="on"><br/>
                <input type="submit"  value="Login" class="login-btn" name="btAction" />
                <p>Don't have an account? <a href="register.jsp" class="register-link">Register</a></p>
            </form>
        </div>
    </body>
</html>
