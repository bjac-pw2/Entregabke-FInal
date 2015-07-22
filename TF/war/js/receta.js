function confirmar(){
	document.getElementById("contenido").style.height=(document.getElementById("contenido").offsetHeight+40)+"px";
	tr = document.getElementById("tr");
	tr.innerHTML =tr.innerHTML
	+"<div class='row'>"
	+"<div class='cell'><input name='dia' value='"+document.getElementById("dia").value+"' readonly></div>"
	+"<div class='cell'><input name='med' value='"+document.getElementById("med").value+"' readonly></div>"
	+"<div class='cell'><input name='can' value='"+document.getElementById("can").value+"' readonly></div>"
	+"<div class='cell'><input name='dos' value='"+document.getElementById("dos").value+"' readonly></div>"
	+"<div class='cell'>Confirmado</div></div>";
}
function main(){
	document.getElementById("contenido").style.height=700+"px";
}
window.addEventListener('load',main, false);