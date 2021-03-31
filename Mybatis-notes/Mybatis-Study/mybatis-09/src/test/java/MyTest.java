import nuc.ss.dao.UserMapper;
import nuc.ss.pojo.User;
import nuc.ss.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        //mapper.updateUser(new User(2,"111111111111","123456"));
        sqlSession.clearCache();//手动清理缓冲

        System.out.println("=================================");
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user == user2);

        sqlSession.close();

    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        //sqlSession.close();
        System.out.println("===============================");

        User user2 = mapper2.queryUserById(1);
        System.out.println(user);

        System.out.println(user == user2);

        sqlSession.close();
        sqlSession2.close();

    }

}
