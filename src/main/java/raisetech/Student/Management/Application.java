package raisetech.Student.Management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  private String name2 ="Satou Tarou";
  private String age2="29";
  private Map<String,String> stMap=new HashMap<>();

	public static void main(String[] args) {
//localhost:8080
    SpringApplication.run(Application.class, args);
  }

  public Application(){
    stMap.put("name","inoue");
    stMap.put("age","90");
     }

  @GetMapping("/studentInfo")
  public String getstudentInfo(){
   return stMap.get("name")+" "+stMap.get("age")+"歳"+
          name2+" "+age2+"歳";
  }

  @PostMapping("/studentInfo")
  public void setstudentInfo(String name,String age,String age2,String name2){
    stMap.put("name",name);
    stMap.put("age",age);
    this.name2=name2;
    this.age2=age2;
  }

  @PostMapping("/updatestudentName")
  public void updateName(String name){
    stMap.put("name",name);
  }
}
