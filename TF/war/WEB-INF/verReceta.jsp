<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ page import="bjac.Receta;"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Ultima Esperanza</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/styles.css">
	<link rel="stylesheet" href="css/menu.css">
	<link rel="stylesheet" href="css/logeado.css">
	<link rel="stylesheet" href="css/indexUsuario.css">
	<link rel="stylesheet" href="css/facebook.css">
	<link rel="stylesheet" href="css/receta.css">
	<link rel="stylesheet" href="css/tabla.css">
	<%List<Receta> citas = (List<Receta>)request.getAttribute("citas"); %>
</head>
<body>
	<div id="fb-root"></div>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/es_ES/sdk.js#xfbml=1&version=v2.3";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>
	<header id="cabecera">
		<div id="cabecera-portada">
			<div id="cabecera-titulo">
				<h5>CLINICA</h5>
				<h1>ULTIMA ESPERANZA</h1>
				<div id="like">
					FACEBOOK <div class="fb-like"
						data-href="https://www.facebook.com/clinica.Ultima.Esperanza"
						data-width="300" data-layout="button_count" data-action="like"
						data-show-faces="true" data-share="true"></div>
				</div>
			</div>
			<div id="cabecera-aviso">
			</div>
		</div>
		<div id="sesion">
			<span class="tit">SESION INICIADA COMO:</span>
				<form action="cerrarSesion" method="post">
				<% String nombre=(String) session.getAttribute("nombre");%>
				<%if(nombre!=null){%>
					<div class="ll"><span class="tt">Usuario: </span><span class="tc"> <%=nombre %></span></div>
					<div class="ll"><span class="tt">Tipo: </span><span class="tc"><%=session.getAttribute("tipo")%></span><br></div>
					<input type="submit" value="SALIR" class="salir">
				<% }else{
					response.sendRedirect("http://bjac-pw2.appspot.com/");
				}
				%>
			</form>
		</div>
	</header>
	<nav id="menu">
		<div id="menuCenter">
			<div id="nav">
				<ul>
					<li><a href="#">INICIO</a></li>
					<li><a href='cJPacient?option=21'>NUEVA CITA</a></li>
					<li><a href="cJPacient?option=2">HISTORIAL</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div id="contenido">
		<% if(citas.size()!=0){%>
		<div id="receta">
			<div id="cabecera-r">
				<div id="ue-r">
					<h3 class="l-h3">ULTIMA ESPERANZA</h3>
				</div>
				<div id="titulo-r">
					<h2 class="l-h2">RECETA</h2>
				</div>
			</div>
			<div id="cuerpo-r">
				<div id="datos">
					<div id="cab-d-r" class="row-d-r">
						<div class="primera-c">
							<span class="l-t">Key Cita: </span><span class="l-c"><%= citas.get(0).getKeyCita() %></span>
						</div>
						<div class="segunda-c">
							<span class="l-t">DNI Medico: </span><span class="l-c"><%= citas.get(0).getDniMedico() %></span>
						</div>
						<div class="tercera-c">
							<span class="l-t">DNI Paciente: </span><span class="l-c"><%= citas.get(0).getDniPaciente() %></span>
						</div>
					</div>
					<div class="tabla">
						<div class="tituloTabla">DATOS DE RECETA</div>
						<% List<String> med = citas.get(0).getMedicamentos(); %>
						<div class="cabeza">
							<div class="cell">Diagnostico</div>
							<div class="cell">Medicamento Prescrito</div>
							<div class="cell">Cantidad del Producto</div>
							<div class="cell">Dosis, modo de empleo</div>
						</div>
						<%for( String m : med ) {%>
						<div class="row">
							<div class="cell"><p><%= m.substring(0,m.indexOf(":")) %></p></div>
							<% m =m.substring(m.indexOf(":")+1, m.length()); %>
							<div class="cell"><p><%= m.substring(0,m.indexOf(":")) %></p></div>
							<% m =m.substring(m.indexOf(":")+1, m.length()); %>
							<div class="cell"><p><%= m.substring(0,m.indexOf(":")) %></p></div>
							<% m =m.substring(m.indexOf(":")+1, m.length()); %>
							<div class="cell"><p><%= m %></p></div>
						</div>
						<%}%>
					</div>
				</div>
			</div>
		</div>
		<%}else{ %>
		Cita no Atendida
		<%} %>
	</div>	
	<footer id="pie">
		<div id="pieCenter">
			<div id="masInformacion">
				<div class="menus">
					<h5>Corporativo</h5>
					<ul>
						<li><a href="#">Quiénes Somos</a></li>
						<li><a href="#">Bienvenida</a></li>
						<li><a href="#">Mision</a></li>
						<li><a href="#">Vision</a></li>
					</ul>
				</div>
				<div class="menus">
					<h5>Servicios Clinicos</h5>
					<ul>
						<li><a href="controlJSP?option=4">Nuestros especialistas</a></li>
					</ul>
				</div>
				<div class="menus">
					<h5>Instituciones Relacionadas</h5>
					<ul>
						<li><a href="http://www.unsa.edu.pe/" target='_blank'>UNSA</a></li>
						<li><a href="http://www.episunsa.edu.pe/web/" target='_blank'>EPIS - UNSA</a></li>
						<li><a href="https://github.com/bjac-pw2/ultima-esperanza" target='_blank'>GITHUB</a></li>
						<li><a href="https://docs.google.com/document/d/1irMet0N5NQQ_5ddwcRHt6hbr19fHIGMVPGSA_EJkHb4/edit?pli=1" target='_blank'>MAPPING</a></li>
						<li><a href="https://docs.google.com/document/d/1Q33PgipxpBZ2DrHob4QLG_NrKgr1pQLO1BQh8XSOleM/edit?pli=1" target='_blank'>TESTING</a></li>
					</ul>
				</div>
				<div class="menus">
					<h5>Sedes Arequipa</h5>
					<ul>
						<li>Cercado</li>
					</ul>
					</div>
			</div>
			<div id="licencia">Derechos Reservados &copy; 2015 BJAC</div>
		</div>
	</footer>
</body>
</html>