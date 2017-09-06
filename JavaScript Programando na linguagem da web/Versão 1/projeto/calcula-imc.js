function percorreArray(pacientes, comportamento){
	for (var posicaoAtual = 0; posicaoAtual < pacientes.length; posicaoAtual++){
		comportamento(pacientes[posicaoAtual]);
	}
}

function criaPaciente(paciente){
	return {
		"nome" : paciente.getElementsByClassName("info-nome")[0].textContent,
		"peso" : paciente.getElementsByClassName("info-peso")[0].textContent,
		"altura" : paciente.getElementsByClassName("info-altura")[0].textContent,
		"imc" : function(){
			if(this.altura != 0){
				imc = this.peso / (this.altura * this.altura);
			} else {
				imc = "Altura é 0";
			}
			return imc;
		}
	}
}

document.getElementById("calcula-imcs").addEventListener("click", function(){
	var pacientes = document.getElementsByClassName("paciente");
	percorreArray(pacientes, function(pacienteRow){
		paciente = criaPaciente(pacienteRow);

		pacienteRow.getElementsByClassName("info-imc")[0].textContent = paciente.imc();
		console.log(paciente.nome);
	});
});

var tabelaPacientes = document.querySelector("table");

document.querySelector("#adicionar-paciente").addEventListener("click",	function(e){
	e.preventDefault();

	var campoNome = document.querySelector("#campo-nome");
	var campoPeso = document.querySelector("#campo-peso");
	var campoAltura = document.querySelector("#campo-altura");

	tabelaPacientes.innerHTML = tabelaPacientes.innerHTML + 
								"<tr class='paciente'>" +
									"<td class='info-nome'>"+ campoNome.value +"</td>" +
									"<td class='info-peso'>"+ campoPeso.value +"</td>" +
									"<td class='info-altura'>"+ campoAltura.value +"</td>" +
									"<td class='info-imc'>"+campoPeso.value/(campoAltura.value*campoAltura.value)+"</td>" +
								"</tr>";

	campoNome.value = "";
	campoPeso.value = "";
	campoAltura.value = "";
});