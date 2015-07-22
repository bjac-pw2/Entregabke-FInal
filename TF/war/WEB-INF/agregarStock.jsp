<!DOCTYPE html>
<%@ page import="bjac.*"%>
<%@ page import="servlet.*"%>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="java.util.List"%>
<%@ page import="javax.jdo.Query;" %>
<html lang="es">
<head>
	<title>Ultima Esperanza</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/styles.css">
	<link rel="stylesheet" href="css/sesion.css">
	<link rel="stylesheet" href="css/animacion.css">
	<link rel="stylesheet" href="css/menu.css">
	<link rel="stylesheet" href="css/input.css">
	<link rel="stylesheet" href="css/index.css">
	<link rel="stylesheet" href="css/logeado.css">
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
					<li><a href="cJFarma?option=1">INICIO</a>
					</li>
					<li><a href='#'>MEDICAMENTO</a>
						<div>
							<ul>
								<li><a href="cJFarma?option=14">REGISTRAR</a></li>
								<li><a href="cJFarma?option=10">AGREGAR STOCK</a></li>
								<li><a href="listaMedicamento">LISTAR</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div id="contenido">
		
		<div class="tituloEntrada">AGREGAR STOCK</div>
		<div class="cuerpoEntrada">
		<form action='/stockMedicamento' class='receta' method='get' accept-charset="utf-8">
			<% PersistenceManager pm1 = PMF.get().getPersistenceManager();
				Query q = pm1.newQuery(Medicamento.class);
				List<Medicamento> medicamentos = (List<Medicamento>) q.execute();%>
				
		<span class='lf' >Selecciona el medicamento: </span>
			<select name='id'>
				<option value=''></option>
				<% for(Medicamento m: medicamentos){%>
					<% if(m.getId()!=0 && m.getEstado()==1){%>
						<option value='<%= m.getId() %>'><%= m.getNombre() %> - <%= m.getTipo()%></option>
					<% }%>
				<% }%>
			</select><br>			
			<% q.closeAll(); pm1.close(); %>
	<span class='lf'>Ingrese la cantidad a aumentar: </span><input required type='number' min='1' name='stock'><br>
	<button class='enviar' type='submit'>Aumentar</button><br>
	
	</form>
	
	<form action="estadoMedicamento">
		<span class='lf' >Selecciona el medicamento: </span>
			<select name='id'>
				<option value=''></option>
				<% for(Medicamento m: medicamentos){%>
					<% if(m.getId()!=0 && m.getEstado()==1){%>
						<option value='<%= m.getId() %>'><%= m.getNombre() %> - <%= m.getTipo()%></option>
					<% }%>
				<% }%>
			</select><br>
		<button class='enviar' type='submit'>Desabilitar</button><br>
	</form>
	
		
	</div>
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