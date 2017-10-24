let campoDigitacao = $(".campo-digitacao");
let tempoInicial = $("#cronometro").text();

$(function(){
	atualizaTamanhoFrase();
	inicializaContadores();
	inicializaCronometro();

	$("#botao-reiniciar").click(reiniciarJogo);
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
				$(".campo-digitacao").prop("disabled", true);
				clearInterval(cronometroID);
				$("#botao-reiniciar").prop("disabled", false);
			}
		}, 1000);
	});
}

function reiniciarJogo(){
	$("#botao-reiniciar").prop("disabled", true);

	inicializaCronometro();

	campoDigitacao.attr("disabled", false);
	campoDigitacao.val("");
	campoDigitacao.focus();


}