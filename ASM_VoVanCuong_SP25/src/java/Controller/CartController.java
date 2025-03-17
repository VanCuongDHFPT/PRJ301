/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.ItemsDao;
import Model.CartObj;
import Model.Items;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vovan
 */
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

    private final String TotalController = "TotalController";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy danh sách sản phẩm để hiển thị (nếu cần)
        ItemsDao dao = new ItemsDao();
        List<Items> items = dao.GetItems();
        request.setAttribute("data", items); // Đặt dữ liệu cho welcome.jsp
//------------------------------------------------------------------------------------------
        // Kiểm tra action từ form
        String action = request.getParameter("btAction");
        HttpSession session = request.getSession();
        CartObj cart = (CartObj) session.getAttribute("cart");
        if (action == null) {
            // Nếu không có action, hiển thị welcome.jsp
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
            return;
        }
        if ("Add Cart".equals(action)) {
            String productSelection = request.getParameter("productSelection");
            if (productSelection == null || productSelection.trim().isEmpty()) {
                response.sendRedirect("welcome.jsp");
            } else {
                response.sendRedirect("AddCartController?productSelection=" + productSelection);
            }
        } else if ("View Cart".equals(action)) {
            
            request.getRequestDispatcher("VeiwCart.jsp").forward(request, response);
        } else if (action.equals("Remove Cart")) {
            request.getRequestDispatcher("RemoveCartController").forward(request, response);
        } else if (action.equals("Add order details")) {
            request.getRequestDispatcher("Checkout.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
