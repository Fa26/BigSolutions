<%-- 
    Document   : VentanaComentario
    Created on : 21/04/2017, 04:59:41 PM
    Author     : mint
--%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.palemon.proyecto.controlador.Comentario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-MX">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>Food Ciencias</title>
    
    <link rel="shortcut icon" href="http://vandelaydesign.com/favicon.ico">
    <link rel="icon" href="http://vandelaydesign.com/favicon.ico">
    <link rel="stylesheet" type="text/css" media="all" href="../css/ventanaEmergente.css">
    <link rel="stylesheet" type="text/css" media="all" href="../css/informacion.css">

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="../js/modals.js"></script>

  </head>

  <body>
    <!--Inicia informacion puesto-->
    <div id="Informacion" class="container center">
        <span>
          <span class="row">
            <span class="col-4">
              <img src="../imagenes/foodCiencias.jpg" width="350" height="80">
            </span>
          </span>
        </span>
        <span>
          <img src="../imagenes/puesto.jpeg" align="right">
        </span>
          <h3>Informacion!</h3>
          <p>Menu 1</p>
          <p>Menu 2</p>
          <p>Menu 3</p>
          <p>Menu 4</p>           
        <br>
      
    </div><!--fin información puesto-->
<br>
<br>
<div id="Comentar"> <!--Inicia Caja Comentar-->
  <!--botones-->
  <center>
    <a href="#EmergenteCalificar" data-toggle="modal" class="btn btn-large">Calificar</a>
    <a href="#EmergenteComentar" data-toggle="modal" class="btn btn-large">Comentar</a> 
  </center>
  <!--fin botones-->

  <br><br>
  <!--Pila de comentarios-->
    <h3>Comentarios!</h3>

        <%
            String nIdPuesto = request.getParameter("puesto"); 
            Comentario c = new Comentario();
            ArrayList comentarios = new ArrayList();
            
            c.conecta();
            comentarios = c.buscarComentarios(nIdPuesto);
            c.desconecta();
            
            if (comentarios.size() > 0) {
                
        %>
       
        <br>
    <div style="width:auto; height:300px; line-height:3em; overflow:scroll; padding:5px; background-color:#FCFADD; color:#714D03; border:4pxdouble #DEBB07;">
    <ul id="comments" class="comments">
   
            <%
                for (int i = 0; i < comentarios.size(); i++) {
                    int nIdComentario = ((Comentario) comentarios.get(i)).getnIdComentario();
                    String texto = ((Comentario) comentarios.get(i)).getTexto();
                    Date fecha = ((Comentario) comentarios.get(i)).getFecha();
                    %>
            <li>
             <div class="clearfix">
              <h4 class="pull-left">Jonh</h4>
             <p class="pull-right"><%=fecha%></p>
             </div>
                <p>
                <em><%=texto%></em>                    
                </p>
                <hr width="auto" size="20" color = "black">
            </li>            
                    <%
                }
            } else {
                out.write("no hay comentarios");
            }
        %>
    </ul>

    </div>
    <!--finde pila comentarios-->
    <hr>
</div><!--termina Caja Comentar-->

<!-- Ventana emergente de Calificar puesto-->
<div id="EmergenteCalificar" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <footer class="modal-footer">
    <input type="button" name="calificar" Value = "Calificar" class="btn btn-primary" id="okwin01">    
  </footer>
</div> <!--fin ventana modal calificar -->

<!--Ventana modal Comentar -->
<div id="EmergenteComentar" class="modal hide fade dark" role="dialog" aria-labelledby="bgModalUpdate" aria-hidden="true">
  <header class="modal-header">
    <input type="button" Value = "x" class="close" data-dismiss="modal" onclick="javascript:borrarTexto();">     
    <h3>Comentar puesto <small>escribe un comentario</small></h3>
  </header>

  <div class="modal-body">
    <div class="alert alert-info">
      <input type="button" Value = "x" class="close" data-dismiss="alert" onclick="javascript:borrarTexto();">      
      Escribe un comentario en el campo de texto y da click en publicar o en otro caso cancelar.
    </div>

    <form action="../movimientos/AgregaComentario.jsp" method="post"> 
    <div class="form-group">
      <label for="texto">
      <textarea name = "texto" class="form-control" rows="5" id="comentario" placeholder="Escribe..."></textarea>
      </label> 
        <input type="button" name="cancelar" Value = "Cancelar" class="btn" id="closewin02" onclick="javascript:borrarTexto();">
        <input type ="submit" value="Publicar" class="btn btn-primary"  name="publicar">
    </div>
    </form>
  </div>
<!---->


  </div> <!-- Termina ventana modal comentar -->

</body>
</html>
