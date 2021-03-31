import com.kuang.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：ltb
 * @date ：2020/7/14
 */
public class MyTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("people",People.class);
        System.out.println(people.getName());
        people.getCat().shout();
        people.getDog().shout();
    }
}
