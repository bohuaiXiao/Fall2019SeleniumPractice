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
        System.out.println(System.getProperty("user.dir")+"/pom.xml");
        // /Users/bohuaixiao/Desktop/Fall2019SeleniumPractice
        System.out.println(System.getProperty("os.name"));
        // Mac OS X
        String s = System.getProperty("user.home") + "/Downloads";
        System.out.println("s = " + s);
        System.out.println(System.getProperty("os.arch"));
    }
}
