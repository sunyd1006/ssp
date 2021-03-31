import nuc.ss.dao.StudentMapper;
import nuc.ss.dao.TeacherMapper;
import nuc.ss.pojo.Student;
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
        Teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void getStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent();

        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void getStudent2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent2();

        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
