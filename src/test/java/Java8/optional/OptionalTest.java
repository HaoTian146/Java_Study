package Java8.optional;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * @Author th
 * @Description
 * Optional类： 为了程序中避免出现空指针异常而创建的
 * 常用方法：
 *          ofNullable(T t)
 *          ofElse(T t)
 */
public class OptionalTest {
    /**
     * Optional.of() 创建一个Optional实例，t必须非空
     * Optional.empty() 创一个空的Optional实例
     * Optional.ofNullable(T t) t可以为null
     */
    @Test
    public void test1() {
        Girl girl = new Girl();
        girl = null;
        // t 必须非空
        Optional<Girl> girl1 = Optional.of(girl);
    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        // girl = null;
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    @Test
    public void test3() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    // 优化后
    public String getGirlName1(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }
    @Test
    public void test4() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    // 使用Optional类的getGirlName
    public String getGirlName2(Boy boy) {
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("古力娜扎"));
        return girl2.getName();
    }

    @Test
    public void test5() {
        Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("刘老师"));
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }

    @Test
    public void test6() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int[] arr = {1,2,3,4,5};
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
    }
}
