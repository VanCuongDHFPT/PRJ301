/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.ItemsDetailDao;
import Model.ItemsDetail;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vovan
 */
@WebServlet(name = "ItemDetailController", urlPatterns = {"/ItemDetailController"})
public class ItemDetailController extends HttpServlet {  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String items = request.getParameter("items");
        try {
            ItemsDetailDao dao = new ItemsDetailDao();
            List<ItemsDetail> itemsdetail = dao.GetItemsDetails(items);
            if(itemsdetail != null) {
                request.setAttribute("data", itemsdetail);
                request.getRequestDispatcher("ItemDetail.jsp").forward(request, response);
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
