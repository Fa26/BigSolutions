<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html>
    <head>
        <title>Food Ciencias</title>
        <!--En esta seccion agregamos los estilos, javascript, y el framwork de boostrap -->
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="script.js"></script>
        <meta charset="utf-8">

    </head>
    <body>
        <!--Esta seccion es la cabecera de la pagina y se encuentran estructurado por el sistema de rejillas donde cada rejilla consta de 4 lugares, donde acomodamos la imgagen, y los botones -->
    <header>
        <div>
            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="row">
                    <div class="3">
                        <a class="navbar-brand" href="#">
                            <img class="food" src="imagenes/foodCiencias.jpg" width="288" height="33">
                        </a>
                    </div>
                    <div class="busc">
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <input  type="text" class="form-control" placeholder="Buscar...">
                            </div>
                            <button  type="submit" class="btn btn-success">Entrar</button>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">Regitrate!!!</button>
                    </div>
                    </form>
                </div>
            </nav>
        </div>

        <div>

            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                <div class="modal-dialog"  role="document">
                    <div class="modal-content">
                        <div class="encabezado" class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h3 class="modal-title" id="exampleModalLabel"></h3>
                            <img class="Ciencia" src="imagenes/foodCiencias.jpg">
                        </div>
                        <div class="modal-body">
                            <form action="UsuarioC" method="processRequest"  action="UsuarioC">
                                <div class="form-group">
                                    <label for="exampleInputName2">Nombre</label>
                                    <input type="text" class="form-control" id="Nombre" placeholder="Nombre">
                                    <label for="exampleInputName2">Ap Paterno</label>
                                    <input type="text" class="form-control" id="Paterno" placeholder="Apellido Paterno">
                                </div>
                                <br>
                                <br>
                                <div class="form-group">
                                    <label for="exampleInputName2">Ap Materno</label>
                                    <input type="text" class="form-control" id="Materno" placeholder="Apellido Materno">

                                    <label for="exampleInputEmail2">Correo</label>
                                    <input type="email" class="form-control" id="Correo" placeholder="Correo-Electronico">
                                </div>
                                <br><br>
                                <div class="form-group">
                                    <label for="exampleInputName2">Contraseña</label>
                                    <input type="password" class="form-control" id="contra" placeholder="Contraseña">
                                </div>
                                <div class="form-group">
                                    <button type="button" class="btn btn-primary">Subir Foto</button>
                                </div>
                                <div class="modal-footer">
                                    <button class="button" onclick="alert('Tu puesto ha sido dado de alta!')" type="submit">
                                        Enviar!
                                    </button>
                                </div>
                            </form>
                        </div>
                       
                    </div>
                </div>				
            </div>

    </header>
    <!--Esta seccion es la de sugerencias utilizamos un div para que se pusiera a la izquierda de la pantalla y la app de jumbotron de boostrap para que tuviera la margen gris, del lado derecho insertamos el mapa de google con un iframe -->
    <br>
    <br>
    <br>
    <div class="lug" class="row">
        <div class="col-md-5">
            <div class="jumbotron">
                <h3><center>Sugerencias!</center></h3>
                <p>  Lugar 1</p>

                <p>   Lugar 2</p>

                <p>  Lugar 3</p>

                <p>  Lugar 4</p>			
            </div>
        </div>
        <div class="col-md-7">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3765.054246151638!2d-99.18183038654796!3d19.32345224917234!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x85ce000fdd96288f%3A0x1096af9b5b03d38d!2sFacultad+de+Ciencias%2C+UNAM!5e0!3m2!1ses-419!2smx!4v1490063963728" width="600" height="450" frameborder="0" style="border:0" allowfullscreen>
            </iframe>		
        </div>
    </div>

    <script src="js/bootstrap.min.js"></script>
</body>
</html>