import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FunctionDefinitionLoader {
    public FunctionDefinition fromFile(Path path) {
        try {
            String definition = Files.readString(path);
            String extension = getExtension(path);
            return new FunctionDefinition(definition, extension);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getExtension(Path path) {
        String fileName = path.getFileName().getFileName().toString();
        int extensionStartIndex = fileName.lastIndexOf(".");
        return fileName.substring(extensionStartIndex + 1);
    }
}
