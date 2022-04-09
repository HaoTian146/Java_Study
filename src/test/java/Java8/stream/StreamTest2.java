package Java8.stream;

import Java8.methodref.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author th
 * @Description
 * Strem 终止操作
 */
public class StreamTest2 {
    // 匹配与查找
    @Test
    public void test1() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "王老五"));
        students.add(new Student(2, "里斯"));
        students.add(new Student(3, "朝气"));
        students.add(new Student(4, "哇哈哈"));
        students.add(new Student(5, "扎西德勒"));
        // allMath(Predicate p) 检查是否匹配所有元素
        // 练习：是否学生的id都大于0
        boolean b = students.stream().allMatch(e -> e.getId() > 5);
        System.out.println(b);
        // noneMatch(Predicate p) 检查是否没有匹配的元素
        // 练习：是否有员工姓王
        boolean b1 = students.stream().noneMatch(e -> e.getName().startsWith("王"));
        System.out.println(b1);
        // findFirst 返回第一个元素
        System.out.println(students.stream().findFirst());
        System.out.println();
        // findAny 返回当前流的任意元素
        System.out.println(students.parallelStream().findAny());

    }

    @Test
    public void test2() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "王老五"));
        students.add(new Student(2, "里斯"));
        students.add(new Student(3, "朝气"));
        students.add(new Student(4, "哇哈哈"));
        students.add(new Student(5, "扎西德勒"));
        // count 求个数
        System.out.println(students.stream().count());
        System.out.println(students.stream().filter(e -> e.getId() > 0).count());
        // max(Comparator c) 返回流中的最大值
        // 练习
        System.out.println(students.stream().map(e -> e.getId()).max(Integer::compareTo));
        // min(Comparator c)
        System.out.println(students.stream().min((e1, e2) -> Integer.compare(e1.getId(), e2.getId())));
        // forEach(Consumer c) 内部迭代
        students.stream().forEach(System.out::println );
    }

    // 规约
    @Test
    public void test3() {
        // reduce(T identity, BinaryOperator) 可以反复的将流中的元素反复结合起来，得到一个值,返回T
        // 练习：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "王老五"));
        students.add(new Student(2, "里斯"));
        students.add(new Student(3, "朝气"));
        students.add(new Student(4, "哇哈哈"));
        students.add(new Student(5, "扎西德勒"));

        // reduce(BinaryOperator)-可以将流中的元素反复结合起来，得到一个值。返回Optional<T>
        // 练习：计算所有学生id总和
        Optional<Integer> reduce = students.stream()
                .map(Student::getId)
                .reduce(Integer::sum);
        System.out.println(reduce);
    }

    // 收集
    @Test
    public void test4() {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "王老五"));
        students.add(new Student(2, "里斯"));
        students.add(new Student(3, "朝气"));
        students.add(new Student(4, "哇哈哈"));
        students.add(new Student(5, "扎西德勒"));

        // collect(Collector c) 将流转换成其他形式
        // 练习：查找id大于2的学生， 返回一个list或者set
        List<Student> list = students.stream().filter(e -> e.getId() > 2).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println();
        Set<Student> set = students.stream()
                .filter(e -> e.getId() > 2)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);


    }
}
