public class Produto {
    private int codigo;
    private String descricao;
    private int quantidade;
    private double peso;

    public Produto(int codigo, String descricao, int quantidade, double peso) {
        this.codigo = codigo;
        this.descricao = (descricao == null) ? "" : descricao.trim(); //Se não colocar nada na descrição, salva "" (string vazia). Senão, salva descrição trim() que é uma descrição sem espaços sobrando no começo e no fim.
        setQuantidade(quantidade);
        setPeso(peso);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = (descricao == null) ? "" : descricao.trim();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        // regra simples: não permitir negativo
        if (quantidade < 0) {
            this.quantidade = 0;
        } else {
            this.quantidade = quantidade;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        // regra simples: não permitir negativo
        if (peso < 0) {
            this.peso = 0;
        } else {
            this.peso = peso;
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
               ", Descrição: " + descricao +
               ", Quantidade: " + quantidade +
               ", Peso: " + peso;
    }
}
