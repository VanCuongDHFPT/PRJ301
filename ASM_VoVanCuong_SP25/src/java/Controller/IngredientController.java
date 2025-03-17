/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.IngredientDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vovan
 */
@WebServlet(name = "IngredientController", urlPatterns = {"/IngredientController"})
public class IngredientController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String IngredientID = request.getParameter("IngredientID");
        String OrderID = request.getParameter("OrderID");
        String Note = request.getParameter("Note");
        try {
            IngredientDao dao = new IngredientDao();
            boolean re = dao.InsertIngredient(IngredientID, OrderID, Note);
            if (re) {
                request.setAttribute("msg", "Insernt Successfully");
                request.getRequestDispatcher("fill.jsp").forward(request, response);

            } else {
                request.setAttribute("msg", "Insert Falis");
                request.getRequestDispatcher("fill.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
