package raisetech.Student.Management.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentCourse;

/**
 * 受講生テーブルと受講生コース情報テーブルと紐づくRepositoryです
 *
 */
@Mapper
public interface StudentRepository {

  /**
   * 受講生の全件検索を行います
   *
   * @return 受講生一覧（全件）
   */

  List<Student> search();

  /**
   * キャンセルフラグがfalseの受講生の全件検索を行います。
   *
   * @return 受講生一覧（キャンセルフラグがfalseとなっている全件）
   */

  /**
   * 受講生のコース情報の全件検索を行います
   *
   * @return 受講生のコース情報（全件）
   */

  List<StudentCourse> searchStudentCourseList();

  /**
   *
   * 削除された受講生の全件検索を行います
   *
   * @return 削除された受講生一覧（全件）
   */
  List<Student> searchByDeleted();


  /**
   * 受講生（単一）の検索を行います
   *
   * @param id 受講生ID
   * @return 受講生
   */

  Student searchStudent(String id);

  /**
   * 受講生IDに紐づく受講生コース情報を検索します
   *
   * @param studentsId 受講生ID
   * @return 受講生IDに紐づく受講生コース情報
   *
   */

  List<StudentCourse> searchStudentCourse(String studentsId);


  /**
   * 受講生を新規登録します。 IDに関しては自動採番をおこなう。
   *
   * @param student 受講生
   */

  void registerStudent(Student student);

  /**
   * 受講生コース情報を新規登録します。 IDに関しては自動採番をおこなう。
   *
   * @param studentCourse 受講生コース情報
   */

  void registerStudentCourse(StudentCourse studentCourse);


  /**
   * 受講生を更新します。
   * @param student 受講生
   */

  void updateStudent(Student student);

  /**
   * 受講生コース情報のコース名を更新します。
   *
   * @param studentCourse 受講生コース情報
   */

  void updateStudentCourse(StudentCourse studentCourse);


}
