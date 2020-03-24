package day13;

import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class SystemProperties {

    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
    }
}
