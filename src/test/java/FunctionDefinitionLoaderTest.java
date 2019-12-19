import org.junit.jupiter.api.Test;

import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionDefinitionLoaderTest {

    @Test
    public void FunctionDefinitionLoader_shouldLoadAFileProperly() {
        FunctionDefinitionLoader loader = new FunctionDefinitionLoader();
        URL resource = this.getClass().getClassLoader().getResource("test.js");

        FunctionDefinition functionDefinition = loader.fromFile(Path.of(resource.getPath()));

        assertEquals("js", functionDefinition.getExtension());
        assertEquals("console.log(\"hi\");", functionDefinition.getDefinition());
    }

}