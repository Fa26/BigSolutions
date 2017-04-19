


<%@page import="java.util.ArrayList"%>
<%@page import="control.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Registrar Persona</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
    </head>
    <body>
        
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="../index.html">Regresar al Inicio</a>
                </div>
            </div>
        </nav>
        
        <div class="jumbotron">
            <div class="container" style="height:50px">
                <h1 align="center">Registro</h1>
            </div>
        </div>

<% 
    
    String nombre = request.getParameter("nombre");
    String app = request.getParameter("app");
    String apm = request.getParameter("apm");
    String correo = request.getParameter("correo");
    String contra = request.getParameter("contra");
    
    String  es = "Usuario Registrada correctamente <br> nombre: " + nombre + " " + app + " " + apm + "<br> Correo: " +correo
                    +"<br> contraseña: " + contra ;
    
    ArrayList<String> Usuarios = new ArrayList<String>();
    Usuario us = new Usuario();
    us.conecta();
    Usuarios = us.registrarPersona(nombre,app,apm,correo,contra);
    us.desconecta();
    if(Usuarios.size() > 0){
        for(String a: Usuarios)
            out.write(a + "<br>");
    }else{
        out.write("No se registro");
        out.write("es la cadena "+ es);
    } 
%>

        <script src="../js/jquery-3.1.1.min.js"></script>        
        <script src="../js/bootstrap.min.js"></script>
                
    </body>
</html>