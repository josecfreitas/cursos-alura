class NegociacoesView extends View {

	constructor(elemento) {

		super(elemento);
	}

	template(model){

		return `
			<table class="table table-hover table-bordered">
		        <thead>
		            <tr>
						<th onclick="negociacaoController.ordena('data')">DATA</th>
						<th onclick="negociacaoController.ordena('quantidade')">QUANTIDADE</th>
						<th onclick="negociacaoController.ordena('valor')">VALOR</th>
						<th onclick="negociacaoController.ordena('volume')">VOLUME</th>
		            </tr>
		        </thead>
		        
		        <tbody>
		        	${model.negociacoes.map(i => `

		        			<tr>
		        				<td>${DataHelper.dataParaTexto(i.data)}</td>
		        				<td>${i.quantidade}</td>
		        				<td>${i.valor}</td>
		        				<td>${i.volume}</td>
		        			</tr>

		        		`).join('')}
		        </tbody>
		        
		        <tfoot>
		        	<tr>
		        		<td colspan='3'>Volume</td>
		        		<td>${model.volumeTotal}</td>
		        	</tr>
		        </tfoot>
		    </table>
		`;
	}
}