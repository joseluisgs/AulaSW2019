<%-- 
    Document   : navaron
    Created on : 26-feb-2019, 12:07:25
    Author     : link
--%>

<%-- 
    Document   : navbar
    Created on : 26-feb-2019, 10:38:15
    Author     : link
--%>

<!-- ¡Barra de navegacion -->
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Cliente Aula WS-JSP</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="principal.jsp">Inicio</a></li>
    </ul>
      <ul class="nav navbar-nav navbar-right">
          <% 
            // Recupero la sesion si existe
            HttpSession sesion=request.getSession();  
            if(sesion.getAttribute("nombre")!=null){
                out.println("<li><p class='navbar-text'>"+sesion.getAttribute("nombre")+"</p></li>");
            }
          %>
          <li><a href="tarjeta.jsp">Mi Tarjeta</a></li>
        <li><a href="salir.jsp"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
    </ul>
  </div>
</nav>
<br><br>
