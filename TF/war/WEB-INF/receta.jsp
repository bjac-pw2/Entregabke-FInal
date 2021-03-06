<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ page import="bjac.Medicamento;"%>
<!DOCTYPE html>
<html>
<head>
	<title>Ultima Esperanza</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/styles.css">
	<link rel="stylesheet" href="css/menu.css">
	<link rel="stylesheet" href="css/logeado.css">
	<link rel="stylesheet" href="css/receta.css">
	<link rel="stylesheet" href="css/tabla.css">
	<link rel="stylesheet" href="css/facebook.css">
	<link rel="stylesheet" href="css/input.css">
	<script src="js/receta.js"></script>
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
				<%
				}
				%>
			</form>
		</div>
	</header>
	<nav id="menu">
		<div id="menuCenter">
			<div id="nav">
				<ul>
					<li><a href="#">INICIO</a>
					</li>
					<li><a href='controlJSP?option=20'>HORARIO</a></li>
					<li><a href='#'>MEDICAMENTO</a>
						<div>
							<ul>
								<li><a href="#">BUSCAR</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div id="contenido">
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
							<span class="l-t">Fecha: </span><span class="l-c"><%=request.getAttribute("fecha") %></span>
						</div>
						<div class="segunda-c">
							<span class="l-t">Hora: </span><span class="l-c"><%=request.getAttribute("hora") %></span>
						</div>
						<div class="tercera-c">
							<span class="l-t">Receta ID: </span><span class="l-c"><%=request.getAttribute("id") %></span>
						</div>
					</div>
					<div class="row-d-r" id="paciente">
						<div class="primera-c">
							<span class="tt">DATOS DEL PACIENTE</span> <span class="l-t">Genero:
							</span> <span class="l-c"><%=request.getAttribute("genero") %></span>
						</div>
						<div class="segunda-c">
							<span class="l-t">DNI: </span><span class="l-c"><%=request.getAttribute("dniPaciente") %></span>
						</div>
						<div class="tercera-c">
							<span class="l-t">Nombre: </span> <span class="l-c"><%=request.getAttribute("nombre") %></span>
						</div>
					</div>
					<div class="row-d-r">
						<div class="primera-c">
							<span class="l-t">Tipo de Sangre: </span> <span class="l-c"><%=request.getAttribute("tsangre") %></span>
						</div>
						<div class="segunda-c">
							<span class="l-t">Peso: </span><span class="l-c"><%=request.getAttribute("peso") %></span>
						</div>
						<div class="tercera-c">
							<span class="l-t">Estatura: </span><span class="l-c"><%=request.getAttribute("talla") %></span>
						</div>
					</div>
					<div class="row-d-r" id="medico">
						<div class="primera-c">
							<span class="tt">DATOS DEL MEDICO FACULTATIVO</span>
						</div>
						<div class="segunda-c">
							<span class="l-t">DNI: </span><span class="l-c"><%=session.getAttribute("usuario") %></span>
						</div>
					</div>
					<div class="row-d-r">
						<div class="primera-c">
							<span class="l-t">Nombre: </span> <span class="l-c"><%=session.getAttribute("nombre") %></span>
						</div>
					</div>
					<div class="entrada">
						<div class="tituloEntrada">DATOS DE RECETA</div>
						<div class="cuerpoEntrada">
							<form action="/guardarReceta" method="get">
								<span class='lf'>Receta ID: </span>
								<input type="text" name="id" value=<%=request.getAttribute("id")%> readonly>
								<span class='lf'>DNI paciente: </span>
								<input type="text" name="dnip" value=<%=request.getAttribute("dniPaciente")%> readonly>
								<span class='lf'>DNI medico: </span>
								<input type="text" name="dnim" value=<%=session.getAttribute("usuario") %> readonly>
								<div class="tabla" id="tr">
									<div class="tituloTabla">Medicamentos</div>
									<div class="cabeza">
										<div class="cell">Diagnostico</div>
										<div class="cell">Medicamento Prescrito</div>
										<div class="cell">Cantidad del Producto</div>
										<div class="cell">Dosis, modo de empleo</div>
										<div class="cell">Estado</div>
									</div>
									<div class="row">
										<div class="cell"><input type="text" id="dia"></div>
										<div class="cell">
											<select id="med">
												<%List<Medicamento> ms = (List<Medicamento>)request.getAttribute("medicamentos");%>
												<option></option>
												<%for( Medicamento p : ms) {
												if(p.getEstado()==1){%>
													<option ><%=p.getNombre() %>( <%=p.getTipo() %> )</option>
												<%}}%>
											</select>
										</div>
										<div class="cell"><input type="text" id="can"></div>
										<div class="cell"><input type="text" id="dos"></div>
										<div class="cell"><button onClick="confirmar()" class="enviar">Confirmar</button></div>
									</div>
								</div>
								<input type="submit" value="GUARDAR" class="enviar">
							</form>
						</div>
					</div>
				</div>
			</div>
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