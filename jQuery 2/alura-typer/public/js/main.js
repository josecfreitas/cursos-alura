let campoDigitacao = $(".campo-digitacao");
let tempoInicial = $("#cronometro").text();
let frase = $(".frase").text();

$(function(){
	atualizaTamanhoFrase();
	inicializaContadores();
	inicializaCronometro();

	$("#botao-reiniciar").click(reiniciarJogo);
	campoDigitacao.on("input", validaDigitacao);
});

function atualizaTamanhoFrase(){
	let frase = $(".frase").text();
	let tamanhoDaFrase = frase.split(" ").length;

	$("#tamanho-frase").text(tamanhoDaFrase);
}

function inicializaContadores(){
	campoDigitacao.on("input", function(){

		let texto = $(this).val();

		$("#contador-caracteres").text(texto.length);
		$("#contador-palavras").text(texto.length == 0 ? 0 : texto.trim().split(/\s+/).length);
	});
}

function inicializaCronometro(){
	let tempoRestante = tempoInicial;
	$("#cronometro").text(tempoRestante);

	campoDigitacao.one("focus", function(){
		let cronometroID = setInterval(function(){
			tempoRestante--;
			$("#cronometro").text(tempoRestante);

			if(tempoRestante < 1){
				campoDigitacao.prop("disabled", true);
				clearInterval(cronometroID);
				$("#botao-reiniciar").prop("disabled", false);
				campoDigitacao.addClass("campo-desativado");
			}
		}, 1000);
	});
}

function reiniciarJogo(){
	$("#botao-reiniciar").prop("disabled", true);

	inicializaCronometro();

	campoDigitacao.attr("disabled", false);
	campoDigitacao.val("");
	campoDigitacao.removeClass("campo-desativado");

	campoDigitacao.removeClass("texto-invalido");
	campoDigitacao.removeClass("texto-valido");
}

function validaDigitacao(){
	let digitado = campoDigitacao.val();

	if(frase.startsWith(digitado)){
		campoDigitacao.addClass("texto-valido");
		campoDigitacao.removeClass("texto-invalido");
	} else {
		campoDigitacao.addClass("texto-invalido");
		campoDigitacao.removeClass("texto-valido");
	}
}