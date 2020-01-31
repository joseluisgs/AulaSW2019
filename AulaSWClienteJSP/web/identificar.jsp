<%-- 
    Document   : identificar
    Created on : 26-feb-2019, 10:46:52
    Author     : link
--%>

<%@page import="com.google.gson.JsonParser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="encabezado.jsp"%>
<%@include  file="navbar.jsp"%>
<!-- Comenzamos a programar cada sección --> 
<%@ page import="utilidad.Utilidad"%>
<%
    // Procesamos el formulario
    // Si existen los parámetros vía POST
    if (request.getParameterMap().containsKey("email")
            && request.getParameterMap().containsKey("password")) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //out.println(nombre + email + password);
        Utilidad u = Utilidad.getUtilidad();
        password = u.getHash(password);

        // Llamamos al servicio de insertar.
        // start web service invocation
        try {
            org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
            org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
            // TODO initialize WS operation arguments here
            // TODO process result here
            int result = port.indetificar(email, password);
            //out.println("Result = "+result);
            if (result > 1) {
                // Vamos a meter al usuario en la sesión
                try {
                    // TODO initialize WS operation arguments here
                    int id = result;
                    // TODO process result here
                    // Llamo al servicio
                    java.lang.String json = port.usuario(id);
                    
                    // Parseamos sus resultados
                    JsonParser parser = new JsonParser();
                    String nombre = parser.parse(json).getAsJsonObject().get("nombre").getAsString();
                    email = parser.parse(json).getAsJsonObject().get("email").getAsString();
                    password = parser.parse(json).getAsJsonObject().get("password").getAsString();
                    String momento = parser.parse(json).getAsJsonObject().get("momento").getAsString();
                    //out.println(id + nombre + email + password + momento);
                    
                    // Nos guardamos en la sesion
                    HttpSession sesion=request.getSession();  
                    sesion.setAttribute("id",id);
                    sesion.setAttribute("nombre",nombre); 
                    sesion.setAttribute("email",email); 
                    sesion.setAttribute("momento",momento); 
                    
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
                // Nos movemos a una nueva dirección, que somos nosotros mismos
                //String sitio = "principal.jsp"; //request.getHeader("Referer");
                //response.setStatus(response.SC_MOVED_TEMPORARILY);
                //response.setHeader("Location", sitio);
                // Otra forma de ir
                response.sendRedirect("principal.jsp");
            } else {
                 // Nos movemos a una nueva dirección, que somos nosotros mismos
                String sitio = "error_identificacion.jsp"; //request.getHeader("Referer");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", sitio);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            // Nos movemos a una nueva dirección, que somos nosotros mismos
                String sitio = "error_identificacion.jsp"; //request.getHeader("Referer");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", sitio);
        }
    }

%>    
<div class="wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h2>Identificación de Usuario/a:</h2>
                </div>
                <!-- Formulario-->
                <form action="identificar.jsp" method="post">
                    <!-- Nombre-->
                    <div class="form-group">
                        <label>Email:</label>
                        <input type="email" required name="email" class="form-control">
                    </div>
                    <!-- Contraseña -->
                    <div class="form-group">
                        <label>Contraseña:</label>
                        <input type="password" required name="password" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-primary"> <span class="glyphicon glyphicon-log-in"></span>  Entrar</button>
                    <a href="index.jsp" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Cancelar</a>
                </form>
            </div>
        </div>        
    </div>
</div>

<br><br>
<!-- Final de la página -->
<%@include  file="footer.jsp"%>