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

var pacientes = document.getElementsByClassName("paciente");
percorreArray(pacientes, function(paciente){
	pacienteAtual = criaPaciente(paciente);

	paciente.getElementsByClassName("info-imc")[0].textContent = pacienteAtual.imc();
	console.log(pacienteAtual.nome);
});