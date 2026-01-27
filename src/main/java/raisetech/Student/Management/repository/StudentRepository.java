package raisetech.Student.Management.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import raisetech.Student.Management.domain.StudentDetail;


@Mapper
public interface StudentRepository {


  @Select("SELECT * FROM students WHERE isDeleted=false")
  List<Student> search();

  @Select("SELECT * FROM students WHERE isDeleted=true")
  List<Student> searchByDeleted();


  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchCourses();

  @Insert("INSERT INTO students (name,kana_name,nick_name,email,area,age,gender,remark,isDeleted) "
      + "VALUES(#{name}, #{kanaName}, #{nickName}, #{email}, #{area}, #{age}, #{gender}, #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(Student student);

  @Insert("INSERT INTO students_courses (students_id,course_name,start_day_at,end_day_at) VALUES(#{studentsId},#{courseName},#{startDayAt},#{endDayAt})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insertCourse(StudentsCourses studentCourses);

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student findStudentById(int id);

  @Select("SELECT * FROM students_courses WHERE students_id=#{studentsId}")
  List<StudentsCourses> findStudentCoursesById(int studentsId);

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

  @Update("""
        UPDATE students_courses
        SET
          course_name = #{courseName}
           WHERE id = #{id}
      """)
  void updateStudentCourse(StudentsCourses studentsCourses);

  @Update("""
      UPDATE students
      SET
      isDeleted = false
      WHERE id = #{id}
      """)
  void alterDeleteStudent(Student student);

}
