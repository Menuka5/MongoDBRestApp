package hsenid.api.repository;

import com.google.common.base.Strings;

import com.mongodb.WriteResult;
import hsenid.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class StudentRepoImpl implements StudentRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Student> getStudents() {
        List<Student> studentList;
        studentList = mongoTemplate.findAll(Student.class, "student");
        return studentList;
    }

    @Override
    public boolean addStudent(Student student) {
        boolean status;
        mongoTemplate.insert(student, "student");
        status = true;
        return status;
    }

    @Override
    public int deleteStudent(String userName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(userName));
        WriteResult writeResult = mongoTemplate.remove(query, Student.class, "student");
        return writeResult.getN();
    }

    @Override
    public int updateStudent(Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(student.getName()));
        Update update = new Update();
        if (!Strings.isNullOrEmpty(student.getName())) {
            update.set("name", student.getName());
        }

        if (!Strings.isNullOrEmpty(student.getGrade())) {
            update.set("grade", student.getGrade());
        }
        if (student.getAge() != 0) {
            update.set("age", student.getAge());
        }
        if (student.getClassRank() != 0) {
            update.set("classRank", student.getClassRank());
        }
        WriteResult writeResult = mongoTemplate.updateMulti(query, update, Student.class, "student");
        return writeResult.getN();
    }
}
