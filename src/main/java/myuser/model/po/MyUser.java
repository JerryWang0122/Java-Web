package myuser.model.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MyUser {
    private String id;
    private String name;
    private String pwd;
    private String dept;
    private String title;
    private String email;
    private Integer authLevel;
    private Date createDate;
    private Date updateDate;

    public MyUser(String id, String name, String pwd, String dept, String title, String email) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.dept = dept;
        this.title = title;
        this.email = email;
    }
}
