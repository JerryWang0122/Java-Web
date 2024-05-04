package myuser.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class MyUser {
    private String id;
    private String name;
    private String pwd;
    private String dept;
    private String title;
    private String email;
    private Date createDate;
    private Date updateDate;
}
