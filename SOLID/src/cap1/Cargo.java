package cap1;

public enum Cargo {
    DESENVOLVEDOR(new DezOuVintePorcento()),
    DBA(new QuinzeOuVinteCincoPorcento()),
    TESTER(new QuinzeOuVinteCincoPorcento());

	private CalculadoraDeSalario calculadoraDeSalario;

	Cargo(CalculadoraDeSalario calculadoraDeSalario) {
		this.calculadoraDeSalario = calculadoraDeSalario;
	}
	
	public CalculadoraDeSalario getCalculadoraDeSalario(){
		return this.calculadoraDeSalario;
	}
}
