package raisetech.Student.Management.data;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * 受講生を扱うオブジェクト
 */
@Getter
@Setter
public class Student {

  @Pattern(regexp = "^\\d+$")
  private String id;

  @NotBlank
  private String name;

  @NotBlank
  private String kanaName;

  @NotBlank
  private String nickName;

  @NotBlank
  @Email
  private String email;

  @NotBlank
  private String area;


  private Integer age;

  @NotBlank
  private String gender;

  private String remark;
  private boolean deleted;


}


