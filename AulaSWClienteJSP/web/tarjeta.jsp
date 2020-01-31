<%-- 
    Document   : tarjeta
    Created on : 27-feb-2019, 17:45:56
    Author     : link
--%>

<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonParser"%>
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
    <h1 class="display text-center">Tarjeta de Coordenadas</h1>
</div>

<div class="wrapper">
    <div class="container-fluid">
        <div class="row no-print">
            <div class="col-md-12">
                    <%-- start web service invocation --%>
                    <%
                    try {
                        org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
                        org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
                         // TODO initialize WS operation arguments here
                        //int id = 0;
                        // TODO process result here
                        java.lang.String result = port.tarjeta(id);
                        //out.println("Result = "+result);
                        // Procesamos JSON
                        JsonParser parser = new JsonParser();
                        JsonArray gsonArr = parser.parse(result).getAsJsonArray();
                        if (gsonArr.size() != 0) {
                    //out.println("<h2>Mi Tarjeta de Coordenadas:</h2>");
                    out.println("<table class='table table-bordered table-striped'>");
                    out.println("<thead>");
                        out.println("<tr>");
                            out.println("<td>Posición</td>");
                            out.println("<td>Valor</td>");
                        out.println("</tr>");
                    out.println("</thead>");
                        out.println("<tbody>");
                        // Para cada elemento
                        for (JsonElement obj : gsonArr) {
                            JsonObject gsonObj = obj.getAsJsonObject();
                            out.println("<tr>");
                                 out.println("<td>"+gsonObj.get("clave").getAsInt()+"</td>");
                                 out.println("<td>"+gsonObj.get("valor").getAsString()+"</td>");
                            out.println("</tr>");
                        }
                        out.println("</tbody>");
                    out.println("</table>");
                } else {
                    out.println("<p class='lead'><em>No se ha encontrado datos de tarjeta.</em></p>");
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
    </div>
</div>



<br><br>
<!-- Final de la página -->
<%@include  file="footer.jsp"%>
