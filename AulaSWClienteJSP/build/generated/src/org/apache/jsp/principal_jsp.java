package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class principal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/encabezado.jsp");
    _jspx_dependants.add("/navbaron.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Cliente Aula WS-JSP v1.1 2DAM/DAW</title>\n");
      out.write("        <!--\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilos.css\">\n");
      out.write("        <script src=\"script/jquery.min.js\"></script>\n");
      out.write("        <script src=\"script/bootstrap.js\"></script>\n");
      out.write("        -->\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"http://www.sacschool.com/wp-content/uploads/sites/4/2014/01/form-icon.png\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.js\"></script>\n");
      out.write("        <style>\n");
      out.write("          /* Para que el contenido de la página renderice en un 80% */\n");
      out.write("        .wrapper{\n");
      out.write("            width: 80%;\n");
      out.write("            margin: 0 auto;\n");
      out.write("        }\n");
      out.write("        .page-header h2{\n");
      out.write("            margin-top: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("        #logo {\n");
      out.write("            align-items: center;\n");
      out.write("            color: red;\n");
      out.write("            display: flex;\n");
      out.write("        }\n");
      out.write("         /* Fondo completo */\n");
      out.write("        body {\n");
      out.write("            margin: 0;\n");
      out.write("           background: url('https://wallpapertag.com/wallpaper/full/a/a/4/102788-light-grey-background-1920x1200-desktop.jpg');\n");
      out.write("            background-size:     cover;\n");
      out.write("            background-repeat:yes-repeat;\n");
      out.write("            display: compact;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("        <!-- Para imprimir -->\n");
      out.write("        <style type=\"text/css\" media=\"print\">\n");
      out.write("            @media print {\n");
      out.write("                .nover{\n");
      out.write("                    visibility:hidden\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('[data-toggle=\"tooltip\"]').tooltip();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("<!-- Cabecera de las páginas web común a todos -->");
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!-- ¡Barra de navegacion -->\n");
      out.write("<nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">Cliente Aula WS-JSP</a>\n");
      out.write("    </div>\n");
      out.write("    <ul class=\"nav navbar-nav\">\n");
      out.write("      <li class=\"active\"><a href=\"principal.jsp\">Inicio</a></li>\n");
      out.write("    </ul>\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("          ");
 
            // Recupero la sesion si existe
            HttpSession sesion=request.getSession();  
            if(sesion.getAttribute("nombre")!=null){
                out.println("<li><p class='navbar-text'>"+sesion.getAttribute("nombre")+"</p></li>");
            }
          
      out.write("\n");
      out.write("        <li><p class=\"navbar-text\">2ºDAM/DAW</p></li>\n");
      out.write("        <li><a href=\"salir.jsp\"><span class=\"glyphicon glyphicon-log-out\"></span> Salir</a></li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("<br><br>\n");
      out.write('\n');
    sesion = request.getSession();
    int id = 0;
    if (sesion.getAttribute("id") != null) {
        id = Integer.parseInt(sesion.getAttribute("id").toString());
    }

      out.write("\n");
      out.write("<!-- Comenzamos a programar cada sección --> \n");
      out.write("<div class=\"jumbotron\">\n");
      out.write("    <h1 class=\"display text-center\">Aula SW</h1>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"wrapper\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <form class=\"form-inline\" action=\"principal.jsp\" method=\"post\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"usuario\" class=\"sr-only\">Nombre:</label> <label for=\"usuario\" class=\"sr-only\">Nombre:</label>\n");
      out.write("\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"buscar\" name=\"nombre\" placeholder=\"Nombre de Alumno/a\">\n");
      out.write("                        <label for=\"usuario\" class=\"sr-only\">Nota:</label>\n");
      out.write("                        <input type=\"number\" class=\"form-control\" id=\"buscar\" name=\"calificacion\" max=\"10\" min=\"0\" step=\"0.05\" placeholder=\"Nota\">\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary mb-2\"> <span class=\"glyphicon glyphicon-pencil\"></span>  Calificar</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>  \n");
      out.write("    <div class=\"page-header\">\n");
      out.write("        <h2>Estadísticas:</h2>\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");

    try {
	org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
	org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
	 // TODO initialize WS operation arguments here
	//int id = 0;
	// TODO process result here
	java.lang.String result = port.estadisticas(id);
	out.println("Result = "+result);
        // Procesamos el JSON
        // JsonParser parser = new JsonParser();
        // JsonObject jO = parser.parse(result).getAsJsonObject();
         
         //out.println("<li>Total: "+jO.get("aprobados").getAsInt()+"</li>");
         
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("\n");
      out.write("        ");
      out.write("<hr/>\n");
      out.write("        ");

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
                            out.println("<td class='text-center'>Acción</td>");
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
                                 out.println("<td class='text-center'><a class='btn btn-danger' href='eliminar?id="+gsonObj.get("id").getAsInt()+"' title='Borar' data-toggle='tooltip'><span class='glyphicon glyphicon-trash'></span></a></td>");
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
        
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<br><br>\n");
                    // Recupero la sesion si existe

    SimpleDateFormat formateador = new SimpleDateFormat("dd'/'MM'/'yyyy 'a las' H':'m':'s", new Locale("es_ES"));
    Date fechaDate = new Date(sesion.getAttribute("momento").toString());
    out.println("<h6>Conectado como: " + sesion.getAttribute("nombre") + " Acceso: " + formateador.format(fechaDate) + "</h6>");


      out.write("\n");
      out.write("<br>\n");
      out.write("<!-- Final de la página -->\n");
      out.write("\n");
      out.write("\n");
      out.write("<br><br>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("<!-- Footer --> \n");
      out.write("<footer class=\"navbar-inverse navbar-fixed-bottom\">\n");
      out.write("    <div class=\"p-3 mb-2 bg-secondary text-white\"> \n");
      out.write("    <div class=\"container\">\n");
      out.write("        <!-- Copyright -->\n");
      out.write("\n");
      out.write("        <div class=\"footer-copyright text-center py-3\" style=\"color:whitesmoke\";>2018-2019 2º DAM/DAW:\n");
      out.write("            <a style=\"color:gainsboro\"; href=\"https://twitter.com/joseluisgonsan\" target=\"_blank\"> José Luis González Sánchez</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer-copyright text-center py-3\">\n");
      out.write("            <a style=\"color:gainsboro\"; href=\"http://www.iestrassierra.com/\" target=\"_blank\"> I.E.S. Trassierra</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer-copyright text-center py-3\" style=\"color:whitesmoke\";>Avda. Arroyo del Moro s/n. 14011 Córdoba.\n");
      out.write("        </div>\n");
      out.write("        <!-- Copyright -->\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("<!-- Footer -->");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
