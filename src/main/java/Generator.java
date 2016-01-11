import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;

public class Generator {
    private VelocityEngine _engine;

    public Generator(File templatesPath) {
        _engine = createEngine(templatesPath);
    }

    public String generate(String templateName, Map<String, String> environment) {
        Template template = _engine.getTemplate(templateName);

        VelocityContext context = new VelocityContext(environment);

        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        return writer.toString();
    }

    private VelocityEngine createEngine(File templatesPath) {
        VelocityEngine engine = new VelocityEngine();
        engine.setProperty("resource.loader", "file");
        engine.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        engine.setProperty("file.resource.loader.path", templatesPath.getAbsolutePath());
        engine.init();
        return engine;
    }
}
