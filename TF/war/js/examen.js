function confirmar(){
	var cont2 = document.getElementById("cont");
	var h = document.getElementById("hora").value;
	var f = document.getElementById("fecha").value;
	$.ajax({
		type:"get",
		url:"medDisExamen",
		data: {
			hora:h,
			fecha: f
		}
	}).done(function(respuesta){
		cont2.innerHTML =respuesta;
	});
}
function main(){
	document.getElementById("contenido").style.height=(document.getElementById("contenido").offsetHeight+320)+"px";
}
window.addEventListener('load',main, false);