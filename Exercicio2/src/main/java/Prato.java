public class Prato {
    private String nome;
    private float preco;
    private String descricao;

    public Prato(String nome, float preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() { return nome; }

    public float getPreco() { return preco; }

    public String getDescricao() { return descricao; }

    @Override
    public String toString() {
        return "Prato{" +
                "nome='" + nome + '\'' +
                ", preco='" + preco + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
