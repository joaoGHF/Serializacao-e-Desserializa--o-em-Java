import java.io.Serializable;
/**
 * Classe {@code Pessoa} que implementa {@link Serializable}
 * @see Serializable
 */
public class Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;
    private int idade;
    private String nome;

    /**
     * Constructor que recebe os parametros {@code int idade} e {@code String nome}
     * @param idade
     * @param nome
     */
    public Pessoa(int idade, String nome) {
        this.idade = idade;
        this.nome = nome;
    }

    //Gettres e Setters

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Pessoa{" +
                "UID=" + serialVersionUID + 
                ";nome=" + nome +
                ";idade=" + idade +
                "}";
    }
}
