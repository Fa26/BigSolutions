<<!doctype html>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<html lang="es-MX">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>Food Ciencias</title>
    
    <link rel="shortcut icon" href="http://vandelaydesign.com/favicon.ico">
    <link rel="icon" href="http://vandelaydesign.com/favicon.ico">
    <link rel="stylesheet" type="text/css" media="all" href="css/ventanaEmergente.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/informacion.css">

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/modals.js"></script>

  </head>

  <body>
    <!--Inicia informacion puesto-->
    <div id="Informacion" class="container center">
      <p>
        <span>
          <span class="row">
            <span class="col-4">
              <img src="imagenes/foodCiencias.jpg" width="350px" height="80px">
            </span>
          </span>
        </span>
        <span>
          <img src="imagenes/puesto.jpeg" align="right">
        </span>
        <span class="jumbotron">
          <h3><west>Informacion!</west></h3>
          <p>Menu 1</p>
          <p>Menu 2</p>
          <p>Menu 3</p>
          <p>Menu 4</p>
        </span>
        <br>
      </p>
    </div><!--fin información puesto-->
<br>
<br>
<div id="Comentar"> <!--Inicia Caja Comentar-->
  <!--botones-->
  <center>
    <input type="button" name="calificar" Value = "Calificar" href="#EmergenteCalificar" data-toggle="modal" class="btn btn-large">
    <input type="button" name="comentar" Value = "Comentar" href="#EmergenteComentar" data-toggle="modal" class="btn btn-large">
   <!-- <a href="#EmergenteCalificar" data-toggle="modal" class="btn btn-large">Calificar</a>
    <a href="#EmergenteComentar" data-toggle="modal" class="btn btn-large">Comentar</a>
    -->
  </center>
  <!--fin botones-->

  <br><br>
  <!--Pila de comentarios-->
    <h3><west>Comentarios!</west></h3>
    <ul id="comments" class="comments">
      <p id="as">Now what</p>
      <li class="comment">
	<div class="clearfix">
	  <h4 class="pull-left">John</h4>
	  <p class="pull-right">9:41 PM on August 24, 2013</p>
	</div>
	<p>
	  <em>I don't believe in astrology but still your writing style is really great!</em>
	</p>
      </li>

      <li class="comment clearfix">
	<div class="clearfix">
	  <h4 class="pull-left">John</h4>
	  <p class="pull-right">9:41 PM on August 24, 2013</p>
	</div>
	<p>
	  <em>I don't believe in astrology but still your writing style is really great!</em>
	</p>
      </li>
    </ul>

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

    <form action="ventanaInformacion.jsp" method="get"> 
    <div class="form-group">
      <label for="comment">Comentario:</label> 
      <textarea name = "texto" class="form-control" rows="5" id="comentario" placeholder="Escribe..."></textarea>
    </div>
    
 <%/*
   String texto = request.getParameter("texto");
    // Crear una  url con la direccion con el numero de puerto y el nombre de la bd 
    String connectionURL = "jdbc:mysql://localhost:8080/my_db";
    // Declarar una conexión mediante la interfaz de conección 
    Connection connection = null;
    // Declaramos el objeto de interfaz Statement que se usa para ejecutar instrucciones sql.
    PreparedStatement pstatement = null;
         //Cargar el controlador JBBC "com.mysql.jdbc.Driver"
     Class.forName("com.mysql.jdbc.Driver").newInstance();
          int updateQuery = 0;
     
       //  Revisar si el esto está vacío. 
   if(texto!=null){
       // Revisar si el testo tiene solo espacios en blanco.
       if(texto!="") {
                   try {
              // Crear una conexion mediante el metodo getConnection() que toma los parametros de tipo string de la conexion url, el texto para conectarse a la base de datos.
              connection = DriverManager.getConnection
              (connectionURL, "root", "root");
              // Consulta sql para insertar el valor especificado en la tabla.
              String queryString = "INSERT INTO Comentario(nIdComentario,fecha, texto, nIdPuesto, nIdUsuario) VALUES (?, ?, ?, ?, ?)";
              //createStatement() es usado para crear una instruccion de objeto que es usado para enviar instrucciones sql  a la base de datos especificado. 
              pstatement = connection.prepareStatement(queryString);
              pstatement.setInt(1, 1);
              var d = new Date();
              var f = d.getFullYear()+"/ " + d.getMonth() +"/ "+ d.getDay();
              //document.getElementById("demo").innerHTML = f;
              pstatement.setString(2, "f");
              pstatement.setString(3, texto);
              pstatement.setInt(4, 1);
              pstatement.setInt(5, 1);
              updateQuery = pstatement.executeUpdate();
               if (updateQuery != 0) {**/ %>
             <br>
             <TABLE style="background-color: #E3E4FA;" 
                   WIDTH="30%" border="1">
          <tr><th>El dato fue insertado.</th></tr>
       </table>
              <%/*
              }
            } 
            catch (Exception ex) {
            out.println("Unable to connect to batabase.");
   
               }
            finally {
                // close all the connections.
                pstatement.close();
                connection.close();
            }
    }
  }*/
  %>        
    </form>
<!---->

    <footer class="modal-footer">
      <!--<a href="#" class="btn" id="closewin02">Cancelar</a>-->
      <input type="button" name="cancelar" Value = "Cancelar" class="btn" id="closewin02" onclick="javascript:borrarTexto();">
      <input type="button" name="publicar" Value = "Publicar" class="btn btn-primary" id="okwin02" onclick="getwords();">
     <!-- <a href="#" class="btn btn-primary" id="okwin02">publicar</a>-->
    </footer>

  </div> <!-- Termina ventana modal comentar -->

</body>
</html>
