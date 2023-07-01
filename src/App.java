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
    public static void main(String[] args) throws Exception {
        /*
         * Pessoa p1 = new Pessoa(1, "Name");
         * 
         * serializar("serial.txt", p1);
         * Pessoa p2 = (Pessoa) desserializar("serial.txt");
         * 
         * System.out.println(p2);
         */

        ArrayList<Pessoa> pessoas = new ArrayList<>(Arrays.asList(
                new Pessoa(2, "Alfa"),
                new Pessoa(4, "Beta"),
                new Pessoa(8, "Gama"),
                new Pessoa(16, "Delta"),
                new Pessoa(32, "Épsilon"),
                new Pessoa(64, "Zeta"),
                new Pessoa(128, "Eta"),
                new Pessoa(256, "Teta")));

            serializar("serial.txt", pessoas);
            @SuppressWarnings("unchecked")
            ArrayList<Pessoa> pessoas2 = (ArrayList<Pessoa>) desserializar("serial.txt");
            
            Iterator<Pessoa> it = pessoas2.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
    }

    public static void serializar(String path, Object obj) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.flush();
        oos.close();
    }

    public static Object desserializar(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fip = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fip);
        Object obj = ois.readObject();

        ois.close();

        return obj;

    }
}
