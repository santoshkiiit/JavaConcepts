public class LambaExpression2 {
    public static void main(String[] args) {

        // Lambda expression with single parameter.  
        Sayable s1=(name)->{
            return "Hello, "+name;
        };


        // without function parentheses
        Sayable s2= name ->{
            return "Hello, "+name;
        };

    }
    public interface Sayable {

        public String say(String name);

    }

}  