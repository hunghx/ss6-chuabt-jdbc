package ra.bussiness.model;

import lombok.*;

import java.util.Date;

// Sử dụng lombok
@NoArgsConstructor // constructor không tham số
@AllArgsConstructor // constructor full tham số
@Data // bao gồm getter, setter, tostring
public class Student {
    private Long id;
    private String lastName;
    private String firstName;
    private Date birthDay;
    private Boolean sex;
}
