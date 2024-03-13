// Por Grégori Pintarelli

public class Produto {
    private String nome;
    private long segmento;
    
    public Produto (String nome, long segmento) {
        setNome(nome);
        setSegmento(segmento);
    }

    public String getNome() {
        return nome;
    }
    public long getSegmento() {
        return segmento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSegmento(long segmento) {
        this.segmento = segmento;
    }

    public String toString() {
        return "Nome do produto: " + getNome() + " | Segmento: " + getSegmento();
    }
}