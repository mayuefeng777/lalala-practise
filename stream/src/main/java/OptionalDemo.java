import java.util.Optional;

public class OptionalDemo {

    private static int i = 0;

    public static void main(String[] args) {

        boolean s1 = Optional.ofNullable("abcd").isPresent();
        System.out.println(s1);

        Optional.ofNullable("abcd").ifPresent(System.out::println);

        String string = Optional.ofNullable("abcd")
                .filter(s -> s.length() > 3)
                .map(s -> s.toUpperCase())
                .map(s -> s + 10)
                .orElse("aaaa");
        System.out.println(string);
        //没有非空判断直接.get() 值为null时会抛出异常
        int a = Optional.ofNullable(1)
                .get();
        System.out.println(a);

        try {
            int b = Optional.ofNullable(1)
                    .filter(i -> i > 2)
                    .get();
            System.out.println(b);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //orElse orElseGet() 区别

        System.out.println(i);

        Optional.ofNullable(null)
                .orElse(get());
        System.out.println(i);

        Optional.ofNullable(null)
                .orElseGet(OptionalDemo::get);
        System.out.println(i);

        int d = Optional.ofNullable(1)
                .orElse(get());
        System.out.println(i);

        int e = Optional.ofNullable(1)
                .orElseGet(OptionalDemo::get);
        System.out.println(i);

    }

    private static int get() {
        return i++;
    }
}
