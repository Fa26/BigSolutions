<%-- 
    Document   : AgregaComentario
    Created on : 20/04/2017, 09:56:39 AM
    Author     : mint
--%>
<%@page import="java.sql.Date"%>
<%@page import="com.palemon.proyecto.controlador.Comentario"%>
<%
    String comentario = request.getParameter("texto");

    Comentario c = new Comentario();

    int b = 0;
    c.conecta();
    b = c.insertarComentario(comentario);
    c.desconecta();
    
    %>
    <a href="../index.html">Inicio</a>
    <br>
    <center>
    <%
    
    if(b == 1){
        System.err.println("b1 : " + b);
        out.write("Comentario registrada");
        int nIdComentario = c.getnIdComentario();
        Date fecha = c.getFecha();
        String texto = c.getTexto();
        int nIdPuesto = c.getnIdPuesto();
        int nIdUsuario = c.getnIdUsuario();

        %>
    </center>
        <br>
        <table>
            <tr>
                <th>nIdComentario</th>
                <th>fecha</th> 
                <th>texto</th>
                <th>nIdPuesto</th>
                <th>nIdUsuario</th>
            </tr>
            
            <tr>
                    <td> <%=nIdComentario%></td>
                    <td> <%=fecha%></td>
                    <td><%=texto%> </td>
                    <td><%=nIdPuesto%> </td>
                    <td><%=nIdUsuario%> </td>
            </tr>
        
        <%
    }else{
        out.write("No se registró el comentario.");
    }
%>
        </table>