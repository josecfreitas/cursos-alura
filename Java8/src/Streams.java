import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		System.out.println(cursos);

		cursos.stream().filter(c -> c.getAlunos() >= 50).map(Curso::getNome).forEach(System.out::println);

		cursos.stream().mapToInt(Curso::getAlunos).average().ifPresent(System.out::println);

		System.out.println(cursos.stream().filter(c -> c.getAlunos() >= 50).collect(Collectors.toList()));
	}
}
