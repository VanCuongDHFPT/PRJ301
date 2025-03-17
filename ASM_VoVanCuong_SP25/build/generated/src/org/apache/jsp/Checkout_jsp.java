package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Checkout Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
String msg  = (String )  request.getAttribute("msg");
      out.write("\n");
      out.write("        ");
      out.print( msg != null ? msg : "" );
      out.write("\n");
      out.write("        \n");
      out.write("        <form action=\"TotalController\" method=\"get\">\n");
      out.write("            <label for=\"orderID\">Order ID:</label>\n");
      out.write("            <input type=\"text\" id=\"orderID\" name=\"OID\" required /><br>\n");
      out.write("\n");
      out.write("            <label for=\"userID\">User ID:</label>\n");
      out.write("            <input type=\"text\" id=\"userID\" name=\"UID\" required /><br>\n");
      out.write("            \n");
      out.write("\n");
      out.write("            <label for=\"date\">Date</label>\n");
      out.write("            <input type=\"date\" id=\"date\" name=\"date\" required placeholder=\"yyyy-MM-dd HH:mm:ss\" /><br>\n");
      out.write("\n");
      out.write("            <label for=\"paymentMethod\">Payment Method:</label>\n");
      out.write("            <select name=\"paymentMethod\">\n");
      out.write("                <option>Cash</option>\n");
      out.write("                <option>PayPal</option>\n");
      out.write("            </select><br>\n");
      out.write("            <label for=\"paymentStatus\">Payment Status:</label>\n");
      out.write("            <select name=\"paymentStatus\">\n");
      out.write("                <option>Pending</option>\n");
      out.write("                <option>Paid</option>\n");
      out.write("            </select><br>\n");
      out.write("            <input type=\"submit\" value=\"Complete Payment\" />\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
