import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by santoshk on 4/3/18.
 */
public class LamdaExpression1 {

    public static void main(String args[]) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
       // str->test();



        filter(languages, str ->str.toString().startsWith("J"));
       System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.endsWith("a"));
        System.out.println("Print all languages :");
        filter(languages, (str)->true);
        System.out.println("Print no language : ");
        filter(languages, (str)->false);
        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.length() > 4);
    }




    public static void filter(List<String> names, Predicate<String> condition)
    {
        for(String name: names){
            {
                if(condition.test(name)) { System.out.println(name + " "); } } }

    }


     public static void test(){

     }
}



