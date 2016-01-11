import org.junit.Test;

import java.io.*;
import java.util.HashMap;

import static org.junit.Assert.*;

public class GeneratorTest {
    @Test public void testGenerate() {
        Generator subject = new Generator(getResourcesDir());

        HashMap<String, String> templateVariables = new HashMap<String, String>();
        templateVariables.put("NAME", "MyClassSpec");

        assertEquals("generate() should return the spec",
                fileContent("MyClassSpec.m"),
                subject.generate("spec.vm", templateVariables));
    }

    private String fileContent(String fileName) {
        File file = new File(getResourcesDir(), fileName);
        StringBuilder contents = new StringBuilder();

        try {
            BufferedReader input =  new BufferedReader(new FileReader(file));
            try {
                String line = null;
                while (( line = input.readLine()) != null){
                    contents.append(line);
                    contents.append(System.getProperty("line.separator"));
                }
            }
            finally {
                input.close();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        return contents.toString();
    }

    private File getResourcesDir() {
        return new File(System.getProperty("user.dir"), "src/test/resources");
    }
}
