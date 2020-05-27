import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class FunctionLoader {
    private Context context;

    public FunctionLoader(Context context) {
        this.context = context;
    }

    public FriendsFunction load(String functionName, FunctionDefinition functionDefinition) {
        String extension = functionDefinition.getExtension();
        if (!isLanguageAvailable(extension)) {
            throw new RuntimeException(String.format("Language %s is not available", extension));
        }
        try {
            final Value value = context.eval(extension, functionDefinition.getDefinition());
            return FriendsFunction.from(value);
        } catch (Exception e) {
            System.err.println(String.format("Error in loading function %s", functionName));
            e.printStackTrace();
            throw e;
        }
    }

    private boolean isLanguageAvailable(String language) {
        return context.getEngine().getLanguages().keySet().contains(language);
    }
}
