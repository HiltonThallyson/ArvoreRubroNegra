package ARN;

public class Pessoa implements Indexable , Comparable<Pessoa>{
    private int chave;

    public Pessoa(int chave) {
        this.chave = chave;
    }

    public int getKey() {
        return chave;
    }

    @Override
    public int compareTo(Pessoa pessoa) {
        return getKey() - pessoa.getKey();
    }
}
