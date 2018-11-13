class NegociacoesService {

    constructor() {

        this._http = new HttpService();
    }

    obterNegociacoesDaSemana() {

        return this._http.get('negociacoes/semana')
            .then(negociacoes =>
                this._mapeiaAsNegociacoes(negociacoes)
            ).catch(erro => {
                console.log("Erro do servidor: " + erro);
                reject("Não foi possível importar as negociações");
            })
    }

    obterNegociacoesDaSemanaAnterior() {

        return this._http.get('negociacoes/anterior')
            .then(negociacoes =>
                this._mapeiaAsNegociacoes(negociacoes)
            ).catch(erro => {
                console.log("Erro do servidor: " + erro);
                reject("Não foi possível importar as negociações da semana anterior");
            })
    }

    obterNegociacoesDaSemanaRetrasada() {

        return this._http.get('negociacoes/retrasada')
            .then(negociacoes =>
                this._mapeiaAsNegociacoes(negociacoes)
            ).catch(erro => {
                console.log("Erro do servidor: " + erro);
                reject("Não foi possível importar as negociações da semana retrasada");
            })
    }

    _mapeiaAsNegociacoes(negociacoes) {
        return negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor))
    }
}