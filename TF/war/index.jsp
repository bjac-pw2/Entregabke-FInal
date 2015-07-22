<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% if(session.getAttribute("nombre")!=null) 
    	response.sendRedirect("/inicio");
    %>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Ultima Esperanza</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/styles.css">
	<link rel="stylesheet" href="css/sesion.css">
	<link rel="stylesheet" href="css/animacion.css">
	<link rel="stylesheet" href="css/menu.css">
	<link rel="stylesheet" href="css/facebook.css">
	<link rel="stylesheet" href="css/mensaje-letras.css">
	<link rel="stylesheet" href="css/index.css">
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
				¡Bievenidos a Clinica Ultima Esperanza!<br> Para registrarse
				click <a href="registrar.jsp"> aqui</a><br> Para mayor
				informacion click <a href="ultimaEsperanza.jsp"> aqui</a><br>
			</div>
		</div>
		<div id="sesion">
			<h4>INICIAR SESION</h4>
			<form action="validaSesion" method="post">
					<input type="text" required placeholder="Usuario" name='usuario' value='' class="in">
					<input type="password" required placeholder="Password" name='password' value='' class="in">
					<input type="submit" value="ENTRAR" class="boton"><br>
				<a href="registrar.jsp"><input type="button" value="REGISTRARSE" class="boton" id="registrar"></a>
				<a href="recuperarContraseña.jsp"><input type="button" value="RECUPERAR CONTRASEÑA" class="boton"></a>
			</form>
		</div>
	</header>
	<nav id="menu">
		<div id="menuCenter">
			<div id="nav">
				<ul>
					<li><a style="color:#66CCCC" href="index.jsp">INICIO</a></li>
					<li><a href="ultimaEsperanza.jsp">MAS INFORMACION</a></li>
					<li><a href="contactenos.jsp">CONTACTENOS</a></li>
					<li><a href='#'>PAGINA WEB</a>
						<div>
							<ul>
								<li><a href="1.jsp">Descripcion</a></li>
								<li><a href="2.jsp">Empresa Destinada</a></li>
								<li><a href="3.jsp">Ventajas y Desventajas</a></li>
								<li><a href="4.jsp">Alcances</a></li>
								<li><a href="5.jsp">Antes Y Despues</a></li>
							</ul>
						</div>
					</li>
					
				</ul>
			</div>
		</div>
	</nav>
	<div id="portada">
		<div id="im">
			<img src='imag-001.png' title="imagenes" alt="img01">
			<img src='imag-002.png' title="imagenes" alt="img02">
			<img src='imag-003.png' title="imagenes" alt="img03">
		</div>
	</div>
	<div id="portadaPie">
		<div class="ppies">BUENA INFRAESTRUCTURA</div>
		<div class="ppies">NUEVA TENOLOGIA</div>
		<div class="ppies">ATENCION DE CALIDAD</div>
	</div>
	<hr  size="4" color="#099">
	<div id="contenido">
		<div id="contenido-cont">
			<h2 class="ti">Misión</h2>
	    	<p class="pa">La Misión de Clínica Ultima Esperanza es satisfacer <br>
	    	en forma integral las necesidades de cuidado de la salud <br>
	    	de las personas y contribuir al desarrollo del conocimiento <br>
	    	médico en beneficio de la comunidad.</p>
			<h2 class="ti">Pagina Web</h2>
	    	<p class="pa">Una de las principales fuciones de la pagina web,<br> 
	    	la comodidad de nuestro usuarios,<br> 
	    	no mas colas para hacer citas, no mas colas para ver resultados de sus examenes,<br>
	    	para estar mas cerca asus medicos, y realizar cualquier consulta.</p>
	    	<h2 class="ti">Usuarios</h2>
	    	<p class="pa">Si todavia no eres un usuario de nuestra pagina,<br> 
	    	por favor registrese haciendo click <a href="registrar.jsp"> aqui</a> para tener acceso a todas nuestros<br> 
	    	nuestros servicios de la pagina web, y si eres ya eres un usuario, envienos sus sugerencias, reclamos, etc.<br>
	    	Estamos asu servicio.</p>
		</div>
		<div id="noticias">
			<div id="face">ENCUENTRANOS EN FACEBOOK</div>
			<div class="fb-page" data-href="https://www.facebook.com/clinica.Ultima.Esperanza" data-width="300" data-height="400" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true" data-show-posts="true"><div class="fb-xfbml-parse-ignore"><blockquote cite="https://www.facebook.com/clinica.Ultima.Esperanza"><a href="https://www.facebook.com/clinica.Ultima.Esperanza">Ultima Esperanza</a></blockquote></div></div>
			<div id="like">
			<div class="fb-like" data-href="https://www.facebook.com/clinica.Ultima.Esperanza" data-width="300" data-layout="button_count" data-action="like" data-show-faces="true" data-share="true"></div>
			</div>
		</div>
	</div>
	<footer id="pie">
		<div id="pieCenter">
			<div id="masInformacion">
				<div class="menus">
					<h5>Corporativo</h5>
					<ul>
						<li><a href="ultimaEsperanza.jsp">Ultima Esperanza</a></li>
						<li><a href="contactenos.jsp">Contactenos</a></li>
						<li><a href="bjac.jsp">BJAC</a></li>
					</ul>
				</div>
				<div class="menus">
					<h5>Paginas Relacionadas</h5>
					<ul>
						<li><a href="https://github.com/bjac-pw2/ultima-esperanza" target='_blank'>GITHUB</a></li>
						<li><a href="https://docs.google.com/document/d/1irMet0N5NQQ_5ddwcRHt6hbr19fHIGMVPGSA_EJkHb4/edit?pli=1" target='_blank'>MAPPING</a></li>
						<li><a href="https://docs.google.com/document/d/1Q33PgipxpBZ2DrHob4QLG_NrKgr1pQLO1BQh8XSOleM/edit?pli=1" target='_blank'>TESTING</a></li>
					</ul>
				</div>
				<div class="menus">
					<h5>Instituciones Relacionadas</h5>
					<ul>
						<li><a href="http://www.unsa.edu.pe/" target='_blank'>UNSA</a></li>
						<li><a href="http://www.episunsa.edu.pe/web/" target='_blank'>EPIS - UNSA</a></li>
					</ul>
				</div>
				<div class="menus">
					<h5>Sedes Arequipa</h5>
					<ul>
						<li><a href="#">Cercado</a></li>
					</ul>
					</div>
			</div>
			<div id="licencia">Derechos Reservados &copy; 2015 BJAC</div>
		</div>
	</footer>
</body>
</html>