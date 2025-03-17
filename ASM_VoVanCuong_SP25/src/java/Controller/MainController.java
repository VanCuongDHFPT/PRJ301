package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private final String LoginController = "LoginController";
    private final String SearchController = "SearchController";
    private final String RegisterController = "RegisterController";
    private final String LogoutController = "LogoutController";
    private final String RegisterConroller = "RegisterConroller";
    private final String categoryController = "categoryController";
    private final String deleteController = "DeleteController";
    private final String ItemDetailController = "ItemDetailController";
    private final String UpdateController = "UpdateController";
    private final String DeleteUserController = "DeleteUserController";
    private final String SearchUserController = "SearchUserController";
    private final String UpdateUsersController = "UpdateUsersController";
    private final String IngredientController = "IngredientController";;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("btAction");
            String url = "";
            if (action.equals("Login")) {
                url = LoginController;
            } else if (action.equals("Search")) {
                url = SearchController;
            } else if (action.equals("Logout")) {
                url = LogoutController;
            } else if (action.equals("Register")) {
                url = RegisterConroller;
            } else if (action.equals("Filter by Category")) {
                url = categoryController;
            } else if (action.equals("Delete")) {
                url = deleteController;
            } else if (action.equals("Choice")) {
                url = ItemDetailController;
            } else if (action.equals("Update")) {
                url = UpdateController;
            } else if (action.equals("Del")) {
                url = DeleteUserController;
            } else if (action.equals("SearchValue")) {
                url = SearchUserController;
            } else if (action.equals("UpdateValue")) {
                url = UpdateUsersController;
            } else if (action.equals("OK")) {
                url = IngredientController;
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
