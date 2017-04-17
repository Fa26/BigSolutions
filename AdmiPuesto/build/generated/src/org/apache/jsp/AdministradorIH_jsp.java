package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdministradorIH_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <!--Archivo externo de css-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/stilo.css\">\n");
      out.write("        <!--Imagen de pestaña-->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/GrisU.jpg\" type=\"image/jpg\" />\n");
      out.write("        <title>AdministradorIH</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("\n");
      out.write("<div class=\"icon-bar\">\n");
      out.write("  <a href=\"#\"><i class=\"fa fa-user-circle-o\"></i></a><br><br>\n");
      out.write("  <a  href=\"#\"><i class=\"fa fa-calendar\"></i></a> <br><br>\n");
      out.write("  <a href=\"#\"><i class=\"fa fa-envelope\"></i></a><br><br><br><br>\n");
      out.write("  <a href=\"#\"><i class=\"fa fa-bar-chart-o\"></i></a><br><br><br>\n");
      out.write("  <br>\n");
      out.write("  <a href=\"#\"><i class=\"fa fa-cogs\"></i></a><br><br><br>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write(" <div class=\"menu\">\n");
      out.write("<ul>\n");
      out.write("  <li><a href=\"#home\">Salir</a></li>\n");
      out.write("  <li><a href=\"PuestoIH.jsp\">Registrar Puesto</a></li>\n");
      out.write("  <li><a href=\"VerPuesto.jsp\">Ver Puesto</a></li><br>\n");
      out.write("  <li><a href=\"#about\">Censurar Comentario</a></li><br>\n");
      out.write("  <li><a href=\"#coment\">Comentar</a></li><br><br>\n");
      out.write("  <li><a href=\"#buscar\">Buscar</a></li><br>\n");
      out.write(" </ul>\n");
      out.write(" </div>\n");
      out.write("        <div class=\"capa opacity img2\">\n");
      out.write("<img  src=\"img/logoCiBN3.jpg\" width=\"560\" height=\"140\" style=\"float:left\">\n");
      out.write("</div>\n");
      out.write("    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
