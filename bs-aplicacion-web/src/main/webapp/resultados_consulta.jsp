<%-- 
    Document   : resultados_consulta
    Created on : Mar 20, 2017, 9:19:31 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Resultados</title>
        <link rel="stylesheet" type="text/css" href="css/layout.css" />
    </head>
    <body>
        <%
            String texto = request.getParameter("puesto");  
        %>
        <a href="index.jsp">Pagina principal</a>  
        <h2>Resultados</h2>
        <p>Aqui se despliegan los resultados de la consulta realizada con el 
            texto introducido por el usuario: "<%=texto%>"
        </p>
        
        </center>
        <br>
        <table class="gridtable">
            <tr>
                <th>Imagen</th>
                <th>Nombre</th>
                <th>Informacion</th> 
                <th>Calificacion</th>
            </tr>
            
            <tr>
                    <td> Imagen 1</td>
                    <td> Puesto 1</td>
                    <td> Informacion 1</td>
                    <td> Calificacion 1</td>
                    
            </tr>
            
            <tr>
                    <td> Imagen 2</td>
                    <td> Puesto 2</td>
                    <td> Informacion 2</td>
                    <td> Calificacion 2</td>
                    
            </tr>
        
        </table>
        
    </body>
</html>

<%--

<%
    String texto = request.getParameter("puesto");
%>
    <a href="../index.html">Pagina principal</a>
    <link rel="stylesheet" type="text/css" href="../css/layout.css" />
    <h2>Resultados Cliente</h2>
    
    <p>
        Aqui se despliegan los resultados de la consulta realizada con el 
            texto introducido por el usuario: <%=texto%>
    </p>

--%>


      
