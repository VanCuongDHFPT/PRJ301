package Controller;

import Dal.UserDao;
import Model.Users;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vovan
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("rememberMe");
        try {
            UserDao dao = new UserDao();
            Users user = dao.CheckLogin(name, password);
            if (user != null) {
                HttpSession session = request.getSession(); // tạo ra cái phiên đăng nhập 
//                if(remember != null) {
//                    Cookie cookie = new Cookie("COOKIE_USERNAME", name);
//                    cookie.setMaxAge(60 * 3);
//                    response.addCookie(cookie);
//                }
                if (remember != null) {
                    Cookie cookie = new Cookie("COOKIE_USERNAME", name);
                    cookie.setMaxAge(60 * 60 * 24 * 3);
                    response.addCookie(cookie); // phàn hồi cookie
                } else {
                    Cookie cookie = new Cookie("COOKIE_USERNAME", "");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);  // phàn hồi cookie
                }
                session.setAttribute("username", user.getUserName());
                session.setAttribute("roleID", user.getRoleID()); 
                response.sendRedirect("ShowItems");
            } else {
                response.sendRedirect("invalid.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
