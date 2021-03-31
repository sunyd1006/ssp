import com.kuang.config.KuangConfig;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：ltb
 * @date ：2020/7/14
 */
public class MyTest {


    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(KuangConfig.class);
        User user = (User) context.getBean("user");
        System.out.println(user.getName());
    }
}
