package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import Model.CartObj;

public final class VeiwCart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>View Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>To Cart includes:</h1>\n");
      out.write("        ");

            if (session != null) {
                CartObj cart = (CartObj) session.getAttribute("cart");
                if (cart != null) {
                    if (cart.getItems() != null) {
        
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>No</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Delete</th>\n");
      out.write("                    <th>Total</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            <form action=\"CartController\">\n");
      out.write("                ");

                    Map<String, Integer> items = cart.getItems();
                    int count = 1;
                    double totalCartPrice = 0;
                    for (Map.Entry item : items.entrySet()) {
                        String itemsName = (String) item.getKey();
                        int quantity = (int) item.getValue();
                        double price = cart.getItemPrice(itemsName);
                        double totalPriceForItem = price * quantity;
                        totalCartPrice += totalPriceForItem;
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(count++);
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(item.getKey());
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(item.getValue());
      out.write(" \n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"checkbox\" name=\"ckItem\" value=\"");
      out.print(item.getKey());
      out.write("\" />\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                    <td>");
      out.print(totalPriceForItem);
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"3\">\n");
      out.write("                        <a href=\"ShowItems\">Add more Items</a>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"submit\" value=\"Remove Cart\" name=\"btAction\" />\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"submit\" value=\"Checkout\" name=\"btAction\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <td colspan=\"4\" style=\"text-align:right;\">Total Cart Price:</td>\n");
      out.write("                <td>");
      out.print( totalCartPrice);
      out.write("</td>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("    ");

    } else {

    
      out.write("\n");
      out.write("    <h2> Cart Empty</h2>\n");
      out.write("\n");
      out.write("    ");
         }
            }
        }
    
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
