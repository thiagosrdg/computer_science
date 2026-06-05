/* Integranetes:
- Murilo Neves
- Thiago Rodrigues
- Bernardo Siqueira
 */
public class Candidato {
    private int numero;
    private String nome;
    private String partido;
    private int IntencoesVotos;

    public Candidato(int numero, String nome, String partido) {
        this.numero = numero;
        this.nome = nome;
        this.partido = partido;
        this.IntencoesVotos = 0;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getPartido() {
        return partido;
    }

    public int getIntencoesVotos() {
        return IntencoesVotos;
    }

    public void setIntencoesVotos(int intencoesVotos) {
        IntencoesVotos = intencoesVotos;
    }

    @Override
    public String toString() {
        return numero + " - " + nome + " - " + partido + " - " + IntencoesVotos + " votos";
    }
}