function citas(d,m,a){
	var months=new Array('','Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octumbre', 'Noviembre', 'Deciembre' );
	var cab = document.getElementById("cabeceraCitas");
	var cont = document.getElementById("cont");
	cab.innerHTML ="<h2>"+d+" "+months[m]+" "+a+"</h2>";
	var f=d+"/"+(m)+"/"+a;;
	$.ajax({
			type:"get",
			url:"horarios",
			data: {
				fecha: f
			}
		}).done(function(respuesta){
			cont.innerHTML =respuesta;
		});
}