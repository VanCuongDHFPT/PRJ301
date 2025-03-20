
package CuongVV.Controller;

import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//"MainController?pk=" + dto.getUsername() + "&btAction=Del&lastSearchValue=" + request.getParameter("txtSearchValue");
@WebServlet(name = "ShowSearchController", urlPatterns = {"/ShowSearchController"})
public class ShowSearchController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<h1>Search Result</h1>");
            String searchValue = request.getParameter("txtSearchValue");
            out.println("Your search value is " + searchValue);
            List<Account> result
                    = (List<Account>) request.getAttribute("searchRe");
            if (result != null) {
                out.println("<form action='MainController' method='GET'>");
                out.println("<table border='1'>");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>No.</th>");
                out.println("<th>Username</th>");
                out.println("<th>Password</th>");
                out.println("<th>Lastname</th>");
                out.println("<th>Role</th>");
                out.println("<th>Delete</th>");
                out.println("<th>Update</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");

                int count = 0;
                for (Account dto : result) {

                    String urlRewriting = "MainController?pk=" + dto.getUsername() + "&btAction=Del&lastSearchValue=" + request.getParameter("txtSearchValue");
                    out.println("<form action='MainController' method='get'>");
                    out.println("<tr>");

                    out.println("<td>" + ++count + ".</td>");
                    out.println("<td>"
                            + dto.getUsername()
                            + "<input type='hidden' name='txtUsername' value='"
                            + dto.getUsername() + "' />"
                            + "</td>");

                    out.println("<td>"
                            + "<input type='text' name='txtPassword' value='"
                            + dto.getPassword()
                            + "' />"
                            + "</td>");

                    out.println("<td>"
                            + "<input type='text' name='txtFullname' value='"
                            + dto.getFullName()
                            + "' />"
                            + "</td>");

                    if (dto.getRole().trim().equalsIgnoreCase("admin")) {
                        out.println("<td>"
                                + "<input type='checkbox' name='chkAdmin' value='ON' checked='checked' /> Admin"
                                + "</td>");
                    } else {
                        out.println("<td>"
                                + "<input type='checkbox' name='chkAdmin' value='ON' /> Users"
                                + "</td>");
                    }
                    // Delete Link
                    out.println("<td><a href='" + urlRewriting + "'>Delete</a></td>");
                    // Update Button
                    out.println("<td><input type='submit' value='Update' name='btAction' /></td>");
                    out.println("<input type='hidden' name='lastSearchValue' value='" + request.getParameter("txtSearchValue") + "' />");
                    out.println("</tr>");
                    out.println("</form>");                }
                out.println("</tbody>");
                out.println("</table>");
                out.println("</form>");
            } else {
                out.println("<h2 style='color:red'>No record is matched</h2>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
