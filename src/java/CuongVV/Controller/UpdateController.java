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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String fullname = request.getParameter("txtFullname");
        String seachValue = request.getParameter("lastSearchValue");
        String isAdmin = request.getParameter("chkAdmin");
        String url = "updateErr.html";
        try {
            String role = "Users";
            if (isAdmin != null) {
                role = "admin";
            }
            AccountDao dao = new AccountDao();
            dao.UpdateAccount(username, password, fullname, role);
            url = "MainController?btAction=Search&txtSearchValue=" + seachValue;
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
