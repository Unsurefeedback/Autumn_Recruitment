import BeanLifeCycle.LifecycleDemoBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @author WeiHanQiang
 * @date 2024/09/26 14:13
 **/
@SpringBootTest
public class LifecycleDemoTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testBeanLifecycle() {
        System.out.println("获取LifecycleDemoBean实例...");
        LifecycleDemoBean bean = context.getBean(LifecycleDemoBean.class);
    }
}
