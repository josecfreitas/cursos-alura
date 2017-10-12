
let formAdicionar = document.querySelector("#form-adiciona");

formAdicionar.addEventListener("submit", function(e){
	e.preventDefault();

	let paciente = obtemPacienteDoFormulario(this);

	let erros = validaPaciente(paciente);

	let mensagensErro = document.querySelector("#mensagens-erro");
	mensagensErro.innerHTML = "";
	if(erros.length > 0){
		erros.forEach(erro => {
			mensagensErro.appendChild(novaLi(erro));
		});
		return;
	}

	adicionaPacienteNaTabela(paciente);

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

function novaLi(text){
	var li = document.createElement("li");
	li.textContent = text;
	return li;
}

function validaPaciente(paciente){
	let erros = [];

	if (paciente.nome.length == 0) {
		erros.push("O nome não pode ser em branco");
	}

	if (paciente.gordura.length == 0) {
		erros.push("A gordura não pode ser em branco");
	}

	if (paciente.peso.length == 0) {
		erros.push("O peso não pode ser em branco");
	}

	if (paciente.altura.length == 0) {
		erros.push("A altura não pode ser em branco");
	}

	if (!validaPeso(paciente.peso)) {
		erros.push("Peso é inválido");
	}

	if (!validaAltura(paciente.altura)) {
		erros.push("Altura é inválida");
	}

	return erros;
}

function adicionaPacienteNaTabela(paciente){
	document.querySelector("#tabela-pacientes").appendChild(novaTr(paciente));
}