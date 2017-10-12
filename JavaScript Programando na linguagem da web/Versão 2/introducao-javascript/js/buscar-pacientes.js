
let btnBuscarPacientes = document.querySelector("#buscar-pacientes");

btnBuscarPacientes.addEventListener("click", e => {
	console.log("Buscando pacientes...");

	let xhr = new XMLHttpRequest();

	xhr.open("GET", "https://api-pacientes.herokuapp.com/pacientes");

	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			let pacientes = JSON.parse(xhr.responseText);

			pacientes.forEach(paciente => {
				adicionaPacienteNaTabela(paciente);
			});
		} else {
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});

	xhr.send();
});