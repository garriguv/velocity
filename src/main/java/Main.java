import java.io.File;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        File templatesDir = new File(System.getProperty("user.dir"), "src/main/resources");
        System.out.println((new Generator(templatesDir)).generate("spec.vm", new HashMap<String, String>()));
    }
}
