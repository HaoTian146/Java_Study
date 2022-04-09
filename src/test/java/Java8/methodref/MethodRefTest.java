package Java8.methodref;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Author th
 * @Description 方法引用：
 * 使用：
 * 对象 :: 非静态方法
 * 类 :: 静态方法
 * 类 :: 非静态方法
 * 使用要求：
 * 接口中的抽象方法的形参列表和返回值类型 与 方法引用的形参列表和返回值类型 相同！
 */
public class MethodRefTest {
    // 情况1： 对象 :: 实例方法
    // Consumer中的void accept(T t)
    // PrintStream中的void println(T t)
    @Test
    public void test1() {
        String s1 = "hello";

        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("**************");
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("beijing");

    }

    // 情况2： 类 :: 静态方法
    // Comparator中的int compare(T t1, T t2)
    // Intger中的int compare(T t1, T t2)
    @Test
    public void test2() {
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(12, 21));
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(21, 1));
    }

    // 情况3：类 :: 实例方法
    // Comparator中的int compare(T t1, T t2)
    // String中的int t1.compareTo(t2)
    @Test
    public void test3() {
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abd"));
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("acd", "a"));

        // BiPredicate中的boolean test(T t1, T t2)
        // String 中的boolean t1.equals(t2)
        BiPredicate<String, String> pre1 = (s1, s2) -> s1.equals(s2);
        System.out.println(pre1.test("abc", "abd"));
        BiPredicate<String, String> pre2 = String::equals;
        System.out.println(pre2.test("abc", "abc"));
    }
}
