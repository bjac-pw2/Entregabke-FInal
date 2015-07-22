<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%List<String> horas = (List<String>)request.getAttribute("horasDisponibles");%>
</head>
<body>
	<span>DNI del paciente</span>
	<input type="text" value=<%= session.getAttribute("usuario")%> ame="nombre" readonly id="nombre" class="formCita">
	<span>Fecha seleccionada</span>
	<input type="text" value=<%= request.getAttribute("fecha")%> name="fecha" readonly id="fecha" class="formCita"><br>
	<span>Seleccione la Hora</span>
	<select name='hora' id="hora" class="formCita">
		<% for( String h : horas  ) { %>
		<option value=<%=h %>><%=h%></option>
		<% } %>
	</select>
	<span class="confirmarHora" onClick=confirmar()>CONFIRMAR HORA</span><br>
	<script type="text/javascript" src="js/medicos.js"></script>
</body>
</html>