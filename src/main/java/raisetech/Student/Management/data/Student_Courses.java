package raisetech.Student.Management.data;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student_Courses {

    private String id;
    private String studentsId;
    private String courseName;
    private LocalDateTime startDayAt;
    private LocalDateTime endDayAt;

  }


