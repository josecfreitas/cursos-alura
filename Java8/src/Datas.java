import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		
		System.out.println(hoje);
		
		LocalDate futuro = LocalDate.of(2099, Month.JANUARY, 25);
		System.out.println(futuro);
		
		
		Period periodo = Period.between(hoje, futuro);
		System.out.println(periodo);
		
		//Para horas
		Duration duration;
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoje.format(formatador));
	}
}
