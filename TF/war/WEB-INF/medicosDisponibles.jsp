<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
@SuppressWarnings("unchecked")
List<String> medicos = (List<String>)request.getAttribute("medicosDisponibles");
@SuppressWarnings("unchecked")
List<String> dnis = (List<String>)request.getAttribute("dnis");
%>
</head>
<body>
	<span>DNI del paciente</span>
	<input type="text" value=<%= session.getAttribute("usuario")%> name="dniPaciente" readonly class="formCita">
	<span>Fecha seleccionada</span>
	<input type="text" value=<%= request.getAttribute("fecha")%> name="fecha" readonly class="formCita"><br>
	<span>Seleccione la Hora</span>
	<input type="text" value=<%= request.getAttribute("hora")%> name="hora" readonly class="formCita">
	<span class="confirmarHora">CONFIRMAR HORA</span><br>
	<br><hr><br>
	<span>Selecione un medico disponible</span>
	<select name='nombreMedico'>
		<% for(int i=0;i<dnis.size();i++) { %>
		<option value=<%=dnis.get(i) %>><%=medicos.get(i) %></option>
		<% } %>
	</select><br>
	<span>Escriba el motivo de su cita</span>
	<input type="text" name="asunto"><br>
	<input type="submit" value="REGISTRAR CITA" class="enviar">
</body>
</html>