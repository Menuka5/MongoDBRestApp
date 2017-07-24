package hsenid.api.controllers;


import hsenid.api.repository.StudentRepoImpl;
import hsenid.domain.Student;
import hsenid.domain.SuccessMessage;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentRepoImpl studentRepoImpl;

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Object> getAllStudents() {
        List<Student> students;
        students = studentRepoImpl.getStudents();

        SuccessMessage successMessage = new SuccessMessage();
        successMessage.setStatus("success");
        successMessage.setCode(HttpStatus.OK.value());

        if (students.size() > 0) {
            successMessage.setMessage(students.size() + " records found.");
            for (int i = 0; i < students.size(); i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", students.get(i).getName());
                jsonObject.put("grade", students.get(i).getGrade());

                jsonObject.put("age", students.get(i).getAge());
                jsonObject.put("classRank", students.get(i).getClassRank());
                successMessage.addData(jsonObject);
            }
        } else {
            successMessage.setMessage("No records found.");
        }
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<Object> insertStudent(@RequestBody Student student) {
        boolean status = studentRepoImpl.addStudent(student);
        SuccessMessage successMessage = new SuccessMessage();
        if (status) {
            successMessage.setStatus("success");
            successMessage.setCode(HttpStatus.CREATED.value());
            successMessage.setMessage("new student added.");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", student.getName());
            jsonObject.put("age", student.getAge());

            jsonObject.put("grade", student.getGrade());
            jsonObject.put("classRank", student.getClassRank());
            successMessage.addData(jsonObject);
        }
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Object> deleteStudent(@PathVariable("name") String name) {

        int affectedRows = studentRepoImpl.deleteStudent(name);
        SuccessMessage successMessage = new SuccessMessage();
        successMessage.setStatus("success");
        successMessage.setCode(HttpStatus.OK.value());
        if (affectedRows > 0) {
            successMessage.setMessage("student record deleted.");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", name);
            successMessage.addData(jsonObject);
        } else {
            successMessage.setMessage("no matching records found to delete.");
        }
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<Object> updateStudent(@RequestBody Student student) {
        int affecteRows = studentRepoImpl.updateStudent(student);
        SuccessMessage successMessage = new SuccessMessage();
        successMessage.setStatus("success");
        successMessage.setCode(HttpStatus.OK.value());
        if (affecteRows > 0) {
            successMessage.setMessage("student record updated.");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userName", student.getName());
            successMessage.addData(jsonObject);
        } else {
            successMessage.setMessage("no matching records found to update.");
        }
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }
}
