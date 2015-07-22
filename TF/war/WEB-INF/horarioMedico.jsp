<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ page import="java.util.Date"%>
    <%@ page import="bjac.Cita;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
@SuppressWarnings("unchecked")
List<Cita> citas = (List<Cita>)request.getAttribute("citas");
Date d = new Date();
String fecha=""+d.getDate()+"/"+(d.getMonth()+1)+"/"+(1900+d.getYear());
String hora = ""+((d.getHours()>9)?d.getHours():"0"+d.getHours())
		+":"+((d.getMinutes()>30)?"30":"00")+":00";
%>
</head>
<body>
	<div class="tabla">
		<div class="tituloTabla">Mis citas
		</div>
		<div class="cabeza">
			<div class="cell">DNI del Usuario</div>
			<div class="cell">Hora</div>
			<div class="cell">Asunto</div>
			<div class="cell">Estado</div>
		</div>
		<%for( Cita p : citas ) {%>
			<div class="row">
				<div class="cell"><p><%= p.getDniPaciente() %></p></div>
				<div class="cell"><p><%= p.getHora() %></p></div>
				<div class="cell"><p><%= p.getAsunto() %></p></div>
				<% if(fecha.equals(p.getfecha())&&hora.equals(p.getHora())){%>
				<div class="cell"><form action="atender"><input type="submit" value="ATENDER"></form></div>
				<% }else if(p.getAtendido()){%>
				<div class="cell"><p style="color:gray">Atendido</p></div>
				<%}else{%>
				<div class="cell"><p>No disponible</p></div>
				<% }%>
			</div>
		<%}%>
	</div>	
</body>
</html>