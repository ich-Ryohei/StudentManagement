package raisetech.Student.Management.data;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
/**
 * 受講生コース情報を扱うオブジェクト
 */
@Getter
@Setter
public class StudentCourse {

    private int id;
    private int studentsId;
    private String courseName;
    private LocalDateTime startDayAt;
    private LocalDateTime endDayAt;

  }


