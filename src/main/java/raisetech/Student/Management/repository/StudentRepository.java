package raisetech.Student.Management.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.Student_Courses;

/**
 * 受講生情報を扱うリポジトリ
 *
 * 全権検索や単一条件での検索、コース情報の検索が行えるクラスです。
 */
@Mapper
public interface StudentRepository {

  /**
   * 全権検索します。
   * @return 全権検索した受講生情報の一覧
   */

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<Student_Courses> searchCourses();

}
