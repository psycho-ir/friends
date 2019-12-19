import org.graalvm.polyglot.Value;

public class FriendsFunction {
    private final Value value;

    private FriendsFunction(Value value) {
        this.value = value;
    }

    public Value run(Object... arguments) {
        return value.execute(arguments);
    }

    public static FriendsFunction from(Value value) {
        if (value.canExecute()) {
            return new FriendsFunction(value);
        }
        throw new NonFunctionException();
    }
}

