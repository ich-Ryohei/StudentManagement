package raisetech.Student.Management;

import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.Student_Courses;
import raisetech.Student.Management.repository.StudentRepository;

@Service
public class StudentService {
  private StudentRepository repository;
  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList(String age) {

    //検索処理
    repository.search();

    //絞り込みをする。年齢が30代の人のみを抽出する。
    //抽出したリストをコントローラーに返す
    return repository.search(age>=30);

  }

  public List<Student_Courses> searchStudentCourseList(){

    //検索処理
    repository.searchCourses();

    //絞り込み検索で「Javaコース」のコース情報のみを抽出する。
    //抽出したリストをコントローラーに返す。

    return repository.searchCourses();
  }

}
