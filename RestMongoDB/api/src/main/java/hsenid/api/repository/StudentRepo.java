package hsenid.api.repository;



import hsenid.domain.Student;

import java.util.List;

public  interface StudentRepo {
    List<Student> getStudents();

    boolean addStudent(Student student);

    int deleteStudent(String userName);

    int updateStudent(Student student);
}
