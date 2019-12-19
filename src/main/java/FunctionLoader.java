import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class FunctionLoader {
    private Context context;

    public FunctionLoader(Context context) {
        this.context = context;
    }

    public FriendsFunction load(String functionName, FunctionDefinition functionDefinition) {
        try {
            final Value value = context.eval(functionDefinition.getExtension(), functionDefinition.getDefinition());
            return FriendsFunction.from(value);
        } catch (Exception e) {
            System.err.println(String.format("Error in loading function %s", functionName));
            e.printStackTrace();
            throw e;
        }
    }
}
