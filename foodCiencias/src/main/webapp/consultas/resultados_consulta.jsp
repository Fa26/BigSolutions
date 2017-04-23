<%-- 
    Document   : resultados_consulta
    Created on : Mar 20, 2017, 9:19:31 PM
    Author     : Andres
--%>

<%@page import="control.Puesto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Resultados</title>
        <link rel="stylesheet" type="text/css" href="../css/layout.css" />
    </head>
    <body>
        <%
            String texto = request.getParameter("puesto");  
        %>
        <a href="../index.html">Pagina principal</a>  
        <h2>Resultados</h2>
        <%            
            Puesto p = new Puesto();
            ArrayList puestos = new ArrayList();
            
            p.conecta();
            puestos = p.buscarPuestos(texto);
            p.desconecta();
            
            if (puestos.size() > 0) {
                
        %>
        </center>
        <br>
        <table class="gridtable">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Duenio</th> 
                <th>Tipo de Comida</th>
            </tr>
            <%
                for (int i = 0; i < puestos.size(); i++) {
                    int id = ((Puesto) puestos.get(i)).getId();
                    String nombre = ((Puesto) puestos.get(i)).getNombrePuesto();
                    String duenio = ((Puesto) puestos.get(i)).getDuenioPuesto();
                    String tipoComida = ((Puesto) puestos.get(i)).getTipoComida();
                    //out.write(id + " | " + nombre + " | " + sucursal + " | " + fecha + " | " + rfc 
                    //        + " | " + activo + " | " + tipoEmpleado + "<br>");
                    %>
                    <tr>
                    <td> <%=id%></td>
                    <td> <%=nombre%></td>
                    <td><%=duenio%> </td>
                    <td> <%=tipoComida%></td>
                    </tr>
                    <%
                }
            } else {
                out.write("No se pudo encontrar ningun puesto con: " + texto);
            }
        %>
        </table>
        
    </body>
</html>
