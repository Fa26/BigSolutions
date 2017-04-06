package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("<<<<<<< c71fdcd4b059559d9a77b6b98d3bfb4d7e01f2eb\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
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
      out.write("        <img src=\"imagenes/foodCiencias.jpg\" width=\"200\" height=\"50\"/> \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <form action=\"resultados_consulta.jsp\" method=\"post\" style=\"text-align: center\">\n");
      out.write("            Buscar puesto: <input type=\"text\" name=\"puesto\">\n");
      out.write("        <input type =\"submit\" value=\"Buscar\">\n");
      out.write("        </form>\n");
      out.write("\n");
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
      out.write(" <form method=\"post\">\n");
      out.write("        Nombre del Puesto: <br><br><input name=\"ingresatexto\" type=\"text\" placeholder=\"Nombre del puesto\"/>\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("<hr>\n");
      out.write("\n");
      out.write("<div class=\"p\">\n");
      out.write("\t<p>Propietario</p>\n");
      out.write("</div>\n");
      out.write("<div class=\"p2 letra\">\n");
      out.write("<form method=\"post\" action=\"action.php\">\n");
      out.write("\tNombre: <input nombre=\"ingresatexto\" type=\"text\" placeholder=\"Nombre\"/>\n");
      out.write("\t &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\tApellido Matenro: <input nombre=\"ingresa\" type=\"text\" placeholder=\"Apellido Materno\"/><br><br>\n");
      out.write("\tApellido Paterno: <input nombre=\"ingresatexto\" type=\"text\" placeholder=\"Apellido Paterno\"/>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("<hr>\n");
      out.write("\n");
      out.write("<div class=\"p\">\n");
      out.write("\t<p>Comida</p>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class =\"p2 letra\">\n");
      out.write("<form method=\"post\" action=\"action.php\">\n");
      out.write("Tipo de Comida: <input nombre=\"tcomida\" type=\"text\" placeholder=\"Tipo de Comida\"/>\n");
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("Horario: <input nombre=\"tcomida\" type=\"text\" placeholder=\"Horario\"/><br/><br/>\n");
      out.write(" <label for=\"descripcion\">Menu: </label> <br/>\n");
      out.write("  <textarea name=\"menu\" id=\"menu\" cols=\"40\" rows=\"5\"></textarea><br><br>\n");
      out.write("  <label for=\"foto\">Mi foto:</label><br>\n");
      out.write("  <input type=\"file\" nombre=\"foto\"/>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("<br>\n");
      out.write("<hr>\n");
      out.write("\n");
      out.write("<br/>\n");
      out.write("<button class=\"button p3\" onclick=\"alert ('Tu puesto ha sido dado de alta!')\">\n");
      out.write("\tListo!\n");
      out.write("</button>\n");
      out.write("\n");
      out.write("<!--\n");
      out.write("<div class=\"posicion_img capa opacity\">\n");
      out.write("<img src=\"logoCiBN3.jpg\"  width=\"470\" height=\"150\" style=\"float:left\">\n");
      out.write("</div>-->\n");
      out.write("\n");
      out.write("<div class=\"capa opacity img2\">\n");
      out.write("<img  src=\"img/logoCiBN3.jpg\" width=\"300\" height=\"86\" style=\"float:left\">\n");
      out.write("</div>\n");
      out.write("      <!--  <h1>Hello World!</h1>-->\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
