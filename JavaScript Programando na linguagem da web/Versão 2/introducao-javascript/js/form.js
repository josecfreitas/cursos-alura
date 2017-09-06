
let formAdicionar = document.querySelector("#form-adiciona");

formAdicionar.addEventListener("submit", function(e){
	e.preventDefault();

	let paciente = obtemPacienteDoFormulario(this);

	document.querySelector("#tabela-pacientes").appendChild(novaTr(paciente));

	this.reset();
});

function obtemPacienteDoFormulario(form){
	let paciente = {
		nome: form.nome.value,
		peso: form.peso.value,
		altura: form.altura.value,
		gordura: form.gordura.value,
		imc: calculaImc(form.peso.value, form.altura.value)
	}
	return paciente;
}

function novaTr(paciente){
	var tr = document.createElement("tr");

	tr.appendChild(novaTd(paciente.nome));
	tr.appendChild(novaTd(paciente.peso));
	tr.appendChild(novaTd(paciente.altura));
	tr.appendChild(novaTd(paciente.gordura));
	tr.appendChild(novaTd(paciente.imc));

	return tr;
}

function novaTd(text){
	var td = document.createElement("td");
	td.textContent = text;
	return td;
}