var umaPropaganda = function(){
	var propagandas = ["O que acha de comprar uma motocicleta?",
	"O que acha de comprar uma lancha?",
	"O que acha de comprar uma bicicleta?",
	"O que acha de comprar uma carro?"
	];

	var posicao = Math.floor(propagandas.length * Math.random());
	var texto = propagandas[posicao];
	var tr = $("<tr>").addClass("propaganda").append($("<td>"));
	tr.find("td").attr("colspan", "6").text(texto);
	return tr;
}

function atualizaDados(){
	var carrinhos = $(".carrinho");

	carrinhos.each(function(){
		var carrinho = $(this);

		var itens = carrinho.find(".item-total:visible");
		var total = 0;

		for(var i = 0; i < itens.length; i++){
			var item = $(itens[i]);
			total += parseFloat(item.text());
		}
		carrinho.find(".total").text(total);

		var qtde = carrinho.find(".item-qtde:visible");
		carrinho.find(".qtdeTotal").text(qtde.length);
	});
}

function undo(){
	var carrinho = $(this).closest(".carrinho");
	carrinho.find("tr:visible").removeClass("recuperada");
	carrinho.find("tr:hidden").addClass("recuperada").show();
	atualizaDados();
}

$(document).ready(function(){

	atualizaDados();

	$(".remove-item").click(function(e) {
		e.preventDefault();

		// $("#qtdeTotal").text(parseInt($("#qtdeTotal").text()) - 1);
		// $("#total").text($("#total").text() - $(this).closest("td").siblings(".item-total").text());
		// $("#total").text($("#total").text() - $(this).closest("tr").find(".item-total").text());

		$(this).closest("tr").hide();
		atualizaDados();
	});

	$(".undo").click(undo);

	$(".carrinho").each(function() {
		var carrinho = $(this).find("tbody");
		carrinho.find("tr:nth-child(3n), tr:last").each(function(){
			umaPropaganda().insertAfter($(this));
		});
	});

	$(".carrinho tbody tr").hover(daDestaque, tiraDestaque);

	$(".alterna-propaganda").click(function(e){
		e.preventDefault();
		
		$(".propaganda").fadeToggle();
		$(".alterna-propaganda").toggle();
	});
});

function daDestaque(){
	$(this).find(".remove-item").fadeIn();
	$(this).addClass("hovering");
}
function tiraDestaque(){
	$(this).find(".remove-item").fadeOut();
	$(this).removeClass("hovering");
}