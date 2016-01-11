import java.io.File;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator(new File(System.getProperty("user.dir"), "src/main/resources"));

        String templateName = "spec.vm";

        HashMap<String, String> templateVariables = new HashMap<String, String>();
        templateVariables.put("NAME", "MyClassSpec");

        System.out.println(generator.generate(templateName, templateVariables));
    }
}
