package raisetech.Student.Management.data;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsCourses {

    private int id;
    private int studentsId;
    private String courseName;
    private LocalDateTime startDayAt;
    private LocalDateTime endDayAt;

  }


