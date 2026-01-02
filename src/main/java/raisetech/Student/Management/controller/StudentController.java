package raisetech.Student.Management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Student.Management.StudentService;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.Student_Courses;

@RestController
public class StudentController {

  private StudentService service;
  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping("/studentList")
  public List<Student> getStudentList() {
    return service.searchStudentList();
  }

  @GetMapping("/studentCourseList")
  public List<Student_Courses> getCourseList(){

    return service.searchStudentCourseList();
  }

}
