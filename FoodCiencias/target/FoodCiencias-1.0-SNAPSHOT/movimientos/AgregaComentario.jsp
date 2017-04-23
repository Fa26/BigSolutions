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
    <a href="../consultas/VentanaComentario.jsp">ver comentarios</a>
    <br>
    
    <%
    
    if(b == 1){
        System.err.println("b1 : " + b);
        out.write("Comentario registrada");

        %>

        <%
    }else{
        out.write("No se registró el comentario.");
    }
%>
 <!--  <SCRIPT LANGUAGE=javascript>
       document.write("Redireccionando...");
    setTimeout("window.history.go(-1)",5000); // 5000 milisegundos de retardo
</SCRIPT>
 -->