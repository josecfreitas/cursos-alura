var campoFiltro = document.querySelector("#filtrar-tabela");

campoFiltro.addEventListener("input", function(){
	let parametro = this.value;

	let pacientes = document.querySelectorAll(".paciente");

	if(parametro.length > 0) {
		let regex = new RegExp(parametro, "i");
		pacientes.forEach(paciente => {
			let nome = paciente.querySelector(".info-nome").textContent;

			if(regex.test(nome)){
				paciente.classList.remove("invisivel");
			} else {
				paciente.classList.add("invisivel")
			}
		});
	} else {
		pacientes.forEach(paciente => paciente.classList.remove("invisivel"));
	}
});