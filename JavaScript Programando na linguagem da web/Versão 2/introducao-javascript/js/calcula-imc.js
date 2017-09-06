
document.querySelector("#tabela-pacientes").querySelectorAll(".paciente").forEach(function(item){
	var paciente = item;

	var peso = paciente.querySelector(".info-peso").textContent;
	var altura = paciente.querySelector(".info-altura").textContent;

	var tdImc = paciente.querySelector(".info-imc");

	var alturaEhValida = true;
	var pesoEhValido = true;

	if(peso <= 0 || peso > 1000){
		console.log("Peso inválido");
		tdImc.textContent = "Peso inválido!";

		// paciente.style.backgroundColor = "red";
		// paciente.style.color = "white";
		paciente.classList.add("paciente-invalido");

		pesoEhValido = false;
	}
	if(altura <= 0 || altura >= 3){
		console.log("Altura inválida");
		tdImc.textContent = "Altura inválida!";

		// paciente.style.backgroundColor = "red";
		// paciente.style.color = "white";
		paciente.classList.add("paciente-invalido");

		alturaEhValida = false;
	}

	if(pesoEhValido && alturaEhValida) {
		tdImc.textContent = calculaImc(peso, altura);
	}
});

function calculaImc(peso, altura){
	return (peso / (altura * altura)).toFixed(2);
}