package academy.models;

public class EntidadeExistenteException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntidadeExistenteException(String mensagem) {
		super(mensagem);
	}
}
