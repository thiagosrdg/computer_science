// CÓDIGO CRIADO PELA DUPLA RODRIGO PY && THIAGO RODRIGUES

public class Produto {
    private int codigo;
    private String descricao;
    private int quantidade; 
    private double peso;
    
    public Produto(int codigo, String descricao, int quantidade, double peso) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.peso = peso;
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
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
