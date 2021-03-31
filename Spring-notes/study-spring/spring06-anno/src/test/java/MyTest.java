import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.name);
    }


    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean(User.class);
        System.out.println(user.name);
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = (User) context.getBean("user");
        User user2 = context.getBean(User.class);
        User user3 = (User) context.getBean("user");
        User user4 = context.getBean(User.class);
        System.out.println(user1 == user2);
        System.out.println(user1 == user3);
        System.out.println(user3 == user4);
        System.out.println(user1.name);
        System.out.println(user2.name);
    }


}
