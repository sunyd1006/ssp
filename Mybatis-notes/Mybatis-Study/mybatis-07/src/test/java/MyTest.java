import nuc.ss.dao.TeacherMapper;
import nuc.ss.pojo.Teacher;
import nuc.ss.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void getTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        List<Teacher> teachers = mapper.getTeacher();

        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }

        sqlSession.close();
    }

    @Test
    public void getOneTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher oneTeacher = mapper.getOneTeacher(1);

        System.out.println(oneTeacher);

        sqlSession.close();
    }

    @Test
    public void getOneTeacher2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher oneTeacher = mapper.getOneTeacher2(1);

        System.out.println(oneTeacher);

        sqlSession.close();
    }
}
