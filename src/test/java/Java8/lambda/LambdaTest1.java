package Java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * <p>
 * 1. 举例 (o1, o2) -> Integer.compare(o1, o2);
 * 2. 格式：
 * -> ： lambda操作符 或 箭头操作符
 * ->左： lambda形参列表
 * ->右： lambda体（重写的抽象方法体）
 * 3. 使用：
 * <p>
 * 4. lambda表达式本质： 作为函数接口的实例
 * 5. 如果一个接口中，只声明了一个抽象方法，则此接口就成为函数式接口，可以在接口上用@FunctionalInterface检验是否为函数式接口
 * 6. 以前匿名实现类可以用lambda表达式来实现
 *
 * @Author th
 * @Description TODO
 */
public class LambdaTest1 {

    // 语法1：无参、无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱学java");
            }
        };

        r1.run();

        System.out.println("**********************");

        Runnable r2 = () -> System.out.println("我爱学习算法");

        r2.run();
    }

    // 语法2：lambda需要一个参数，但没有返回值
    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和试验的区别");

        System.out.println("********************");

        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("没有区别");

    }

    // 语法3：数据类型可以省略，可有编译器推断得出，称为类型推断
    @Test
    public void test3() {
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("类型判断");
        System.out.println("****************");

        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("肯定行！");

        // 语法4：只有一个参数 参数的小括号可以省略
        Consumer<String> con3 = s -> System.out.println(s);
        con3.accept("简介！");
    }

    @Test
    public void test4() {
        // 类型推断
        ArrayList<String> list = new ArrayList<>();
        int[] arr = {1, 2, 3};
    }

    // 语法5：需要两个或者两个以上的参数，多条执行语句，可以右返回值
    @Test
    public void test5() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 21));
        System.out.println("************");
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12, 2));
    }

    // 语法6 lambda只有一条语句 return 与 大括号都能省略
    @Test
    public void test6() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 21));
        System.out.println("************");
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);

        System.out.println(com2.compare(12, 2));
    }
}
