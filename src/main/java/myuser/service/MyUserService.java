package myuser.service;

import myuser.dao.MyUserDaoImpl;
import myuser.model.dto.MyUserDto;
import myuser.model.po.MyUser;

import java.util.List;

public class MyUserService {
    private MyUserDaoImpl myUserDao = new MyUserDaoImpl();

    public boolean addMyUser(String empId, String name, String pwd, String dept, String title, String email) {
        MyUser myUser = new MyUser(empId, name, pwd, dept, title, email);
        return myUserDao.create(myUser) > 0;
    }

    public boolean deleteMyUser(String empId) {
        return myUserDao.delete(empId) > 0;
    }

    public boolean updateInfo (String empId, String name, String dept, String title, String email) {
        MyUserDto myUserDto = new MyUserDto(name, dept, title, email);
        return myUserDao.update(empId, myUserDto) > 0;
    }

    public MyUserDto getUser(String empId) {
        return myUserDao.findById(empId);
    }

    public List<MyUserDto> getAllUsers() {
        return myUserDao.findAll();
    }
}
