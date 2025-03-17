package Controller;
import Dal.UserDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateUsersController", urlPatterns = {"/UpdateUsersController"})
public class UpdateUsersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = request.getParameter("txtUserID");
        String username = request.getParameter("txtUserName");
        String Email = request.getParameter("txtemail");
        String phone = request.getParameter("txtPhoneNumber");
        String role = request.getParameter("txtRole");
        String password = request.getParameter("txtPassword");
        String SearchValue = request.getParameter("lastSearchValue");
        String url = "manage_users.jsp";
        try {
            UserDao dao = new UserDao();
            dao.Update(userID, username, Email, password, role, phone);
            url = "MainController?btAction=SearchValue&txtSearchValue=" + SearchValue;
            response.sendRedirect(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
