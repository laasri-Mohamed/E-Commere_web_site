package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("        <title>Sign Up Form by Colorlib</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- Font Icon -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"fonts/material-icon/css/material-design-iconic-font.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Main css -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"main\">\r\n");
      out.write("\r\n");
      out.write("            <!-- Sign up form -->\r\n");
      out.write("            <section class=\"signup\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"signup-content\">\r\n");
      out.write("                        <div class=\"signup-form\">\r\n");
      out.write("                            <h2 class=\"form-title\">Sign up</h2>\r\n");
      out.write("\r\n");
      out.write("                            <form method=\"post\" action=\"RegistServlet\" class=\"register-form\"\r\n");
      out.write("                                  id=\"register-form\">\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label for=\"name\"></label>\r\n");
      out.write("                                    <table border=\"0\">\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <td>Type d'utilisateurs :</td>\r\n");
      out.write("                                            \r\n");
      out.write("                                            <td>Admin<input id=\"etd\" type=\"radio\" name=\"type\" value=\"Admin\" checked=\"checked\" onclick=\"showAdmin();\"/>\r\n");
      out.write("                                                Client <input id=\"prof\" type=\"radio\" name=\"type\" value=\"Client\" checked=\"checked\" onclick=\"showClient();\"/></td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                       \r\n");
      out.write("                                    </table>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label for=\"name\"><i class=\"zmdi zmdi-account material-icons-name\"></i></label> <input type=\"text\" name=\"fname\" id=\"fname\" placeholder=\"First Name\" required=\"\"/>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label for=\"name\">\r\n");
      out.write("                                        <i class=\"zmdi zmdi-account material-icons-name\"></i></label> <input type=\"text\" name=\"lname\" id=\"lname\" placeholder=\"Last Name\" required=\"\"/>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label for=\"email\"><i class=\"zmdi zmdi-email\"></i></label> <input type=\"email\" name=\"email\" id=\"email\" placeholder=\"Your Email\" required=\"\"/>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label for=\"pass\"><i class=\"zmdi zmdi-lock\"></i></label> <input type=\"password\" name=\"pass\" id=\"pass\" placeholder=\"Password\" required=\"\"/>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label for=\"contact\"><i class=\"zmdi zmdi-phone \"></i></label><input type=\"text\" name=\"tele\" id=\"contact\" placeholder=\"Telephone\" />\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label for=\"adresse\"><i class=\"zmdi zmdi-lock-outline\"></i></label><input type=\"text\" name=\"adresse\" id=\"adresse\" placeholder=\"Adresse\" />\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <input type=\"checkbox\" name=\"agree-term\" id=\"agree-term\" class=\"agree-term\" /> <label for=\"agree-term\" class=\"label-agree-term\"><span><span></span></span>I\r\n");
      out.write("                                        agree all statements in <a href=\"#\" class=\"term-service\">Terms of service</a></label>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group form-button\"> <input type=\"submit\" name=\"signup\" id=\"signup\"\r\n");
      out.write("                                           class=\"form-submit\" value=\"Register\" />\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"signup-image\">\r\n");
      out.write("                            <figure>\r\n");
      out.write("                                <img src=\"images/signup-image.jpg\" alt=\"sing up image\">\r\n");
      out.write("                            </figure>\r\n");
      out.write("                            <a href=\"login.jsp\" class=\"signup-image-link\">I am already member</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- JS -->\r\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"js/main.js\"></script>\r\n");
      out.write("        <script src=\"js/roleUser.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
