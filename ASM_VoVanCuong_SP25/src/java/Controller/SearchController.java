
package Controller;

import Dal.ItemsDao;
import Model.Items;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchValue = request.getParameter("txtsearch");
        try {
            ItemsDao dao = new ItemsDao();
            List<Items> item = dao.searchItems(searchValue);
            if(item != null) {
                request.setAttribute("data", item);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
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
