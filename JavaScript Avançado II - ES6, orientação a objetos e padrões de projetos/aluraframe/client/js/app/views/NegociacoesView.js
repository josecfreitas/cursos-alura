class NegociacoesView extends View {

	template(model){

		return `
			<table class="table table-hover table-bordered">
		        <thead>
		            <tr>
		                <th>DATA</th>
		                <th>QUANTIDADE</th>
		                <th>VALOR</th>
		                <th>VOLUME</th>
		            </tr>
		        </thead>
		        
		        <tbody>
		        	${model.negociacoes.map(i => 
		        		`
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
		        		<td>${model.negociacoes.reduce((total, i) => total + i.volume, 0)}</td>
		        	</tr>
		        </tfoot>
		    </table>
		`;
	}
}