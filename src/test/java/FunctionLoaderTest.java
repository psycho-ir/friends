import org.graalvm.polyglot.Context;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class FunctionLoaderTest {
    Context ctx = Context.newBuilder().allowAllAccess(true).build();
    FunctionLoader loader = new FunctionLoader(ctx);

    @Test
    public void load_shouldLoadFunction() {
        var code = "lambda x,y: x+y";
        FriendsFunction function = loader.load("x", new FunctionDefinition(code, "python"));

        var result = function.run(2, 3);
        var sumResult = result.asInt();
        assertEquals(5, sumResult);
    }

    @Test
    public void load_shouldThrowExceptionIfLangIsNotValid() {
        assertThrows(RuntimeException.class, () ->
                loader.load("f", new FunctionDefinition("", "cobol"))
        );
    }
}