class NegociacaoController {

	constructor() {

		let $ = document.querySelector.bind(document);

		this._ordemAtual = ''; // quando a página for carregada, não tem critério. Só passa a ter quando ele começa a clicar nas colunas

		this._inputData = $('#data');
		this._inputQuantidade = $('#quantidade');
		this._inputValor = $('#valor');

		this._listaNegociacoes = new Bind(
			new ListaNegociacoes(),
			new NegociacoesView($('#negociacoes')),
			'adiciona', 'esvazia', 'ordena', 'inverteOrdem'
		);

		this._mensagem = new Bind(
			new Mensagem(),
			new MensagemView($('#mensagemView')),
			'texto');

		this._negociacaoService = new NegociacoesService();

		this._init();
	}

	_init() {
		this._negociacaoService
			.listaTodos()
			.then(negociacoes =>
				negociacoes.forEach(negociacao =>
					this._listaNegociacoes.adiciona(negociacao)))
			.catch(e => this._mensagem.texto = e);

		setInterval(() => {
			console.log("Atualizando negociacões");
			this.importaNegociacoes();
		}, 3000);
	}

	adiciona(event) {

		event.preventDefault();

		this._negociacaoService
			.cadastra(this._criaNegociacao())
			.then(mensagem => {
				this._listaNegociacoes.adiciona(this._criaNegociacao());
				this._mensagem.texto = mensagem;
				this._resetaForm();
			})
			.catch(e => this._mensagem.texto = e)
	}

	importaNegociacoes() {

		this._negociacaoService
			.importa(this._listaNegociacoes.negociacoes)
			.then(negociacoes => {
				negociacoes
					.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
				this._mensagem.texto = 'Negociações importadas com sucesso';
			}).catch(erro =>
				this._mensagem.texto = erro
			);
	}

	apaga() {

		this._negociacaoService
			.apagaTodos()
			.then((mensagem) => {
				this._listaNegociacoes.esvazia();
				this._mensagem.texto = mensagem;
			})
			.catch(e => this._mensagem.texto = e);
	}

	_criaNegociacao() {

		return new Negociacao(
			DataHelper.textoParaData(this._inputData.value),
			parseInt(this._inputQuantidade.value),
			parseFloat(this._inputValor.value)
		);
	}

	_resetaForm() {

		this._inputData.value = "";
		this._inputQuantidade.value = "1";
		this._inputValor.value = "0.0";
	}

	ordena(coluna) {
		if (this._ordemAtual == coluna) {
			this._listaNegociacoes.inverteOrdem();
		} else {
			this._listaNegociacoes.ordena((a, b) => a[coluna] - b[coluna]);
		}
		this._ordemAtual = coluna;
	}
}