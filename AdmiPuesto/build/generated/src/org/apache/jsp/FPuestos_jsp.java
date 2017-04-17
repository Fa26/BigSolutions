package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FPuestos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <li><a class=\"active\"href=\"#news\">Registrar Puesto</a></li>\n");
      out.write("  <li><a href=\"#contact\">Ver Puesto Puesto</a></li><br>\n");
      out.write("  <li><a href=\"#about\">Censurar Comentario</a></li><br>\n");
      out.write("  <li><a href=\"#coment\">Comentar</a></li><br><br>\n");
      out.write("  <li><a href=\"#buscar\">Buscar</a></li><br>\n");
      out.write(" </ul>\n");
      out.write(" </div>\n");
      out.write("\n");
      out.write(" <div class=\"form letra\">\n");
      out.write(" <form  action=\"PuestoC\" method=\"post\">\n");
      out.write("        Nombre del Puesto: <br><br><input name=\"nombre\" type=\"text\" placeholder=\"Nombre del puesto\"/>\n");
      out.write("\n");
      out.write(" </div>\n");
      out.write("        <hr>\n");
      out.write("        <div class=\"p\">\n");
      out.write("\t<p>Puesto</p>\n");
      out.write("        </div>\n");
      out.write("       <div class=\"p2 letra\">\n");
      out.write("            \tHora de Apertura: <input name=\"hora_apertura\" type=\"text\" placeholder=\"Hora de apertura\"/>\n");
      out.write("                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                Hora de Cierre: <input name=\"hora_cierre\" type=\"text\" placeholder=\"cierre\"/><br><br>\n");
      out.write("                Tipo de comida: <input name=\"tipo_comida\" type=\"text\" placeholder=\"tipo de comida\"/><br><br>\n");
      out.write("                                       \n");
      out.write("                \n");
      out.write("        </div>\n");
      out.write("        <hr>\n");
      out.write("        \n");
      out.write("       <div class=\"p\">\n");
      out.write("            <p>Propietario</p>\n");
      out.write("       </div>\n");
      out.write("        <div class =\"p2 letra\">\n");
      out.write("            Nombre: <input name=\"nom_duenio\" type=\"text\" placeholder=\"nombre dueño\"/>\n");
      out.write("            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            Apellido Paterno: <input name=\"app_duenio\" type=\"text\" placeholder=\"Apellido Paterno\"/><br/><br/>\n");
      out.write("            Apellido Materno: <input name=\"apm_duenio\" type=\"text\" placeholder=\"Apellido Materno\"/><br/><br/>\n");
      out.write("            <label for=\"foto\">Mi foto:</label><br/>\n");
      out.write("            <input type=\"file\" name=\"foto\"/>\n");
      out.write("            <br/><br/><br/><br/>\n");
      out.write("        \n");
      out.write("           \n");
      out.write("            <button class=\"button\" onclick=\"alert ('Tu puesto ha sido dado de alta!')\" type=\"submit\">\n");
      out.write("            Listo!\n");
      out.write("            </button>\n");
      out.write("            </div>\n");
      out.write("</form>\n");
      out.write("    <hr>\n");
      out.write("<div class=\"capa opacity img3\">\n");
      out.write("<img  src=\"img/logoCiBN3.jpg\" width=\"300\" height=\"86\" style=\"float:left\">\n");
      out.write("</div>\n");
      out.write("      \n");
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
