package Java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Author th
 * @Description
 * java内置的四大核心函数式接口
 *  消费型接口：Consumer<T> void accept(T t)
 *  供给型接口：Supplier<T> T get()
 *  函数型接口：Function<T,R> R apply(T t)
 *  断言型接口：Predicate<T> boolean test(T t)
 */
public class LambdaTest2 {
    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("买了瓶水，花了" + aDouble);
            }
        });
        System.out.println("****************");
        happyTime(1000, money -> System.out.println("这次花了" + money));
    }
    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "东京", "西京", "普京");
        list.forEach(System.out::println);
        System.out.println("/*/*/*/");
        List<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterString);

        List<String> filterStrs = filterString(list, s -> s.contains("京"));
        System.out.println(filterStrs);
    }
    // 根据给定的规则去过滤集合中的字符串，规则由Predicate决定
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
