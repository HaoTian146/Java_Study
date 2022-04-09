package basic;

import Java8.methodref.Student;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Author th
 * @Description 数组
 */
public class ArrayTest {
    // 数组复制
    @Test
    public void test1() {
        String[] arr = new String[]{"haha", "wula", "nihao"};
        /*// 1
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // 2
        for (String s : arr) {
            System.out.println(s);
        }
        // 3
        System.out.println(Arrays.toString(arr));*/
        String[] copy = Arrays.copyOf(arr, arr.length * 2);
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println(Arrays.toString(copy));

        String[] arrNew = Arrays.copyOfRange(arr, 0, copy.length);
        System.out.println(Arrays.toString(arrNew));
        String a = "a";

    }

    @Test
    public void test2() {
        // Scanner in = new Scanner(System.in);
        // System.out.println("抽取几个");
        // int k = in.nextInt();
        // System.out.println("一共多少个");
        // int n =  in.nextInt();
        int k = 5;
        int n = 50;
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i++;
        }
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            // 产生随机数
            int random = (int) (Math.random() * n);
            result[i] = numbers[random];
            numbers[random] = numbers[n - 1];
            n--;
        }
        Arrays.sort(result);
        for (int i : result) {
            System.out.println(i);
        }
    }

    @Test
    public void tesd3() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 9, 8, 7, 6};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arrNew = Arrays.copyOfRange(arr, 0, arr.length * 2);
        System.out.println(Arrays.toString(arrNew));

        // Arrays.fill(arr, 1);
        // System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.binarySearch(arr, 15));
        int i = Arrays.binarySearch(arr, 0, arr.length, 15);
        if (i < 0) {
            i = -i-1;
        }
        System.out.println(arr.length);
        System.out.println("存在的位置或者插入的位置：" + i);

        System.out.println(Arrays.equals(arr, arrNew));
        int[] arr3 = {1};
        int i1 = Arrays.binarySearch(arr3, 1);
        System.out.println(i1);
        System.out.println(-i1-1);
    }

    @Test
    public void test4() {
        int[][] arr = {
                {12, 21, 23, 32},
                {11, 22, 33, 44},
                {4, 44, 444, 4444},
                {5, 55, 555, 5555}
        };
        System.out.println(Arrays.deepToString(arr));
    }

    @Test
    public void test5() {
        LocalDate now = LocalDate.now();
        System.out.println(now.getMonth()); // 第几个月的英文 APRIL
        System.out.println(now.getMonthValue());// 第几个月 数字
        System.out.println(now.getDayOfMonth());// 此月的第几天
        System.out.println(now.getDayOfWeek().getValue());// 一周的第几天
        System.out.println(now.getDayOfYear());// 一年的第几天
        System.out.println(now.plusDays(1));// 返回当前日期后一天的日期
        System.out.println(now.minusDays(1));// 返回当前日期前一天的日期
        System.out.println(now);//2022-04-04
    }

    @Test
    public void test6() {
        // 遍历日历
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();
        for (int i = 0; i < value; i++) {
            System.out.print("    ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) System.out.println();
    }

    @Test
    public void test7() {
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};
        System.out.println(Arrays.toString(arr1));
        System.out.println(arr2);
        System.out.println(arr1.equals(arr2));

    }

    @Test
    public void test8() {
        int[][] arr = {{3, 5}, {1, 2}, {4, 6}};

        Arrays.sort(arr, (a1, a2) -> a1[0] - a2[0]);
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(arr));
        System.out.println();
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
            System.out.println(ints[0]);
            System.out.println(ints[1]);
        }
    }

    @Test
    public void test9() throws MalformedURLException {
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);    // false
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);   // true
        String s = "sa";
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        URL u =new URL("http://www.123.com");
        System.out.println(u);
    }
}
class HelloA {

public HelloA() {
    System.out.println("a的构造函数");
}
    {
        System.out.println("a的构造代码块");
    }
static {
    System.out.println("a的静态代码");
}

    public static void main(String[] args) {
        HelloA helloA = new HelloA();
    }}
