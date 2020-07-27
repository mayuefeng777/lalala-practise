import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>(16);
        map.put("1", 1);
        map.put("2", 2);
        //key存在时 更新value为key与旧value计算后的结果 否则不执行
        map.computeIfPresent("1", (key, oldValue) -> key.length() + oldValue);
        //key存在时 更新value为新旧value计算后的结果 否则插入新value
        map.merge("2", 2, (oldValue, newValue) -> oldValue + newValue);
        map.forEach((k, v) -> System.out.print(k + v + ","));
        System.out.println();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(7);
        list.add(6);
        list.add(7);
        list.add(7);
        list.add(111);
        list.sort(Comparator.comparing(i -> i));
        list.removeIf(i -> i > 10);
        list.forEach(i -> System.out.print(i + ","));

        System.out.println();





        //stream操作： 创建stream + 多个中间操作（过滤，转换，排序，截取等） + 一次聚合操作





        //常见创建stream方式

        System.out.println("=============== 创建stream =============");
        //直接声明所有元素
        Stream.of(1, 2, 3, 4, 5)
                .forEach(i -> System.out.print(i + ","));
        System.out.println();

        // 集合类转换 非并行stream
        list.stream()
                .forEach(i -> System.out.print(i + ","));
        System.out.println();

        // 集合类转换 并行stream
        list.parallelStream()
                .forEach(i -> System.out.print(i + ","));
        System.out.println();

        //生成无限长度的stream 通常配合limit使用
        Stream.generate(Random::new)
                .limit(10)
                .mapToInt(Random::nextInt)
                .forEach(i -> System.out.print(i + ","));
        System.out.println();

        System.out.println("=============== 创建stream =============");






        System.out.println("===============  中间操作  =============");

        //过滤
        list.stream()
                .filter(i -> i < 4)
                .forEach(i -> System.out.print(i + ","));
        System.out.println();

        //去重
        list.stream()
                .distinct()
                .forEach(i -> System.out.print(i + ","));
        System.out.println();

        //排序
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(i -> System.out.print(i + ","));
        System.out.println();

        //转换 A转换为B
        list.stream()
                .map(i -> i * 10)
                .forEach(i -> System.out.print(i + ","));
        System.out.println();

        //转换 A转换为集合B
        Stream.of("a-b", "b-c", "def", "g-g-g")
                .flatMap(s -> Arrays.stream(s.split("-")))
                .forEach(i -> System.out.print(i + ","));
        System.out.println();

        //截取 注意先后顺序 会导致结果不同
        list.stream()
                //去头 去掉第n个之前第元素 包括n
                .skip(1)
                //去尾 去掉第n个之后第元素 不包括n
                .limit(5)
                .forEach(i -> System.out.print(i + ","));
        System.out.println();

        //注意点 多次中间操作也只循环一次 聚合的时候一起按顺序执行所有函数
        list.stream()
                .peek(i -> System.out.print(i + ","))
                .map(i -> i * 10)
                .peek(i -> System.out.print(i + ","))
                .map(i -> i * 10)
                .forEach(i -> System.out.print(i + ","));
        System.out.println();

        System.out.println("===============  中间操作  =============");







        System.out.println("===============  聚合操作  =============");

        //collect 配合Collectors使用
        List<Integer> score = Stream.of(100, 64, 98, 77, 54, 44, 74, 73, 89, 88, 88)
                .collect(Collectors.toList());
        System.out.println("score：" + score.toString());

        //findFirst 获取第一个元素
        score.stream()
                .findFirst()
                .ifPresent(i -> System.out.print("findFirst" + i));

        //max 获取某种条件下最大的元素
        score.stream()
                .max(Comparator.comparing(i -> i % 10))
                .ifPresent(i -> System.out.print("max" + i));

        //count 获取元素数量 及格数量
        long count = score.stream()
                .filter(i -> i >= 60)
                .mapToDouble(d->d.doubleValue())
                .count();
        System.out.println("count:" + count);

        //获取集合统计结果 包含总数，平均数，最大值，最小值等 前提为数字类型Stream（IntStream，LongStream, DoubleStream）
        IntSummaryStatistics statistics = score.stream()
                .mapToInt(i -> i)
                .summaryStatistics();
        System.out.println(statistics.toString());

        //reduce 聚合遍历转换 两个入参 分别为前一个元素转换结果和该元素本身 返回最后一个元素转换结果

        //1。reduce(BinaryOperator<T> accumulator)
        // 求积
        Stream.of(1, 2, 3, 4)
                .reduce((lastResult, i) -> lastResult * i)
                .ifPresent(finalResult -> System.out.println("reduce:" + finalResult));

        //2。reduce(T identity, BinaryOperator<T> accumulator)
        // 求和 identity为初始值 第一个元素与初始值共同作为转换入参
        Integer sum = Stream.of(1, 2, 3, 4)
                .reduce(0, (lastResult, i) -> lastResult + i);
        System.out.println("reduce:" + sum);

        //3。reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner);
        //非并行是与上面相同 第二个参数无效
        Integer result = Stream.of(1, 2, 3, 4)
                .reduce(2, (identity, i) -> identity + i, (lastResult, i) -> lastResult * i);
        System.out.println("reduce:" + result);
        //并行时 所有元素先与初始值作为转换入参
        result = Stream.of(1, 2, 3, 4)
                .parallel()
                .reduce(2, (identity, i) -> identity + i, (lastResult, i) -> lastResult * i);
        System.out.println("reduce:" + result);
        //上述并行reduce结果等同于如下
        Stream.of(1, 2, 3, 4)
                .map(i -> i + 2)
                .reduce((lastResult, i) -> lastResult * i)
                .ifPresent(finalResult -> System.out.println("reduce:" + finalResult));

        System.out.println("===============  聚合操作  =============");







        System.out.println("===============  Collectors  =============");

        //转Set
        Set<Integer> set = Stream.of(100, 64, 98, 77, 54, 44, 74, 73, 89, 88, 88)
                .collect(Collectors.toSet());
        System.out.println("toSet:" + set);

        //转map 注意点 key不能为null 且不能重复
        Map<String, Integer> map1 = Stream.of(100, 64, 98, 77, 54, 44, 74, 73, 89, 88)
                .collect(Collectors.toMap(String::valueOf, i -> i));
        System.out.println("toMap:" + map1);

        //partitioningBy 转map，key为boolean 及格和不及格数量
        Map<Boolean, Long> map2 = Stream.of(100, 64, 98, 77, 54, 44, 74, 73, 89, 88, 88)
                .collect(Collectors.partitioningBy(i -> i >= 60, Collectors.counting()));
        System.out.println("partitioningBy:" + map2);

        //groupingBy 分组转map，每10分分一个组 value为分组集合
        Map<Integer, List<Integer>> map3 = Stream.of(100, 64, 98, 77, 54, 44, 74, 73, 89, 88, 88)
                .collect(Collectors.groupingBy(i -> i / 10));
        System.out.println("groupingBy:" + map3);
        //groupingBy 分组转map，每10分分一个组 value为每组数量
        Map<Integer, Long> map4 = Stream.of(100, 64, 98, 77, 54, 44, 74, 73, 89, 88, 88)
                .collect(Collectors.groupingBy(i -> i / 10, Collectors.counting()));
        System.out.println("groupingBy:" + map4);
        //averagingInt 分组转map，每10分分一个组 value为每组数量
        Integer sum2 = Stream.of(100, 64, 98, 77, 54, 44, 74, 73, 89, 88, 88)
                .collect(Collectors.summingInt(i -> i));
        System.out.println("summingDouble:" + sum2);


        System.out.println("===============  Collectors  =============");


    }
}
