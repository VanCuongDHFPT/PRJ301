package CuongVV.Controller;

import Dal.AccountDao;
import Model.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.getRequestDispatcher("LoginController").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           String name = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        try {
            AccountDao dao = new AccountDao();
            Account re = dao.getCheckLogin(name, password);
            if (re != null) {
                response.sendRedirect("search.html");
            } else {
                response.sendRedirect("Invalid.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
