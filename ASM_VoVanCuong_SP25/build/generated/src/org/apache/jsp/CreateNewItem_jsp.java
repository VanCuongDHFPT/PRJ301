package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CreateNewItem_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Create New Items Page</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                background-color: #f4f4f4;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h1 {\n");
      out.write("                text-align: center;\n");
      out.write("                color: #333;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            form {\n");
      out.write("                background-color: #fff;\n");
      out.write("                padding: 20px;\n");
      out.write("                margin: 20px auto;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                width: 300px;\n");
      out.write("                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            label {\n");
      out.write("                font-weight: bold;\n");
      out.write("                margin-bottom: 8px;\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"text\"] {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 10px;\n");
      out.write("                margin: 8px 0 15px 0;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"submit\"] {\n");
      out.write("                background-color: #4CAF50;\n");
      out.write("                color: white;\n");
      out.write("                padding: 10px 15px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                width: 100%;\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"submit\"]:hover {\n");
      out.write("                background-color: #45a049;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-container {\n");
      out.write("                width: 70%;\n");
      out.write("                margin: 0 auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-section {\n");
      out.write("                margin-bottom: 40px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"form-container\">\n");
      out.write("            <div class=\"form-section\">\n");
      out.write("                <h1>Create New Item</h1>\n");
      out.write("                <form action=\"InsertItemController\" method=\"post\">\n");
      out.write("                    <label for=\"itemsID\">Item ID:</label>\n");
      out.write("                    <input type=\"text\" id=\"itemsID\" name=\"itemsID\"><br>\n");
      out.write("\n");
      out.write("                    <label for=\"itemsName\">Item Name:</label>\n");
      out.write("                    <input type=\"text\" id=\"itemsName\" name=\"itemsName\"><br>\n");
      out.write("\n");
      out.write("                    <label for=\"price\">Price:</label>\n");
      out.write("                    <input type=\"text\" id=\"price\" name=\"price\"><br>\n");
      out.write("\n");
      out.write("                    <label for=\"quantity\">Quantity:</label>\n");
      out.write("                    <input type=\"text\" id=\"quantity\" name=\"quantity\"><br>\n");
      out.write("\n");
      out.write("                    <label for=\"categoryID\">Category ID:</label>\n");
      out.write("                    <input type=\"text\" id=\"categoryID\" name=\"categoryID\"><br>\n");
      out.write("\n");
      out.write("                    <label for=\"itemsImagePath\">Image Path:</label>\n");
      out.write("                    <input type=\"text\" id=\"itemsImagePath\" name=\"itemsImagePath\"><br>\n");
      out.write("\n");
      out.write("                    <input type=\"submit\" value=\"Insert Item\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-section\">\n");
      out.write("                <h1>Create New Category</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <form action=\"InsertCategoryController\" method=\"post\">\n");
      out.write("                    <label for=\"itemsID\">Category ID:</label>\n");
      out.write("                    <input type=\"text\" id=\"categoryID\" name=\"categoryID\"><br>\n");
      out.write("\n");
      out.write("                    <label for=\"itemsName\">Category Name:</label>\n");
      out.write("                    <input type=\"text\" id=\"Categoryname\" name=\"Categoryname\"><br>\n");
      out.write("                    <input type=\"submit\" value=\"Insert Category\">\n");
      out.write("\n");
      out.write("                    ");
String msg = (String) request.getAttribute("Msg");
      out.write("\n");
      out.write("                    <h2 style=\"color: aqua\">");
      out.print(msg != null ? msg : "");
      out.write("</h2>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
