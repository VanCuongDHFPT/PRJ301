/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.CategoryDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jdt.core.compiler.CategorizedProblem;

/**
 *
 * @author vovan
 */
@WebServlet(name = "InsertCategoryController", urlPatterns = {"/InsertCategoryController"})
public class InsertCategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoryID = request.getParameter("categoryID");
        String Categoryname = request.getParameter("Categoryname");
        try {
            CategoryDao dao = new CategoryDao();
            boolean re = dao.addCategory(categoryID, Categoryname);
            if (re) {
                request.setAttribute("Msg", "Added");
                request.getRequestDispatcher("CreateNewItem.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
