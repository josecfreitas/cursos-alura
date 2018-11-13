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
	}

	adiciona(event) {

		event.preventDefault();

		this._listaNegociacoes.adiciona(this._criaNegociacao());
		this._mensagem.texto = 'Negociação adicionada com sucesso!';

		this._resetaForm();
	}

	importaNegociacoes() {

		let negociacoesService = new NegociacoesService();

		Promise.all([
			negociacoesService.obterNegociacoesDaSemana(),
			negociacoesService.obterNegociacoesDaSemanaAnterior(),
			negociacoesService.obterNegociacoesDaSemanaRetrasada()
		]).then(negociacoes => {
			negociacoes
				.reduce((novoArray, item) => novoArray.concat(item), [])
				.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
			this._mensagem.texto = 'Negociações importadas com sucesso';
		}).catch(erro =>
			this._mensagem.texto = erro
		);
	}

	apaga() {

		this._listaNegociacoes.esvazia();

		this._mensagem.texto = "Negociações apagadas com sucesso.";
	}

	_criaNegociacao() {

		return new Negociacao(
			DataHelper.textoParaData(this._inputData.value),
			this._inputQuantidade.value,
			this._inputValor.value
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