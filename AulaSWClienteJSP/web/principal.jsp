<%-- 
    Document   : principal
    Created on : 26-feb-2019, 12:07:00
    Author     : link
--%>

<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="encabezado.jsp"%>
<%@include  file="navbaron.jsp"%>
<%    sesion = request.getSession();
    int id = 0;
    if (sesion.getAttribute("id") != null) {
        id = Integer.parseInt(sesion.getAttribute("id").toString());
    }
%>
<!-- Comenzamos a programar cada sección --> 
<div class="jumbotron">
    <h1 class="display text-center">Aula SW</h1>
</div>

<div class="wrapper">
    <div class="container-fluid">
        <div class="row no-print nover">
            <div class="col-md-12">
                <form class="form-inline" action="calificar.jsp" method="post">
                    <div class="form-group">
                        <label for="usuario" class="sr-only">Nombre:</label> 

                        <input type="text" class="form-control" id="buscar" name="nombre" placeholder="Nombre de Alumno/a">
                        <label for="usuario" class="sr-only">Nota:</label>
                        <input type="number" class="form-control" id="buscar" name="nota" max="10" min="0" step="0.05" placeholder="Nota">
                    </div>
                    <button type="submit" class="btn btn-primary mb-2"> <span class="glyphicon glyphicon-pencil"></span>  Calificar</button>
                </form>
            </div>
        </div>  
    <div class="page-header">
        <h2>Estadísticas:</h2>
    <%-- start web service invocation --%>
    <%
    try {
	org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
	org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
	 // TODO initialize WS operation arguments here
	//int id = 0;
	// TODO process result here
	java.lang.String result = port.estadisticas(id);
	//out.println("Result = "+result);
        // Procesamos el JSON
        JsonParser parser = new JsonParser();
        JsonObject jO = parser.parse(result).getAsJsonObject();
         
        out.println("<li>Total: "+jO.get("total").getAsInt()+"</li>");
        out.println("<li>Aprobados: "+jO.get("aprobados").getAsInt()+" - "+jO.get("aprobados100").getAsFloat()+"% </li>");
        out.println("<li>Suspensos: "+jO.get("suspensos").getAsInt()+" - "+jO.get("suspensos100").getAsFloat()+"% </li>");
        out.println("<li>Media de Nota: "+jO.get("media").getAsFloat()+"</li>");
         
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%>
    </div>
        

        <%-- start web service invocation --%>
        <%
            try {
                org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
                org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
                // TODO initialize WS operation arguments here
                //int id = 9;
                // TODO process result here
                java.lang.String result = port.listar(id);
                //out.println("Result = " + result);
                // Procesamos JSON
                JsonParser parser = new JsonParser();
                JsonArray gsonArr = parser.parse(result).getAsJsonArray();

                if (gsonArr.size() != 0) {
                    out.println("<h2>Listado:</h2>");
                    out.println("<table class='table table-bordered table-striped'>");
                    out.println("<thead>");
                        out.println("<tr>");
                            out.println("<td>Nº</td>");
                            out.println("<td>Nombre</td>");
                            out.println("<td>Nota</td>");
                            out.println("<td class='text-center no-print nover'>Acción</td>");
                        out.println("</tr>");
                    out.println("</thead>");
                        out.println("<tbody>");
                        // Para cada elemento
                        for (JsonElement obj : gsonArr) {
                            JsonObject gsonObj = obj.getAsJsonObject();
                            out.println("<tr>");
                                 out.println("<td>"+gsonObj.get("id").getAsInt()+"</td>");
                                 out.println("<td>"+gsonObj.get("nombre").getAsString()+"</td>");
                                 out.println("<td>"+gsonObj.get("nota").getAsFloat()+"</td>");
                                 out.println("<td class='text-center no-print nover'>"+
                                        "<form action='eliminar.jsp' method='post'>"+
                                        "<button class='btn btn-danger' type='submit' title='Borar Producto' data-toggle='tooltip'"+
                                        "onclick='return confirm('¿Seguro que desea borrar a este producto?')'>"+
                                        "<span class='glyphicon glyphicon-trash'></span>"+
                                        "</button>");
                                out.println("<input type='hidden' name='id' value='" + gsonObj.get("id").getAsInt() + "'>");
                                out.println("<input type='hidden' name='nombre' value='" + gsonObj.get("nombre").getAsString() + "'>");
                                out.println("<input type='hidden' name='nota' value='" + gsonObj.get("nota").getAsFloat() + "'>");
                                out.println("</form></td>");
                                      
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                    out.println("</table>");
                } else {
                    out.println("<p class='lead'><em>No se ha encontrado datos de usuarios/as.</em></p>");
                }

            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
        <%-- end web service invocation --%>

        <div class="row no-print nover">
            <div class="col-xs-12">
               <a class="btn btn-success pull-right" href="#" style= "margin-right: 5px" title="Imprimir" onclick="window.print()" data-toggle='tooltip'><span class='glyphicon glyphicon-print'></span> Imprimir</a>
            </div>
        </div>
    </div>
       
</div>

        

<br><br>
<%                    // Recupero la sesion si existe

    SimpleDateFormat formateador = new SimpleDateFormat("dd'/'MM'/'yyyy 'a las' H':'mm':'s", new Locale("es_ES"));
    Date fechaDate = new Date(sesion.getAttribute("momento").toString());
    out.println("<h6>Conectado como: " + sesion.getAttribute("nombre") + " - Acceso: " + formateador.format(fechaDate) + "</h6>");

%>
<br>
<!-- Final de la página -->
<%@include  file="footer.jsp"%>
