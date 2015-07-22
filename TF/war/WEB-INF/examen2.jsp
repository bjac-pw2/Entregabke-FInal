<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="UTF-8">
<title>Clinica Ultima Esperanza</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>CLINICA ULTIMA ESPERANZA</h1>
	<ul class = "index">
      <li><a href="index.html">INICIO</a>
      <li><a href="medicamento.jsp">Agregar Medicamento</a>
      <li><a href="/listaMedicina">Listar Medicamentos</a>
      <li><a href="paciente.jsp">Agregar Paciente</a>
      <li><a href="/listaPaciente">Listar Pacientes</a>
      <li><a href="medico.jsp">Agregar Medico</a>
      <li><a href="/listaMedicos">Listar Medico</a>
      <li><a href="receta.jsp">Receta</a>
      <li><a href="examen.jsp">Examen</a>
      <li><a href="resExamen.jsp">Resultados del Examen</a>
      <li><a href="indexCita.html">Cita</a>
      <li><a href="horario.html">Horario</a>
      </ul>
	
		<form class='examen'>
		<h2>Datos del paciente</h2><br/>
		<span class='lf'>DNI: </span><input required type='text' name='dni' pattern="[0-9]{8}"><br/>
		<span class='lf'>Nombre: </span><input required type='text' name='nombre' pattern="[a-zA-Z]+(\s)*[a-zA-Z]*"><br/>
		<span class='lf'>Apellido: </span><input required type='text' name='apellido' pattern="[a-zA-Z]+(\s)*[a-zA-Z]*"><br/>
		
		<h2>Datos del medico </h2><br/>
		<span class='lf'>DNI: </span><input required type='text' name='dni' pattern="[0-9]{8}"><br/>
		<span class='lf'>Nombre: </span><input required type='text' name='nombre' pattern="[a-zA-Z]+(\s)*[a-zA-Z]*"><br/>
		<span class='lf'>Apellido: </span><input required type='text' name='apellido' pattern="[a-zA-Z]+(\s)*[a-zA-Z]*"><br/>
		<span class='lf'>Especialidad: </span><input required type='text' name='apellido' pattern="[a-zA-Z]+(\s)*[a-zA-Z]*"><br/>
		
		<h2>Examen</h2><br/>
		<h2>Medico encargado del examen</h2>
		<span class='lf'>Nombre: </span><input required type='text' name='nombre' pattern="[a-zA-Z]+(\s)*[a-zA-Z]*"><br/>
		<span class='lf'>Apellido: </span><input required type='text' name='apellido' pattern="[a-zA-Z]+(\s)*[a-zA-Z]*"><br/>
		<span class='lf'>Especialidad: </span><input required type='text' name='apellido' pattern="[a-zA-Z]+(\s)*[a-zA-Z]*"><br/>
		
		<h2>Datos del Examen</h2>
		<span class='lf'>Nombre: </span><input type='text' name='apellido'></br>
		<span class='lf'>Descripcion: </span> <br><textarea name='apellido'></textarea><br>
		<span class='lf'>Fecha: </span><input required type='text' name='dni' placeholder='dd/mm/aaaa'pattern="(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d"><br/>
		
		<button class='enviar' type='submit'>Guardar</button><br>
		</form>
	</span>

</body>
</html>