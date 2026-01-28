package raisetech.Student.Management.data;

import lombok.Getter;
import lombok.Setter;

/**
 * 受講生を扱うオブジェクト
 */
@Getter
@Setter
public class Student {

  private int id;
  private String name;
  private String kanaName;
  private String nickName;
  private String email;
  private String area;
  private Integer age;
  private String gender;
  private String remark;
  private boolean deleted;
}


