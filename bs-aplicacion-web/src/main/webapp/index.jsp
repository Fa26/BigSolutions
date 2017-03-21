<%-- 
<<<<<<< 1cc4915cb5701449922e045e206c8b79282d392b
    Document   : index
    Created on : 20-mar-2017, 21:58:49
    Author     : FaVenegas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
=======
    Document   : resultados_consulta
    Created on : Mar 20, 2017, 9:00:00 PM
    Author     : Andres
--%>

>>>>>>> Caso de uso buscar
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
<<<<<<< 1cc4915cb5701449922e045e206c8b79282d392b
=======
        <h1>Food Ciencias</h1>
        <h2>Pagina principal</h2>
        
        <form action="resultados_consulta.jsp" method="post" style="text-align: center">
            Buscar puesto: <input type="text" name="puesto">
        <input type ="submit" value="Buscar">
        </form>
>>>>>>> Caso de uso buscar
        

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
  <li><a href="#contact">Ver Puesto Puesto</a></li><br>
  <li><a href="#about">Censurar Comentario</a></li><br>
  <li><a href="#coment">Comentar</a></li><br><br>
  <li><a href="#buscar">Buscar</a></li><br>
 </ul>
 </div>

 <div class="form letra">
 <form method="post">
        Nombre del Puesto: <br><br><input name="ingresatexto" type="text" placeholder="Nombre del puesto"/>

</form>
</div>
<hr>

<div class="p">
	<p>Propietario</p>
</div>
<div class="p2 letra">
<form method="post" action="action.php">
	Nombre: <input nombre="ingresatexto" type="text" placeholder="Nombre"/>
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	Apellido Matenro: <input nombre="ingresa" type="text" placeholder="Apellido Materno"/><br><br>
	Apellido Paterno: <input nombre="ingresatexto" type="text" placeholder="Apellido Paterno"/>
</form>
</div>
<hr>

<div class="p">
	<p>Comida</p>
</div>

<div class ="p2 letra">
<form method="post" action="action.php">
Tipo de Comida: <input nombre="tcomida" type="text" placeholder="Tipo de Comida"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Horario: <input nombre="tcomida" type="text" placeholder="Horario"/><br/><br/>
 <label for="descripcion">Menu: </label> <br/>
  <textarea name="menu" id="menu" cols="40" rows="5"></textarea><br><br>
  <label for="foto">Mi foto:</label><br>
  <input type="file" nombre="foto"/>
</form>
</div>
<br>
<hr>

<br/>
<button class="button p3" onclick="alert ('Tu puesto ha sido dado de alta!')">
	Listo!
</button>

<!--
<div class="posicion_img capa opacity">
<img src="logoCiBN3.jpg"  width="470" height="150" style="float:left">
</div>-->

<div class="capa opacity img2">
<img  src="img/logoCiBN3.jpg" width="300" height="86" style="float:left">
</div>
      <!--  <h1>Hello World!</h1>-->
    </body>
</html>
