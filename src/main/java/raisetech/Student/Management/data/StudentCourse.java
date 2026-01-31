package raisetech.Student.Management.data;


import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
/**
 * 受講生コース情報を扱うオブジェクト
 */
@Getter
@Setter
public class StudentCourse {

    private String id;

    @NotBlank
    private String studentsId;

    @NotBlank
    private String courseName;

    private LocalDateTime startDayAt;
    private LocalDateTime endDayAt;

  }


