public class FunctionDefinition {
    public FunctionDefinition(String definition, String extension) {
        this.definition = definition;
        this.extension = extension;
    }

    private String definition;
    private String extension;

    public String getDefinition() {
        return definition;
    }

    public String getExtension() {
        return extension;
    }
}
