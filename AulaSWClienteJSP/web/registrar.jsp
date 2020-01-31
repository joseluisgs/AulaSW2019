<%-- 
    Document   : registrar
    Created on : 26-feb-2019, 10:46:14
    Author     : link
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="encabezado.jsp"%>
<%@include  file="navbar.jsp"%>

<%@ page import="utilidad.Utilidad"%>
<%
    // Procesamos el formulario
    // Si existen los parámetros vía POST
    if (request.getParameterMap().containsKey("nombre")
            && request.getParameterMap().containsKey("email")
            && request.getParameterMap().containsKey("password")) {

        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //out.println(nombre + email + password);
        Utilidad u = Utilidad.getUtilidad();
        password = u.getHash(password);
        //out.println(password);

        // Llamamos al servicio de insertar.
        // start web service invocation
        try {
            org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
            org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
            // TODO initialize WS operation arguments here
            //java.lang.String nombre = "";
            //java.lang.String email = "";
            //java.lang.String password = "";
            // TODO process result here
            int result = port.registrar(nombre, email, password);
            //out.println("Result = "+result);
            if (result == 1) {
                // Nos movemos a una nueva dirección, que somos nosotros mismos
                String sitio = "identificar.jsp"; //request.getHeader("Referer");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", sitio);
            } else {
                 // Nos movemos a una nueva dirección, que somos nosotros mismos
                String sitio = "error_registro.jsp"; //request.getHeader("Referer");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", sitio);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            // Nos movemos a una nueva dirección, que somos nosotros mismos
                String sitio = "error_registro.jsp"; //request.getHeader("Referer");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", sitio);
        }
        // end web service invocation

    }

%>

<!-- Cuerpo de la página web -->
<div class="wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h2>Registro de usuario/a:</h2>
                </div>
                <p>Por favor rellene este formulario para poder comprar en la tienda.</p>
                <!-- Formulario-->
                <form action="registrar.jsp" method="post">
                    <!-- Nombre-->
                    <div class="form-group">
                        <label>Nombre:</label>
                        <input type="text" required name="nombre" class="form-control" value="">
                    </div>
                    <!-- Email -->
                    <div class="form-group">
                        <label>E-Mail:</label>
                        <input type="email" required name="email" class="form-control" value="">
                    </div>
                    <!-- Password -->
                    <div class="form-group">
                        <label>Password:</label>
                        <input type="password" required name="password" class="form-control" value="">
                    </div>
                    <button type="submit" class="btn btn-primary"> <span class="glyphicon glyphicon-ok"></span>  Aceptar</button>
                    <a href="index.jsp" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Cancelar</a>
                </form>
            </div>
        </div>        
    </div>
</div>

<br><br>
<!-- Final de la página -->
<%@include  file="footer.jsp"%>

