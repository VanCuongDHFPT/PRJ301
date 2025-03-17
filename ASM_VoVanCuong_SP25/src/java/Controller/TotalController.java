package Controller;

import Dal.OrderDao;
import Model.Orders;
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
@WebServlet(name = "TotalController", urlPatterns = {"/TotalController"})
public class TotalController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String orderID = request.getParameter("OID");
        String userID = request.getParameter("UID");
        String date_raw = request.getParameter("date");
        String paymentMethod = request.getParameter("paymentMethod");
        String paymentStatus = request.getParameter("paymentStatus");
//        System.out.println("orderID: " + orderID);
//        System.out.println("userID: " + userID);
//        System.out.println("date_raw: " + date_raw);
//        System.out.println("paymentMethod: " + paymentMethod);
//        System.out.println("paymentStatus: " + paymentStatus);
        try {
            java.sql.Date orderDate = null;
            if (date_raw != null && !date_raw.isEmpty()) {
                orderDate = java.sql.Date.valueOf(date_raw);
            }
            OrderDao dao = new OrderDao();
            boolean orid = dao.GetOrdersID(orderID);
            if (orid) {
                request.setAttribute("msg", "OrderID empty or Exits");
                request.getRequestDispatcher("Checkout.jsp").forward(request, response);
            }
            else {
                Orders order = new Orders(orderID, userID, orderDate, paymentMethod, paymentStatus);
                dao.Checkout(order);
                response.sendRedirect("VeiwCart.jsp");
            }
            }catch (Exception e) {
            e.printStackTrace();
        }
        }

        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        }

    }

//java.sql.Date orderDate = null;
//            if (date_raw != null && !date_raw.isEmpty()) {
//                orderDate = java.sql.Date.valueOf(date_raw); 
