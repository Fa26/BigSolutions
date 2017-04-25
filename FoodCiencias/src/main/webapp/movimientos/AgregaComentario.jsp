<%-- 
    Document   : AgregaComentario
    Created on : 20/04/2017, 09:56:39 AM
    Author     : mint
--%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="control.Comentario"%>
<a href="../consultas/VentanaComentario.jsp">ver comentarios</a>
<%
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

// Get the date today using Calendar object.
    Date today = Calendar.getInstance().getTime();        
    
    String fecha = df.format(today);
    String comentario = request.getParameter("texto");
   
    System.out.print(fecha);
    Comentario c = new Comentario();
    
    int b = 0;
    if( comentario != ""){
        c.conecta();
        b = c.insertarComentario(fecha, comentario);
        c.desconecta();
    }else{
        out.write("Por favor ingresa un texto");

    }
    %>
    <br>
    
    <%
    if(b == 1){
        System.err.println("b1 : " + b);
        out.write("Comentario registrada");

        %>

        <%
    }else{
        System.out.print("fecha "+fecha);
        out.write("No se registró el comentario.");
    }
%>
 <!--  <SCRIPT LANGUAGE=javascript>
       document.write("Redireccionando...");
    setTimeout("window.history.go(-1)",5000); // 5000 milisegundos de retardo
</SCRIPT>
 -->