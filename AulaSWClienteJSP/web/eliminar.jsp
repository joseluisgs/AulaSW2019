<%-- 
    Document   : eliminar
    Created on : 05-mar-2019, 19:27:02
    Author     : link
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="encabezado.jsp"%>
<%@include  file="navbaron.jsp"%>

<%    // Variables que voy a usar
    int clave = 0;
    String valor = "";
    int id = 0;
    int usuario_id = 0;
    String nombre = "";
    float nota = 0f;
    String sitio = "error_eliminar.jsp";
%>

<%
    // Sesión
    sesion = request.getSession();

    if (sesion.getAttribute("id") != null) {
        usuario_id = Integer.parseInt(sesion.getAttribute("id").toString());
    }
%>

<%
    // Procesamos el propio formulario Para validar la firma
    if (request.getParameterMap().containsKey("id") &&
            request.getParameterMap().containsKey("nombre")
            && request.getParameterMap().containsKey("nota")
            && request.getParameterMap().containsKey("clave")
            && request.getParameterMap().containsKey("valor")) {

        // Vamos a validarlo, recogiendo los parámetros por si g¡hubiesen cambiando, que no lo han hecho
        // Lo sé, pero lo hago en cualquier manera
        id = Integer.parseInt(request.getParameter("id"));
        nombre = request.getParameter("nombre");
        nota = Float.parseFloat(request.getParameter("nota"));
        clave = Integer.parseInt(request.getParameter("clave"));
        valor = request.getParameter("valor").toUpperCase();

        try {
            org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
            org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
            // TODO initialize WS operation arguments here
            // TODO process result here
            int result = port.validar(usuario_id, clave, valor);
            if (result == 1) {
                //out.println("VAMOS");

                // Eliminamos
                try {
                    //org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
                    //org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
                    // TODO initialize WS operation arguments here
                    //int id = 0;
                    //java.lang.String nombre = "";
                    //float nota = 0.0f;
                    // TODO process result here
                    out.println(usuario_id + " " + id);
                    result = port.eliminar(usuario_id, id);
                    if (result == 1) {
                        //out.println("OK");
                        String ok = "principal.jsp";
                        response.setStatus(response.SC_MOVED_TEMPORARILY);
                        response.setHeader("Location", ok);
                    } else {
                         //out.println("KO1");
                        response.setStatus(response.SC_MOVED_TEMPORARILY);
                        response.setHeader("Location", sitio);
                    }
                } catch (Exception ex) {
                    //out.println("KO2");
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", sitio);
                }

            } else {
                //out.println("KO3");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", sitio);
            }

        } catch (Exception ex) {
            //out.println("KO4");
            // TODO handle custom exceptions here
            request.getHeader("Referer");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", sitio);
        }

    }

%>

<%    

// Datos del formulario Si venimos de Proncipal
    if (request.getParameterMap().containsKey("id") &&
            request.getParameterMap().containsKey("nombre") &&
            request.getParameterMap().containsKey("nota")){
        id = Integer.parseInt(request.getParameter("id"));
        nombre = request.getParameter("nombre");
        nota = Float.parseFloat(request.getParameter("nota"));
    }

%>

<%-- start web service invocation --%>
<%        // Obtenemos la coordenada 
    try {
        org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
        org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
        // TODO initialize WS operation arguments here
        //int id = 0;
        // TODO process result here
        clave = port.firmar(usuario_id);
        //out.println("Result = "+result);
    } catch (Exception ex) {
        // TODO handle custom exceptions here
    }
%>
<%-- end web service invocation --%>



<div class="jumbotron">
    <h1 class="display text-center">Eliminar Alumno/a</h1>
</div>
<!-- Cuerpo de la página web -->
<div class="wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h2>Validación de firma</h2>
                </div>
                <!-- Formulario-->
                <form class="form" action="eliminar.jsp" method="post">
                    <div class="form-group">
                        <div class="form-group col-sm-1">
                            <label>ID:</label>
                            <input type="number" class="form-control" readonly placeholder=" <% out.println(id); %>">
                        </div>
                        <div class="form-group col-sm-4">
                            <label>Nombre:</label>
                            <input type="text" class="form-control" readonly placeholder=" <% out.println(nombre); %>">
                        </div>
                        <div class="form-group col-sm-2">
                            <label>    Nota:</label>
                            <input type="number" class="form-control" readonly placeholder=" <% out.println(nota); %>">
                        </div>
                        <div class="form-group col-sm-3">
                            <% out.println("<label> Posición de Tarjeta: " + clave + "</label>");%>
                            <input type="text" class="form-control" required name="valor" maxlength="4">
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <% out.println("<input type='hidden' name='id' value='" + id + "'>");%>
                        <% out.println("<input type='hidden' name='nombre' value='" + nombre + "'>");%>
                        <% out.println("<input type='hidden' name='nota' value='" + nota + "'>");%>
                        <% out.println("<input type='hidden' name='clave' value='" + clave + "'>");%>
                        <button type="submit" class="btn btn-primary mb-2"> <span class="glyphicon glyphicon-thumbs-up"></span>  Firmar</button>
                    </div> 
                </form>
            </div>
        </div>        
    </div>
</div>
<!-- Final de la página -->
<%@include  file="footer.jsp"%>

