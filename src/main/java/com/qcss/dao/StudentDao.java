package com.qcss.dao;

import com.qcss.pojo.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 学生设置
     */
    public int insertStudent(Student student);

    public List<Student> selectStudent(Student student);
    public int selectStudentCount(Student student);

    public List<Student> selectUsedByCheckerStudent(Student student);

    public int deleteStudent(List<Student> studentList);

    public int updateStudent(Student student);
    public Long countStudent(Student student);
}
