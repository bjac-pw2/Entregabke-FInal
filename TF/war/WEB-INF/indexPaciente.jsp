<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div id="articulos">
			<div class="articulo">
				<h3>ARTICULO DIARIO</h3>
				<hr>
				<h5>Cuida tu cuerpo</h5>
				<p>La prevención y la detección precoz de la enfermedad
				 son los dos pilares básicos para mantener el estado de 
				 salud. Además de tener unos hábitos de vida saludable, 
				 la vacunación es fundamental para la prevención. 
				 Respecto a la detección precoz, la realización de 
				 chequeos periódicos es clave: estudios urológicos 
				 para el cáncer de próstata y ginecológicos para 
				 cánceres de mama y cérvix, colonoscopias para el 
				 de colon, espirometría para EPOC, etc.</p>
				 <h5>¡Sonríe!</h5>
				 <p>Las emociones positivas, como la alegría, el entusiasmo, 
				 la satisfacción o el orgullo, son una fuente necesaria de 
				 bienestar y calidad de vida y proyectan una imagen nuestra 
				 más atractiva, lo que favorece que otras personas positivas 
				 deseen aproximarse a nosotros.</p>
				<h5>Noticias</h5>
				<p>Aquí encontrarás información sobre tratamientos y consejos de salud.</p>
			</div>
			<div class="articulo">
				<h3>INNOVACION Y AVANCES</h3>
				<hr>
				<h5>Envejecimiento precoz: investigadores descubren y reparan los defectos de las células enfermas </h5>
				<p>Investigadores del Institut Pasteur y del CNRS, 
				en colaboración con científicos del CEA y del Institut 
				Gustave Roussy, en Francia, han conseguido restablecer 
				una actividad normal en las células de pacientes con 
				síndrome de envejecimiento precoz, el síndrome de Cockayne.</p>
				<p>Han descubierto la implicación en esta patología de una enzima, 
				la proteasa HTRA3. Con excesiva expresión en los pacientes, 
				engendra una disfunción de las mitocondrias, que desempeñan 
				un papel clave en la aparición de los síntomas de 
				envejecimiento en los niños. Estos trabajos publicados 
				en la revista PNAS Plus describen uno de los mecanismos 
				responsables del envejecimiento precoz desconocido hasta 
				la fecha y podrán esclarecer el mecanismo del envejecimiento 
				en general.</p>
				<h5>Avances en la medicina</h5>
				<p>Aquí encontrarás información sobre los avances en la medicina</p>
			</div>
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