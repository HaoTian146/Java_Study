package Java8.stream;

import Java8.methodref.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author th
 * @Description 测试Stream 中间操作
 */
public class StreamMidTest {

    // 筛选与切片
    @Test
    public void test() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "wang"));
        students.add(new Student(110, "wang"));
        students.add(new Student(110, "wang"));
        students.add(new Student(110, "wang"));
        students.add(new Student(2, "li"));
        students.add(new Student(3, "zhou"));
        students.add(new Student(4, "wahaha"));
        students.add(new Student(5, "nihao"));

        // filter(Predicate p)--接收Lambda，从流中排除某些元素
        Stream<Student> stream = students.stream();
        // 练习查询学生id大于1的学生信息
        stream.filter(s -> s.getId() > 1).forEach(System.out::println);
        // 截断流 limit(n) 使其元素不超过给定数量
        students.stream().limit(3).forEach(System.out::println);
        System.out.println("skip");
        // skip(n) 返回一个扔掉了n个元素的流,没有那么多就返回一个空流
        students.stream().skip(5).forEach(System.out::println);
        System.out.println("skipend");
        // distinct()
        students.stream().distinct().forEach(System.out::println);
    }

    // 映射
    @Test
    public void test2() {
        // map(Function f) 接收一个函数作为参数，将元素转换成其他形式或提取信息,
        // 该函数会映射到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream()
                .map(str -> str.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);

        System.out.println();
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "王老五"));
        students.add(new Student(2, "里斯"));
        students.add(new Student(3, "朝气"));
        students.add(new Student(4, "哇哈哈"));
        students.add(new Student(5, "扎西德勒"));

        // 获取学生姓名长度大于3的员工姓名
        students.stream()
                .map(Student::getName)
                .filter(name -> name.length() > 3)
                .forEach(System.out::println);

        // flatMap(Function f) 接收一个函数，
        // 将流中的每个值都换成另一个流，然后把所有流链接成一个流


    }

    // 排序
    @Test
    public void test3() {
        // sorted自然排序
        List<Integer> list = Arrays.asList(12,21,34,56,78,98,435);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("!@3");
        // sorted(Comparator com)定制排序
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "王老五"));
        students.add(new Student(2, "里斯"));
        students.add(new Student(3, "朝气"));
        students.add(new Student(4, "哇哈哈"));
        students.add(new Student(5, "扎西德勒"));

        // students.stream().sorted((e1, e2) -> -Integer.compare(e1.getId(), e2.getId())).forEach(System.out::println);
        Optional<Student> first = students.stream().sorted((e1, e2) -> -Integer.compare(e1.getId(), e2.getId())).findFirst();
        System.out.println(first);
    }
}
