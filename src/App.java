import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        Pessoa p1 = new Pessoa(16, "Joao");

        serializar("serial.txt", p1);
        Pessoa p2 = (Pessoa) desserializar("serial.txt");

        System.out.println(p2);
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
