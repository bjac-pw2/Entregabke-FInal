<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
@SuppressWarnings("unchecked")
List<String> medicos = (List<String>)request.getAttribute("medicosDisponibles");
@SuppressWarnings("unchecked")
List<String> dnis = (List<String>)request.getAttribute("dnis");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span class="lf">Selecione un medico disponible para el <%=request.getAttribute("fecha")%> alas <%=request.getAttribute("hora") %></span>
	<select name='dniMedExamen'>
		<% for(int i=0;i<dnis.size();i++) { %>
		<option value=<%=dnis.get(i) %>><%=medicos.get(i) %></option>
		<% } %>
	</select>
</body>
</html>