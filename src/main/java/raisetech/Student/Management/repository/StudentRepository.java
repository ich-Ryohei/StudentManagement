package raisetech.Student.Management.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
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
  @Select("SELECT * FROM students WHERE isDeleted=false")
  List<Student> searchStudentList();

  /**
   * 受講生のコース情報の全件検索を行います
   *
   * @return 受講生のコース情報（全件）
   */

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> searchStudentCourseList();

  /**
   *
   * 削除された受講生の全件検索を行います
   *
   * @return 削除された受講生一覧（全件）
   */
  @Select("SELECT * FROM students WHERE isDeleted=true")
  List<Student> searchByDeleted();


  /**
   * 受講生（単一）の検索を行います
   *
   * @param id 受講生ID
   * @return 受講生
   */
  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(int id);

  /**
   * 受講生IDに紐づく受講生コース情報を検索します
   *
   * @param studentsId 受講生ID
   * @return 受講生IDに紐づく受講生コース情報
   *
   */

  @Select("SELECT * FROM students_courses WHERE students_id=#{studentsId}")
  List<StudentCourse> searchStudentCourse(int studentsId);


  /**
   * 受講生を新規登録します。 IDに関しては自動採番をおこなう。
   *
   * @param student 受講生
   */
  @Insert("INSERT INTO students (name,kana_name,nick_name,email,area,age,gender,remark,isDeleted) "
      + "VALUES(#{name}, #{kanaName}, #{nickName}, #{email}, #{area}, #{age}, #{gender}, #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(Student student);

  /**
   * 受講生コース情報を新規登録します。 IDに関しては自動採番をおこなう。
   *
   * @param studentCourse 受講生コース情報
   */
  @Insert("INSERT INTO students_courses (students_id,course_name,start_day_at,end_day_at) VALUES(#{studentsId},#{courseName},#{startDayAt},#{endDayAt})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentCourse(StudentCourse studentCourse);


  /**
   * 受講生を更新します。
   * @param student 受講生
   */
  @Update("""
        UPDATE students
        SET
          name = #{name},
          kana_name = #{kanaName},
          nick_name = #{nickName},
          email = #{email},
          area = #{area},
          age = #{age},
          gender = #{gender},
          remark = #{remark},
          isDeleted =#{deleted}
        WHERE id = #{id}
      """)
  void updateStudent(Student student);

  /**
   * 受講生コース情報のコース名を更新します。
   *
   * @param studentCourse 受講生コース情報
   */
  @Update("""
        UPDATE students_courses
        SET
          course_name = #{courseName}
           WHERE id = #{id}
      """)
  void updateStudentCourse(StudentCourse studentCourse);


}
