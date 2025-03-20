/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CuongVV.Controller;

import Dal.AccountDao;
import Model.Account;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searhValue = request.getParameter("txtSearchValue");
        try {
            if (!searhValue.isEmpty()) {
                AccountDao dao = new AccountDao();
                dao.SearchFulltName(searhValue);
                List<Account> result = dao.getListAccounts();
                request.setAttribute("searchRe", result);
                request.getRequestDispatcher("ShowSearchController").forward(request, response);
            } else {
                request.getRequestDispatcher("search.html").forward(request, response);
            }

        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searhValue = request.getParameter("txtSearchValue");
        try {
            if (!searhValue.isEmpty()) {
                AccountDao dao = new AccountDao();
                dao.SearchFulltName(searhValue);
                List<Account> result = dao.getListAccounts();
                request.setAttribute("searchRe", result);
                request.getRequestDispatcher("ShowSearchController").forward(request, response);
            } else {
                request.getRequestDispatcher("search.jsp").forward(request, response);
            }

        } catch (Exception e) {
        }
    }
}
