package myuser.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MyUserDto {
    private String id;
    private String name;
    private String dept;
    private String title;
    private String email;
    private Integer authLevel;
    private Date createDate;
    private Date updateDate;

    public MyUserDto(String name, String dept, String title, String email) {
        this.name = name;
        this.dept = dept;
        this.title = title;
        this.email = email;
    }
}
