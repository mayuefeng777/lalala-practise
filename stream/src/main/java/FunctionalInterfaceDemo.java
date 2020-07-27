import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaceDemo {
    /**
     * Runnable 无入参 无返回值
     */
    Runnable runnable = () -> {
        System.out.println("lalala");
    };

    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("lalala");
        }
    };

    /**
     * Function 有入参 有返回值
     */
    Function<String, Integer> function = s -> {
        return s.length();
    };
    Function<String, Integer> function2 = String::length;

    /**
     * Consumer 有入参 无返回值
     */
    Consumer<String> consumer = s -> {
        System.out.println(s);
    };
    Consumer<String> consumer2 = System.out::println;

    /**
     * Supplier 无入参 有返回值
     */
    Supplier<String> supplier = () -> {
        return "lalala" + "lalala";
    };

    /**
     * Predicate 有入参 返回boolean值
     */
    Predicate<String> predicate = s -> {
        return s.isEmpty();
    };
    Predicate<String> predicate2 = String::isEmpty;

    /**
     * 其他常见函数式接口
     */

    BiFunction<String, String, Integer> function3 = (s1, s2) -> s1.length() + s2.length();
    BinaryOperator<String> function4 = (s1, s2) -> s1 + s2;
    BiConsumer<String, String> consumer3 = (s1, s2) -> System.out.println(s1 + s2);



    BiPredicate<String, String> predicate3 = (s1, s2) -> s1.length() == s2.length();

    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.forEach((key, value)->{
            System.out.println(key+value);
        });

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s+s2);
            }
        });

    }
}
