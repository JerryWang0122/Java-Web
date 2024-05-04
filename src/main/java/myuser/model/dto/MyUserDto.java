package myuser.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MyUserDto {
    private String id;
    private String name;
    private String dept;
    private String title;
    private String email;
    private Integer authLevel;
    private Date createDate;
    private Date updateDate;
}
