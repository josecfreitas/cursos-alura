class ListaNegociacoes{

	constructor(){

		this._negociacoes = [];
	}

	adiciona(negociacao){

		this._negociacoes.push(negociacao);
		console.log(this._negociacoes);
	}

	get negociacoes(){

		return [].concat(this._negociacoes);
	}
}