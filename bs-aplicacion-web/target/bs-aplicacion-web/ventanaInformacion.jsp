<!DOCTYPE html>
<html>
<head>
	<title>Food Ciencias</title>
	<link rel="stylesheet" type="text/css" href="My-styles.css">

   	<meta charset="UTF-8">
 <!-- Ventanas Pop up -->
	<!--<script>
	function popUp(URL) {
	day = new Date();
	id = day.getTime();
	eval(&quot;page&quot; + id + &quot; = window.open(URL, &#39;&quot; + id + &quot;&#39;, &#39;toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=0,width=600,height=400,left=212,top=184&#39;);&quot;);
	}
</script>-->
 <!-- Ventanas Pop up -->
<script type="text/javascript">
function openDialog() {
    $('#overlay').fadeIn('fast', function() {
        $('#popup').css('display','block');
        $('#popup').animate({'left':'30%'},500);
    });
}

function closeDialog(id) {
    $('#'+id).css('position','absolute');
    $('#'+id).animate({'left':'-100%'}, 500, function() {
        $('#'+id).css('position','fixed');
        $('#'+id).css('left','100%');
        $('#overlay').fadeOut('fast');
    });
}
</script>
</head>

<body>
	<div>
	<header>
	<span>
		<span class="row">
		<span class="col-4">
				<img src="imagenes/foodCiencias.jpg" width="350px" height="80px">
		</span>
 		</span>
	</span>
	<span>
		<span>
		<p> 
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
		</p>
  		</span>	
		<span>
		<!--
 			<button class="btn btn-default" type="button" >Comentar</button>
 			<a href="javascript:popUp('URL del documento')">Abrir ventana PopUp</a>
 			<form>
			<input type=button value="Abrir ventana PopUp" onClick="javascript:popUp('/home/kaskuj/Escritorio/2017-2/I.S/Proyecto/BigSolutions/bs-aplicacion-web/src/main/webapp')">
			</form>
			-->
		 	<button class="btn btn-default" type="button" >Comentar</button>
		</span>   			
  		<br>
  		<br>
		
 	</span>
	</header>
	<br>
</body>
</html>