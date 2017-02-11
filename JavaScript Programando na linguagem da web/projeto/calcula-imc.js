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

function calculaTodosImcs(){
	var pacientes = document.getElementsByClassName("paciente");
	percorreArray(pacientes, function(pacienteRow){
		paciente = criaPaciente(pacienteRow);

		pacienteRow.getElementsByClassName("info-imc")[0].textContent = paciente.imc();
		console.log(paciente.nome);
	});
}
document.getElementById("calcula-imcs").addEventListener("click", calculaTodosImcs);