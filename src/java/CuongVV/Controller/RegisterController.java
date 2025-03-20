/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CuongVV.Controller;

import Dal.AccountDao;
import Model.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vovan
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Id_raw = request.getParameter("txtAccountId");
        String Username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String cpassword = request.getParameter("cpassword");
        String fullname = request.getParameter("txtFullname");
        String role = request.getParameter("txtRole");
        try {
            AccountDao dao = new AccountDao();
            int id = Integer.parseInt(Id_raw);
            if (!password.equals(cpassword)) {
                request.setAttribute("msg", "password doesn't match.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }

            if (Username != null && password != null && cpassword != null) {
                dao.InsertAccount(new Account(id, Username, password, fullname, role));
                response.sendRedirect("login.html");
            } else {
                request.setAttribute("msg", "Please, fill out a form.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Id_raw = request.getParameter("txtAccountId");
        String Username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String cpassword = request.getParameter("cpasword");
        String fullname = request.getParameter("txtFullname");
        String role = request.getParameter("txtRole");
        try {
            int id = Integer.parseInt(Id_raw);
            if (!password.equals(cpassword)) {
                request.setAttribute("msg", "The password dosen't match.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            if (Username != null && password != null && cpassword != null) {
                AccountDao dao = new AccountDao();
                dao.InsertAccount(new Account(id, Username, password, fullname, role));
                response.sendRedirect("LoginController");
            } else {
                request.setAttribute("msg", "Please, fill out a form.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
