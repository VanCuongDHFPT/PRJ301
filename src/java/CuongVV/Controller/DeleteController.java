/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CuongVV.Controller;

import Dal.AccountDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//"MainController?btAction=Search&txtSearchValue="
public class DeleteController extends HttpServlet {

    private final String deletePage = "deleteErr.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = deletePage;
            String pk = request.getParameter("pk");
            String searchValue = request.getParameter("lastSearchValue");
            try {
                AccountDao dao = new AccountDao();
                boolean result = dao.DeleteAccount(pk);
                if (result) {
                    url = "MainController?btAction=Search&txtSearchValue=" + searchValue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                response.sendRedirect(url);
            }
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
