// Por Grégori Pintarelli

public class Produto {
    private String nome;
    private double valor;
    
    public Produto (String nome, double valor) {
        setNome(nome);
        setValor(valor);
    }

    public String getNome() {
        return nome;
    }
    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString() {
        return "Nome do produto: " + getNome() + " | Valor: R$ " + getValor();
    }
}