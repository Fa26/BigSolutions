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
                                    <form action="resultados_consulta.jsp">
                                          <input type="text" class="form-control" placeholder="Busca...">                                                  
                                        <input type="submit" value="Buscar" >
                                    </form>
     				
   				</span> 
                                </div>
 			</div>
 			<div class="col-1">
                            <form action="index1.jsp">                                                   
                                 <input type="submit" value="Entrar" >
                            </form> 
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
</html>
