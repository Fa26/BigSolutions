<<<<<<< c71fdcd4b059559d9a77b6b98d3bfb4d7e01f2eb
<%-- 
    Document   : index
    Created on : 20-mar-2017, 21:58:49
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
        <img src="imagenes/foodCiencias.jpg" width="200" height="50"/> 
        <h2>Pagina principal</h2>
        
        <form action="resultados_consulta.jsp" method="post" style="text-align: center">
            Buscar puesto: <input type="text" name="puesto">
        <input type ="submit" value="Buscar">
        </form>

        

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
=======
<!DOCTYPE html>
<html>
<head>
	<title>Food Ciencias</title>
	<!--En esta seccion agregamos los estilod, javascript, y el framwork de boostrap -->
	<link rel="stylesheet" type="text/css" href="estilos.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="jquery.min.js"></script>
	<script type="text/javascript" src="script.js"></script>
</head>
<body>
<!--Esta seccion es la cabecera de la pagina y se encuentran estructurado por el sistema de rejillas donde cada rejilla consta de 4 lugares, donde acomodamos la imgagen, y los botones -->
<header>
	<div>
		<div class="row">
			<div class="col-4">
				<img src="imagenes/foodCiencias.jpg" width="350px" height="80px">
			</div>
 			<div class="col-4">
 				<div  id="barra" class="input-group">
      				<span class="input-group-btn">
        				<button class="btn btn-default" type="button" >Buscar</button>
     				 </span>
     				 <input type="text" class="form-control" placeholder="Busca...">
   				 </div>
 			</div>
 			<div class="col-1">
 				<button id="boton1" type="button" class="btn btn-primary">Entrar!!!!</button>
 			</div>
			<div class="col-1">
				<button id="boton2" type="button" class="btn btn-danger">Registrarse</button>
			</div>
		</div>
	</div>
</header>
<!--Esta seccion es la de sugerencias utilizamos un div para que se pusiera a la izquierda de la pantalla y la app de jumbotron de boostrap para que tuviera la margen gris, del lado derecho insertamos el mapa de google con un iframe -->
<div class="row">
	<div class="col-5">
		<div class="jumbotron">
  			<h3><center>Sugerencias!</center></h3>
  			<p>Lugar 1</p>
  			
  			<p>Lugar 2</p>
  			
  			<p>Lugar 3</p>
  			
  			<p>Lugar 4</p>
	</div>
  		
		</div>
			<div class="col-6">
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3765.054246151638!2d-99.18183038654796!3d19.32345224917234!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x85ce000fdd96288f%3A0x1096af9b5b03d38d!2sFacultad+de+Ciencias%2C+UNAM!5e0!3m2!1ses-419!2smx!4v1490063963728" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
			</div>
</div>
</body>
>>>>>>> Prototipo de pagina principal
</html>
