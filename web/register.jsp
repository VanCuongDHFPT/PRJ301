<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register Form</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            .register-container {
                background-color: white;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 400px;
                text-align: left;
            }
            .register-container h1 {
                margin-bottom: 20px;
                color: blue;
            }
            .form-group {
                display: flex;
                align-items: center;
                margin-bottom: 15px;
            }
            .form-group label {
                width: 150px;
                font-weight: bold;
            }
            .form-group input {
                width: calc(100% - 160px); /* Tạo độ rộng cho ô nhập liệu */
                padding: 10px;
                margin: 5px 0;
                border: 1px solid #ccc;
                border-radius: 5px;
            }
            .register-container input[type="submit"] {
                width: 100%;
                padding: 10px;
                margin-top: 10px;
                border: none;
                border-radius: 5px;
                background-color: #28a745;
                color: white;
                cursor: pointer;
            }
            .register-container input[type="submit"]:hover {
                background-color: #218838;
            }
            .register-container .msg {
                color: red;
                font-weight: bold;
            }
            .register-container input[type="text"]:focus,
            .register-container input[type="password"]:focus {
                border-color: #007bff;
                outline: none;
            }
        </style>
    </head>
    <body>
        <div class="register-container">
            <h1>REGISTER</h1>
            <form action="RegisterController" method="get">
                <div class="form-group">
                    <label for="txtAccountId">ID: </label>
                    <input type="text" id="txtAccountId" name="txtAccountId" placeholder="ID" /><br/>
                </div>
                <div class="form-group">
                    <label for="txtUsername">Name: </label>
                    <input type="text" id="txtUsername" name="txtUsername" placeholder="Username" required /><br/>
                </div>
                <div class="form-group">
                    <label for="txtPassword">Password: </label>
                    <input type="password" id="txtPassword" name="txtPassword" placeholder="Password" required /><br/>
                </div>
                <div class="form-group">
                    <label for="cpassword">Confirm Password: </label>
                    <input type="password" id="cpassword" name="cpassword" placeholder="Confirm Password" required /><br/>
                </div>
                <div class="form-group">
                    <label for="txtFullname">Full Name: </label>
                    <input type="text" id="txtFullname" name="txtFullname" placeholder="Full Name" required /><br/>
                </div>
                <div class="form-group">
                    <label for="txtRole">Role: </label>
                    <input type="text" id="txtRole" name="txtRole" placeholder="Role" required /><br/>
                </div>
                <input type="submit" value="Register" name="btAction" /><br/>
            </form>

            <div class="msg">
                <% String msg = (String) request.getAttribute("msg");%>
                <%= msg != null ? msg : ""%>
            </div>
        </div>
    </body>
</html>
