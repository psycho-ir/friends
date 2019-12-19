import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class FunctionLoader {
    private Context context;

    public FunctionLoader(Context context) {
        this.context = context;
    }

    public FriendsFunction load(String functionName, String functionDefinition, String language) {
        try {
            final Value value = context.eval(language, functionDefinition);
            return FriendsFunction.from(value);
        } catch (Exception e) {
            System.err.println(String.format("Error in loading function %s", functionName));
            e.printStackTrace();
            throw e;
        }
    }
}
