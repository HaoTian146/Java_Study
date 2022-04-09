package Java8.lambda;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Comparator;

/**
 * Lambda表达式举例123321312132
 *
 * @Author th
 * @Description TODO
 */
public class LambdaTest {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    public static void test1() {
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

    public static void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);
        System.out.println("**************");
        // Lambda表达式写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com2.compare(32, 21));

        System.out.println("**************");
        // 方法引用
        Comparator<Integer> com3 = Integer::compare;
        System.out.println(com3.compare(10, 20));

    }
}
