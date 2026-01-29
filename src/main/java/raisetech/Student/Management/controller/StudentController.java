package raisetech.Student.Management.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Student.Management.StudentService;
import raisetech.Student.Management.controller.converter.StudentConverter;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import raisetech.Student.Management.domain.StudentDetail;

@RestController
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList() {
    List<Student> students = service.searchStudentList();
    List<StudentsCourses> studentCourses = service.searchStudentCourseList();

    return converter.convertStudentDetails(students, studentCourses);
  }

  @GetMapping("/studentCourseList")
  public List<StudentsCourses> getCourseList() {
    return service.searchStudentCourseList();
  }

  @GetMapping("/newStudent")
  public String newStudent(Model model) {
    StudentDetail detail = new StudentDetail();
    detail.setStudent(new Student());

    List<StudentsCourses> list = new ArrayList<>();
    list.add(new StudentsCourses());
    detail.setStudentsCourses(list);

    model.addAttribute("studentDetail", detail);

    return "registerStudent";
  }

  @PostMapping("/registerStudent")
  public String registerStudent(@ModelAttribute StudentDetail detail, BindingResult result) {
    if (result.hasErrors()) {
      return "registerStudent";
    }
    //新規受講生登録する処理を実装する。
    //コース情報も一緒に登録できるように実装する。コースは単体でよい。

    service.insertStudent(detail);
    service.insertStudentCourse(detail);
    return "redirect:/studentList";
  }

  @GetMapping("/alterStudentMenu")
  public String getAlterStudentList(Model model) {
    List<Student> students = service.searchStudentList();
    List<StudentsCourses> studentCourses = service.searchStudentCourseList();

    model.addAttribute("alterMenuStudentList",
        converter.convertStudentDetails(students, studentCourses));
    return "alterMenuStudentList";
  }

  @GetMapping("/alterStudent/{id}")
  public String alterStudentForm(@PathVariable int id, Model model) {

    Student student = service.findStudentById(id);
    List<StudentsCourses> course = service.findStudentCourseById(id);

    StudentDetail detail = new StudentDetail();
    detail.setStudent(student);
    detail.setStudentsCourses(course);

    model.addAttribute("studentDetail", detail);
    return "alterSelectStudentList";
  }

  @PostMapping("/alterStudent")
  public ResponseEntity<String> alterStudent(@RequestBody StudentDetail detail) {
    service.updateStudent(detail);
    return ResponseEntity.ok("更新処理が成功しました");
  }

  @GetMapping("/deletedStudent")
  public String getDeletedStudentList(Model model) {
    List<Student> students = service.searchDeletedStudentList();
    List<StudentsCourses> studentCourses = service.searchStudentCourseList();

    model.addAttribute("deletedStudentList",
        converter.convertStudentDetails(students, studentCourses));
    return "deletedStudentList";
  }

  @GetMapping("/alterDeletedStudent")
  public String alterDeletedStudent(Model model) {
    List<Student> students = service.searchDeletedStudentList();
    List<StudentsCourses> studentCourses = service.searchStudentCourseList();

    model.addAttribute("alterDeletedStudent",
        converter.convertStudentDetails(students, studentCourses));
    return "alterDeletedStudent";
  }

  @PostMapping("/alterDeleteStudent/{id}")
  public String alterDelete(@PathVariable int id, Model model) {

    Student student = service.findStudentById(id);
    //List<StudentsCourses> course = service.findStudentCourseById(id);

    StudentDetail detail = new StudentDetail();
    detail.setStudent(student);
    //detail.setStudentsCourses(course);

    model.addAttribute("studentDetail", detail);
    service.alterDeleteStudent(detail);
    return "redirect:/studentList";
  }
}
