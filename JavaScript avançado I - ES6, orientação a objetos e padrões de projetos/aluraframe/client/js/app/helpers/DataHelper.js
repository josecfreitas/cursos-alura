class DataHelper{

	constructor(){

		throw new Error("Essa classe não pode ser instanciada.");
	}

	static textoParaData(texto){

		if(!/^\d{4}-\d{2}-\d{2}$/.test(texto))
			throw "Esse texto não pode ser convertido para data. Deve estar no formato aaaa-mm-dd";
		return new Date(texto.split('-'));
	}

	static dataParaTexto(data){

		return `${data.getDate()}/${data.getMonth()+1}/${data.getFullYear()}`;
	}
}