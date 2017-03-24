import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by liuxiwen on 2017/3/24.
 */

/**
 * Spring3.1后多了个spring-test-4.2.4.RELEASE.jar包，这个jar包专门用来支持JUnit基于注解的测试的，
 * 该jar包里有个SpringJUnit4ClassRunner.class，用@RunWith注解加进来即可。
 *
 * 注解@ContextConfiguration表示将ApplicationContext对象注入进来，就不用像以前那样在测试程序里现new了。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class SSHTest {

    @Resource
    private Date date;

    @Test// 测试Spring IOC的开发环境
    public void springIoc() {

        System.out.println(date);
    }
}
