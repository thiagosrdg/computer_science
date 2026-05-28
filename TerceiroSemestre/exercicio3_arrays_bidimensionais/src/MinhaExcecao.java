public class MinhaExcecao extends RuntimeException{

	// Guarda a mensagem de erro que será mostrada no console.
	private String mensagem;
	
	// Recebe a mensagem no momento em que a exceção é criada.
	public MinhaExcecao(String mensagem){
		this.mensagem = mensagem;
	}
	
	// Define o texto exibido quando o objeto da exceção é impresso.
	public String toString(){
		return mensagem;
	}
}
