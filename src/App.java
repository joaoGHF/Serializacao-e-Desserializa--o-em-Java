import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class App {
    /**
     * Método {@code Main} que executa a serialização e desserialição de objetos com uso da classe {@code Pessoa}
     * @see Pessoa
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        /*
         * Pessoa p1 = new Pessoa(1, "Name");
         * 
         * serializar("serial.txt", p1);
         * Pessoa p2 = (Pessoa) desserializar("serial.txt");
         * 
         * System.out.println(p2);
         */

        // declara e instancia uma ArrayList do tipo Pessoa
        ArrayList<Pessoa> pessoas = new ArrayList<>(Arrays.asList(
                new Pessoa(2, "Alfa"),
                new Pessoa(4, "Beta"),
                new Pessoa(8, "Gama"),
                new Pessoa(16, "Delta"),
                new Pessoa(32, "Épsilon"),
                new Pessoa(64, "Zeta"),
                new Pessoa(128, "Eta"),
                new Pessoa(256, "Teta")));

        // Cria um iterator e percorre-o enquanto imprime cada Pessoa do ArrayList
        Iterator<Pessoa> it = pessoas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        // Método que serializa o objeto 'pessoas' no arquivo 'serial.txt'
        serializar("serial.se", pessoas);
        // Suprime os avisos de unchecked conversions em tempo de compilação
        @SuppressWarnings("unchecked")
        // Armazena em uma ArrayList do tipo Pessoa o cast do retorno da desserialização do arquivo 'serial.txt'
        ArrayList<Pessoa> pessoas2 = (ArrayList<Pessoa>) desserializar("serial.se");

        System.out.println("\n============================\n" +
                    "Depois de serializar de desserializar\n" +
                    "============================\n\n");
        // Imprime a ArrayList novamente
        it = pessoas2.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * Método {@code serializar} que serializa um objeto para um arquivo.
     * @param path do tipo {@code String} que refere-se ao caminho do arquivo
     * @param obj do tipo {@code Object} ou que extende {@link Object}
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void serializar(String path, Object obj) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.flush();
        oos.close();
    }

    /**
     * Método {@code desserializar} que desserializa um arquivo do parâmetro {@code String path} para um objeto da classe {@code Object} e o retorna
     * @param path do tipo {@code String} que refere-se ao arquivo serializado
     * @return Um objeto do tipo {@code Object} contendo o resultado da desserialização
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object desserializar(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fip = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fip);
        Object obj = ois.readObject();

        ois.close();

        return obj;
    }
}
