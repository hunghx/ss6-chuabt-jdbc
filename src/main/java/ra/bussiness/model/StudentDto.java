package ra.bussiness.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// dto data transfer object

@NoArgsConstructor // constructor không tham số
@AllArgsConstructor // constructor full tham số
@Data
public class StudentDto {
    private Long id;
    private String lastName;
    private String firstName;
    private Date birthDay;
    private Boolean sex;
    private String phone;
    private String className;
}
