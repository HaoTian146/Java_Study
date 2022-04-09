package Java8.methodref;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * @Author th
 * @Description
 * 1. 构造器引用
 * 2. 数组引用
 */
public class ConstructorRefTest {
    // 构造器引用
    // Supplier中的 T get()
    // Strudent 的空参构造器 Student()

    @Test
    public void test1() {
        Supplier<Student> sup1 = () -> new Student();
        sup1.get();

        Supplier<Student> sup2 = Student::new;
        sup2.get();
    }

    @Test
    public void test2() {
        String s = "hello";
        String t = "hello";
        char c[] = {'h', 'e', 'l', 'l', 'o'} ;
        System.out.println("s  t:" + s.equals(t));
        System.out.println("t  c:" + t.equals(c));
        System.out.println(s == t);
        System.out.println(t.equals(new String("hello")));


    }
}
