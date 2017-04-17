<%-- 
    Document   : FPuestos
    Created on : 03-abr-2017, 16:52:08
    Author     : FaVenegas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--Archivo externo de css-->
        <link rel="stylesheet" type="text/css" href="css/stilo.css">
        <!--Imagen de pestaña-->
        <link rel="shortcut icon" href="img/GrisU.jpg" type="image/jpg" />
        <title>AdministradorIH</title>
    </head>
    <body>
        

<div class="icon-bar">
  <a href="#"><i class="fa fa-user-circle-o"></i></a><br><br>
  <a  href="#"><i class="fa fa-calendar"></i></a> <br><br>
  <a href="#"><i class="fa fa-envelope"></i></a><br><br><br><br>
  <a href="#"><i class="fa fa-bar-chart-o"></i></a><br><br><br>
  <br>
  <a href="#"><i class="fa fa-cogs"></i></a><br><br><br>
</div>

 <div class="menu">
<ul>
  <li><a href="#home">Salir</a></li>
  <li><a class="active"href="#news">Registrar Puesto</a></li>
  <li><a href="#contact">Ver Puesto</a></li><br>
  <li><a href="#about">Censurar Comentario</a></li><br>
  <li><a href="#coment">Comentar</a></li><br><br>
  <li><a href="#buscar">Buscar</a></li><br>
 </ul>
 </div>

 <div class="form letra">
 <form  action="PuestoC" method="processRequest" action="PuestoC">
        Nombre del Puesto: <br><br><input name="nombre" type="text" placeholder="Nombre del puesto"/>

 </div>
        <hr>
        <div class="p">
	<p>Puesto</p>
        </div>
       <div class="p2 letra">
            	Hora de Apertura: <input name="hora_apertura" type="text" placeholder="Hora de apertura"/>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Hora de Cierre: <input name="hora_cierre" type="text" placeholder="cierre"/><br><br>
                Tipo de comida: <input name="tipo_comida" type="text" placeholder="tipo de comida"/><br><br>
                                       
                
        </div>
        <hr>
        
       <div class="p">
            <p>Propietario</p>
       </div>
        <div class ="p2 letra">
            Nombre: <input name="nom_duenio" type="text" placeholder="nombre dueño"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            Apellido Paterno: <input name="app_duenio" type="text" placeholder="Apellido Paterno"/><br/><br/>
            Apellido Materno: <input name="apm_duenio" type="text" placeholder="Apellido Materno"/><br/><br/>
            <label for="foto">Mi foto:</label><br/>
            <input type="file" name="foto"/>
            <br/><br/><br/><br/>
        
           
            <button class="button" onclick="alert ('Tu puesto ha sido dado de alta!')" type="submit">
            Listo!
            </button>
            </div>
</form>
    <hr>
<div class="capa opacity img3">
<img  src="img/logoCiBN3.jpg" width="300" height="86" style="float:left">
</div>
      
    </body>
</html>