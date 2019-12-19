import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class Application {
    public static void main(String[] args) {
        Context ctx = Context.newBuilder().allowAllAccess(true).build();
        Value function = ctx.eval("js", "(request) => { return {status:200}}");
        FriendsValue response = FriendsValue.from(function.execute(new Person("soo", "soroosh")));
        System.out.println(new Response(response.getMemberOr("status", 200).asInt()));
    }

    public static class Response {
        public Response(int status) {
            this.status = status;
        }

        public int status;

        @Override
        public String toString() {
            return "Response{" +
                    "status=" + status +
                    '}';
        }
    }

    public static class Person {
        public String name;
        public String lastName;

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        public Person(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}
