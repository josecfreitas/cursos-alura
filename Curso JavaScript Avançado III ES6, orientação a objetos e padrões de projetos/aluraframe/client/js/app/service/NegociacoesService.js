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

    obterNegociacoes() {
        return Promise.all([
            this.obterNegociacoesDaSemana(),
            this.obterNegociacoesDaSemanaAnterior(),
            this.obterNegociacoesDaSemanaRetrasada()
        ])
            .then(negociacao =>
                negociacao.reduce((novoArray, item) => novoArray.concat(item), []));
    }

    cadastra(negociacao) {

        return ConnectionFactory
            .getConnection()
            .then(connection => new NegociacoesDAO(connection))
            .then(negociacoesDAO => negociacoesDAO.adiciona(negociacao))
            .then(() => 'Negociação adicionada com sucesso!')
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi possível cadastrar a negociação')
            });
    }

    apagaTodos() {

        return ConnectionFactory
            .getConnection()
            .then(connection => new NegociacoesDAO(connection))
            .then(negociacoesDAO => negociacoesDAO.apagaTodos())
            .then(() => 'Negociações apagadas com sucesso')
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi possível apagar as negociações')
            });
    }

    listaTodos() {

        return ConnectionFactory
            .getConnection()
            .then(connection => new NegociacoesDAO(connection))
            .then(negociacoesDAO => negociacoesDAO.listaTodas())
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi possível listar as negociações')
            });
    }

    importa(listaNegociacoes) {
        return this
            .obterNegociacoes()
            .then(negociacoes =>
                negociacoes.filter(negociacao =>
                    !listaNegociacoes.some(negociacaoExistente =>
                        negociacao.equals(negociacaoExistente))))
            .catch(erro => {
                console.log(erro);
                throw new Error('Não foi possível importar as negociações');
            });
    }
}