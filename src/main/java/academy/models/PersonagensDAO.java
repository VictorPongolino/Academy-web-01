package academy.models;
import java.util.List;
import java.util.Optional;

public class PersonagensDAO {
	
	private List<Personagem> personagens = Personagens.getTodos();
	
	public List<Personagem> getTodos() {
		return personagens;
	}
	
	public Optional<Personagem> getById(Long id) {
		return personagens.stream()
				.filter(x -> x.getId().equals(id))
				.findFirst();
	}

	public void adicionar(Long id, String nome) {
		if (getById(id).isEmpty()) {
			personagens.add(new Personagem(id, nome));
		} else {
			throw new EntidadeExistenteException(String.format("Este ID já existe (%d) !", id));
		}
	}
	
	public void editar (Long id, Personagem personagem) {
		Optional<Personagem> personagemBanco = getById(id);
		if (personagemBanco.isPresent()) {
			Personagem personagemSalvar = personagemBanco.get();
			personagemSalvar.setNome(personagem.getNome());
		} else {
			throw new EntidadeExistenteException(String.format("Este ID não existe (%d) !", id));
		}
	}
	
	public void deletar (Long id) {
		Optional<Personagem> personagem = getById(id);
		if (personagem.isPresent()) {
			personagens.remove(personagem.get());
		} else {
			throw new EntidadeExistenteException(String.format("Este ID não existe (%d) !", id));
		}
	}
}
