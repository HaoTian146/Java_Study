package Java8.stream;

import Java8.methodref.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author th
 * @Description 1. stream 关注数据的运算 与cpu有关
 * 集合关注数据的存储，与内存有关
 * 2.
 * stream自己不会存储元素
 * stream不改变源对象。相反他们会返回一个持有结果的新stream
 * stream操作式延迟执行的，意味着我们可以等到需要结果时才执行
 * 3.
 * stream执行流程
 * 实例化
 * 中间操作 对源数据进行处理
 * 终止操作 一旦执行终止，就执行中间操作连，并产生结果，之后不会在被使用
 */
public class StreamTest {
    // 创建方式1：集合
    @Test
    public void test1() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "wang"));
        students.add(new Student(2, "li"));
        students.add(new Student(3, "zhou"));
        students.add(new Student(4, "wahaha"));
        students.add(new Student(5, "nihao"));
        // default Stream<E> stream(): 返回一个顺序流
        Stream<Student> stream = students.stream();
        // default Stream<E> parallelStream(): 返回一个并行流
        Stream<Student> paralleStream = students.parallelStream();
    }

    // 创建方式2：数组
    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.stream(arr).sum());
        // 调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        IntStream intStream = Arrays.stream(arr);
        System.out.println(intStream.max().isPresent());
        Student s1 = new Student(1, "Tom");
        Student s2 = new Student(2, "jim");
        Student s3 = new Student(3, "luxi");
        Student[] arr1 = new Student[]{s1, s2, s3};
        Stream<Student> studentStream = Arrays.stream(arr1);

    }

    // 创建方式3：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);
    }

    // 创建方式4：创建无限流
    @Test
    public void test4() {
        // 迭代  有参
        // public static<T> iterate(fianl T seed, final UnaryOperator<T> f)
        // 便利前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        // 生成 无参
        // public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
