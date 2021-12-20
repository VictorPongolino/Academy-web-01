package academy.models;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Personagens {
	private static List<Personagem> personagens = new ArrayList<>();
	
	static {
		personagens = Arrays.asList(new Personagem(1L, "Demogorgon"),
							  new Personagem(2L, "Ghost face"),
							  new Personagem(3L, "Pyramid Head"),
							  new Personagem(4L, "Michael Myers"),
							  new Personagem(5L, "Freddy Krueger"));
	}

	public static List<Personagem> getTodos() {
		return personagens;
	}
}
