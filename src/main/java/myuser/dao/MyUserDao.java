package myuser.dao;

import myuser.model.dto.MyUserDto;
import myuser.model.po.MyUser;

import java.util.List;

public interface MyUserDao {
    MyUserDto findById(String empId);
    List<MyUserDto> findAll();
    int create(MyUser user);
    int update(String empId, MyUserDto user);
    int delete(String empId);
}
