<%-- 
    Document   : index.jsp
    Created on : 26-feb-2019, 10:36:22
    Author     : link
--%>
<% 
            // Recupero la sesion si existe
            HttpSession sesion=request.getSession();  
            if(sesion.getAttribute("nombre")!=null){
              response.sendRedirect("principal.jsp");
            }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="encabezado.jsp"%>
<%@include  file="navbar.jsp"%>
<!-- Comenzamos a programar cada sección --> 
<div class="jumbotron">
  <h1 class="display text-center">Cliente AULA SW Cliente JSP</h1>
  <p class="lead text-center">Cliente JSP para la calificación de alumnos</p>
</div>


<br><br>
<!-- Final de la página -->
<%@include  file="footer.jsp"%>

