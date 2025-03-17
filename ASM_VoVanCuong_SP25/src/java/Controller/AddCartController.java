package Controller;

import Model.CartObj;
import java.io.IOException;
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
@WebServlet(name = "AddCartController", urlPatterns = {"/AddCartController"})
public class AddCartController extends HttpServlet {

    private final String ShhopingPafe = "ShowItems";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Lấy giỏ hàng hiện tại từ session
        CartObj cart1 = (CartObj) session.getAttribute("cart");

        // Nếu giỏ hàng chưa tồn tại trong session, tạo một giỏ hàng mới
        if (cart1 == null) {
            cart1 = new CartObj();
        }
        
        String title = request.getParameter("productSelection");

        // Nếu title không null và không rỗng, thêm sách vào giỏ hàng
        if (title != null && !title.isEmpty()) {
            cart1.addItemsToCart(title);
        }

        // Lưu giỏ hàng cập nhật lại vào session
        session.setAttribute("cart", cart1);

        // Chuyển hướng đến trang giỏ hàng (ShoppingPage hoặc tên trang khác của bạn)
        response.sendRedirect(ShhopingPafe); // Thay "ShoppingPage.jsp" bằng trang bạn muốn chuyển hướng đến

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

}
