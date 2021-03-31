package nuc.ss.dao;

import nuc.ss.pojo.User;
import nuc.ss.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userLike = mapper.getUserLike("%李%");

        for (User user : userLike) {
            System.out.println(user);
        }

        sqlSession.close();
    }
    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();


        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        //方式二：
        //List<User> userList = sqlSession.selectList("nuc.ss.dao.UserMapper.getUserList");

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public  void  getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    // 增删改查需要提交事务
    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.addUser(new User(4, "哈哈", "123123"));

        if (i > 0) {
            System.out.println("插入成功");
        }

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void addUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userid", 5);
        map.put("userName", "哈行昂");
        map.put("password", "465789");

        int i = mapper.addUser2(map);

        if (i > 0) {
            System.out.println("插入成功");
        }

        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.updateUser(new User(4, "呵呵", "123123"));

        if (i > 0) {
            System.out.println("修改成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.deleteUser(4);

        if (i > 0) {
            System.out.println("删除成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
