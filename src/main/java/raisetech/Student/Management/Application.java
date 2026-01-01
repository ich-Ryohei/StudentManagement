package raisetech.Student.Management;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.Student_Courses;
import raisetech.Student.Management.repository.StudentRepository;

@SpringBootApplication

public class Application {




  public static void main(String[] args) {
//localhost:8080
    SpringApplication.run(Application.class, args);
  }

  public Application() {
  }

}
