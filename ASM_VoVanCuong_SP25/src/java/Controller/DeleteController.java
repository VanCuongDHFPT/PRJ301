package Controller;

import Dal.ItemsDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteController", urlPatterns = {"/DeleteController"})
public class DeleteController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String itemID = request.getParameter("itemID");
        try {
            ItemsDao dao = new ItemsDao();
            Boolean item = dao.deleteItemsByID(itemID);
            if (item) {
                response.sendRedirect("ShowItems");
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
