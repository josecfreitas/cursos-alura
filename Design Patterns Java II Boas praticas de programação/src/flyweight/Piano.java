package flyweight;

import java.util.List;
import java.util.stream.Collectors;

import org.jfugue.player.Player;

import flyweight.nota.Nota;

public class Piano {

	private Player player;
	
	
	public Piano() {
		player = new Player();
	}

	public void toca(List<Nota> musica) {
		player.play(musicaToString(musica));
	}

	private String musicaToString(List<Nota> musica) {
		return musica
				.stream()
				.map(Nota::simbolo)
				.collect(Collectors.joining(" "));
	}
}
