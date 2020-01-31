<%-- 
    Document   : salir.jsp
    Created on : 26-feb-2019, 17:08:44
    Author     : link
--%>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	org.me.aulaservicio.Aulaservicio_Service service = new org.me.aulaservicio.Aulaservicio_Service();
	org.me.aulaservicio.Aulaservicio port = service.getAulaservicioPort();
         // TODO initialize WS operation arguments here
         // Obtengo el id del usuario de la sesion
         HttpSession sesion=request.getSession(); 
	int id = Integer.parseInt(sesion.getAttribute("id").toString());
	// TODO process result here
	int result = port.salir(id);
	//out.println("Result = "+result);
        // Me cargo la sesion y redireciono
        sesion=request.getSession(); 
        sesion.invalidate();
        response.sendRedirect("index.jsp");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
        response.sendRedirect("index.jsp");
    }
    %>
    <%-- end web service invocation --%><hr/>

