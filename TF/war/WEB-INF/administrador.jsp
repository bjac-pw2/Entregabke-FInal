<!DOCTYPE html>
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
					<li><a style="color:#66CCCC" href="cJAdmin?option=1">INICIO</a>
					</li>
					<li><a href='#'>REGISTRAR</a>
						<div>
							<ul>
								<li><a href="cJAdmin?option=2">Paciente</a></li>
								<li><a href="cJAdmin?option=4">Medico</a></li>
								<li><a href="cJAdmin?option=7">Farmaceutico</a></li>
								<li><a href="cJAdmin?option=8">Administrador</a></li>
								<li><a href="cJAdmin?option=11">Asistente</a></li>
							</ul>
						</div>
					</li>
					<li><a href='#'>LISTAR</a>
						<div>
							<ul>
								<li><a href="listaUsuarios">Usuario</a></li>
								<li><a href="listaPaciente">Paciente</a></li>
								<li><a href="listaMedico">Medico</a></li>
								<li><a href="listaFarmaceutico">Farmaceutico</a></li>
								<li><a href="listaAdministrador">Administrador</a></li>
								<li><a href="listaAsistente">Asistente</a></li>
							</ul>
						</div>
					</li>
					<li><a href="#">MAS OPCIONES</a>
						<div>
							<ul>
								<li><a href="cJAdmin?option=18">Modificar Contraseña</a></li>
								<li><a href="cJAdmin?option=20">Eliminar Usuario</a></li>
								<li><a href="cJAdmin?option=19">Modificar estado</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div id="contenido">
		<div class="entrada">
			<div class="tituloEntrada">NUEVO ADMINISTRADOR</div>
			<div class="cuerpoEntrada">
				<form action='regAdministrador' method='get'class='regMedico' accept-charset="utf-8">
				<span class='lf'>DNI: </span><input required type='text' name='dni' pattern="[0-9]{8}"><br/>
				<span class='lf'>Nombre: </span><input required type='text' name='nombre' pattern="([a-zA-ZáéíóúÁÉÍÓÚñÑ]+[\s]?[a-zA-ZáéíóúÁÉÍÓÚñÑ]*)"><br/>
				<span class='lf'>Apellido Paterno: </span><input required type='text' name='apellidoPat' pattern="([a-zA-ZáéíóúÁÉÍÓÚñÑ]+[\s]?[a-zA-ZáéíóúÁÉÍÓÚñÑ]*)"><br/>
				<span class='lf'>Apellido Materno: </span><input required type='text' name='apellidoMat' pattern="([a-zA-ZáéíóúÁÉÍÓÚñÑ]+[\s]?[a-zA-ZáéíóúÁÉÍÓÚñÑ]*)">
				<span class='lf' >Seleccione su género</span></h2>
					<select name='genero'>
							<option value=''></option>
							<option value='masculino'>Masculino</option>
							<option value='femenino'>Femenino</option>
					</select><br>
				<span class='lf'>Direccion: </span><input required type='text' name='direccion' placeholder='calle,Av. o Jr./#'><br/>
				<span class='lf'>Correo electronico: </span><input required type='text' name='email' pattern="^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$" placeholder="ejemplo@ejemplo.com"><br/>
				<span class='lf'>Telefono: </span><input required type='text' name='telefono' pattern="[1-9]{6}|[0-9]{9}"><br/>
				<button class='enviar' type='submit'>Guardar</button><br>
				</form>
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