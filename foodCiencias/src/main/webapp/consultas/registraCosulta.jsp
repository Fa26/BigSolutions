<%-- 
    Document   : registraCosulta
    Created on : 18-abr-2017, 23:18:58
    Author     : FaVenegas
--%>

<%@page import="control.Puesto"%>
<%@page import="datos.ConexionBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
             String nombreP=request.getParameter("nombre");
             String hora_A=request.getParameter("hora_apertura");
             String hora_C=request.getParameter("hora_cierre");
             String tipoComida=request.getParameter("tipo_comida");
             String nombreD=request.getParameter("nom_duenio");
             String Apm=request.getParameter("app_duenio");
             String App=request.getParameter("apm_duenio");
            String foto=request.getParameter("foto");
            
            Puesto p = new Puesto();
            ConexionBD c = new ConexionBD();
            p.conecta();
            p.registrarPuestos(nombreP,hora_A,hora_C,tipoComida,nombreD,
                    Apm,App,foto);
            p.desconecta();
            %>
            
          
            <script type="text/javascript">
            window.location="../AdministradorV/PuestoIH.html";
            </script>
    </body>
</html>
