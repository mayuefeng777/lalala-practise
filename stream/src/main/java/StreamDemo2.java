import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo2 {

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.forEach(i -> System.out.println(i));

        int SIZE = 10000;


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }

        Stream<Integer> stream = list.stream();
        Stream<Integer> stream2 = list.stream();

        long start = System.currentTimeMillis();
        for (Integer i : list) {
            System.out.println(i + 50000000);
        }
        long start2 = System.currentTimeMillis();
        list.forEach(i -> System.out.println(i + 10000000));
        long start3 = System.currentTimeMillis();
        stream2.forEach(i -> System.out.println(i + 40000000));
        long start4 = System.currentTimeMillis();
        for (int j = 0; j < SIZE; j++) {
            System.out.println(list.get(j) + 30000000);
        }
        long start5 = System.currentTimeMillis();
        stream.forEach(i -> System.out.println(i + 20000000));
        long start6 = System.currentTimeMillis();

        System.out.println("time cost1:" + (start2 - start));
        System.out.println("time cost2:" + (start3 - start2));
        System.out.println("time cost3:" + (start4 - start3));
        System.out.println("time cost4:" + (start5 - start4));
        System.out.println("time cost5:" + (start6 - start5));


    }

}
