package raisetech.Student.Management;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import raisetech.Student.Management.domain.StudentDetail;
import raisetech.Student.Management.repository.StudentRepository;


@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.search();
  }

  public List<Student> searchDeletedStudentList() {
    return repository.searchByDeleted();
  }



/*
    //検索処理
    List<Student> students = repository.search();
    //絞り込みをする。年齢が30代の人のみを抽出する。
    //抽出したリストをコントローラーに返す
    //public List<>

    return students.stream()
        .filter(s-> s.getAge()>=30&&s.getAge()<40)
        .collect(Collectors.toList());
  }
*/


  public List<StudentsCourses> searchStudentCourseList() {

    //検索処理
    return repository.searchCourses();
  }

  /*
    //絞り込み検索で「Javaコース」のコース情報のみを抽出する。
    //抽出したリストをコントローラーに返す。
    List<StudentsCourses>courses=repository.searchCourses();
    return courses.stream()
        .filter(course->course.getCourseName()!=null && course.getCourseName().toUpperCase().equals("JAVA"))
        .collect(Collectors.toList());

   */
  @Transactional
  public void insertStudent(StudentDetail detail) {

    repository.insert(detail.getStudent());
  }


  @Transactional
  public void insertStudentCourse(StudentDetail detail) {
    int studentId = detail.getStudent().getId();

    for (StudentsCourses sc : detail.getStudentsCourses()) {
      sc.setStudentsId(studentId);
      sc.setStartDayAt(LocalDateTime.now());
      sc.setEndDayAt(LocalDateTime.now().plusYears(1));
      repository.insertCourse(sc);
    }
  }


  public Student findStudentById(int id) {
    return repository.findStudentById(id);
  }

  public List<StudentsCourses> findStudentCourseById(int studentsId) {
    return repository.findStudentCoursesById(studentsId);
  }


  @Transactional
  public void updateStudent(StudentDetail detail) {
    repository.updateStudent(detail.getStudent());
    for (StudentsCourses course : detail.getStudentsCourses()) {
      repository.updateStudentCourse(course);
    }
  }

  @Transactional
  public void alterDeleteStudent(StudentDetail detail) {

    repository.alterDeleteStudent(detail.getStudent());
  }
}