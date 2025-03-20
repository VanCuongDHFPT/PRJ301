/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CuongVV.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vovan
 */
public class MainController extends HttpServlet {

    private final String LoginController = "LoginController";
    private final String SearchController = "SearchController";
    private final String DeleteController = "DeleteController";
    private final String UpdateController = "UpdateController";
    private final String RegisterController = "RegisterController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("btAction");
            String url = LoginController;
            if (action.equals("Login")) {
                url = LoginController;
            } else if (action.equals("Search")) {
                url = SearchController;
            } else if (action.equals("Del")) {
                url = DeleteController;
            } else if (action.equals("Update")) {
                url = UpdateController;
            } else if (action.equals("Register")) {
                url = RegisterController;
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
