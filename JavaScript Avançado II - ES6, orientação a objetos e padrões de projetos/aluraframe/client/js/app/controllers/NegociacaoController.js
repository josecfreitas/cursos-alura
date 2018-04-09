class NegociacaoController{

	constructor(){

		let $ = document.querySelector.bind(document);

		this._inputData = $('#data');
		this._inputQuantidade = $('#quantidade');
		this._inputValor = $('#valor');

		this._listaNegociacoes = new ListaNegociacoes(model => 
			this._negociacoesView.update(model)
			);

		this._listaNegociacoes = new Proxy(new ListaNegociacoes(), {

			get(target, prop, receiver) {
				console.log("ARMADILHA");
				console.log(target);
				console.log(prop);
				console.log(receiver);

				this._negociacoesView.update(model);
				return Reflect.get(target, prop, receiver);
			}
		});

		this._negociacoesView = new NegociacoesView($('#negociacoes'));
		this._negociacoesView.update(this._listaNegociacoes);

		this._mensagem = new Mensagem();
		this._mensagemView = new MensagemView($('#mensagemView'));
		this._mensagemView.update(this._mensagem);
	}

	adiciona(event){

		event.preventDefault();
		
		this._listaNegociacoes.adiciona(this._criaNegociacao());

		this._mensagem.texto = 'Negociação adicionada com sucesso!';
		this._mensagemView.update(this._mensagem);

		this._resetaForm();
	}

	apaga(){

		this._listaNegociacoes.esvazia();

		this._mensagem.texto = "Negociações apagadas com sucesso.";
		this._mensagemView.update(this._mensagem);
	}

	_criaNegociacao(){

		return new Negociacao(
			DataHelper.textoParaData(this._inputData.value),
			this._inputQuantidade.value,
			this._inputValor.value
			);
	}

	_resetaForm(){

		this._inputData.value = "";
		this._inputQuantidade.value = "1";
		this._inputValor.value = "0.0";
	}
}