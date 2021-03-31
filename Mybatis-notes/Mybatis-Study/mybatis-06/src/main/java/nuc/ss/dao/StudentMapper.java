package nuc.ss.dao;

import nuc.ss.pojo.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 查询所有的学生信息，以及对应的老师的信息
     * @return
     */
    public List<Student> getStudent();

    /**
     * 查询所有的学生信息，以及对应的老师的信息
     * @return
     */
    public List<Student> getStudent2();
}
