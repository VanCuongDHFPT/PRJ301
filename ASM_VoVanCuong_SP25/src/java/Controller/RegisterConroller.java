/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.UserDao;
import Model.Users;
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
@WebServlet(name = "RegisterConroller", urlPatterns = {"/RegisterConroller"})
public class RegisterConroller extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String roleId = request.getParameter("roleID");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phoneNumber");
        String userId = request.getParameter("userID");

        try {
            if (!password.equals(cpassword)) {
                request.setAttribute("msg", "the password not match");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            UserDao dao = new UserDao();
            if (dao.CheckGetName(username) == true) {
                request.setAttribute("msg", "the Usernname exits");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } 
            if (password != null && username != null && cpassword != null) {
                dao.AddUsers(userId, username, email, password, roleId, phonenumber);
                response.sendRedirect("login.jsp");

            } else {
                request.setAttribute("msg", "Please enter username, password, confirm password");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

  
}
