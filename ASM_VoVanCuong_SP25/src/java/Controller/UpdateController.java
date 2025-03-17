/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.ItemsDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vovan
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String itemsID = request.getParameter("itemsID");
        String itemsName = request.getParameter("itemsName");
        String price_raw = request.getParameter("price");
        String quantity_raw = request.getParameter("quantity");
        String categoryID = request.getParameter("categoryID");
        try {
            Double price = Double.parseDouble(price_raw);
            if(price == 0 ){
                return;
            }
            int quantity = Integer.parseInt(quantity_raw);
            if(quantity == 0) {
                return ;
            }
            ItemsDao dao = new ItemsDao();
            boolean up = dao.UpdateItems(itemsID, itemsName, price, quantity, categoryID);
            if (up) {
//                request.setAttribute("data", up);
                request.getRequestDispatcher("ShowItems").forward(request, response);
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
