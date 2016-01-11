import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class GeneratorTest {
    @Test public void testGenerate() {
        Generator subject = new Generator();
        assertEquals("generate() should return 'Hello World!'",
                subject.generate(new HashMap<String, String>()),
                "Hello World!");
    }
}
