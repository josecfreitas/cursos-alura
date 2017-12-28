package cap1;

public class Testa {

	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCargo(Cargo.DBA);
		funcionario.setSalarioBase(1000d);
		System.out.println(funcionario.calculaSalario());
	}
}
