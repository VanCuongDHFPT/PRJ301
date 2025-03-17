/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.ItemsDao;
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
@WebServlet(name = "InsertItemController", urlPatterns = {"/InsertItemController"})
public class InsertItemController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String itemsID = request.getParameter("itemsID");
        String itemsName = request.getParameter("itemsName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String categoryID = request.getParameter("categoryID");
        String itemsImagePath = request.getParameter("itemsImagePath");
        
        ItemsDao itemDAO = new ItemsDao();
        itemDAO.insertItem(itemsID, itemsName, price, quantity, categoryID, itemsImagePath);
        
        response.sendRedirect("ShowItems");
    }
    
}
