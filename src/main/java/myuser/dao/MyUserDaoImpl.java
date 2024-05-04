package myuser.dao;

import myuser.model.dto.MyUserDto;
import myuser.model.po.MyUser;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import room.dao.JdbcTemplateBuild;

import java.util.List;

public class MyUserDaoImpl implements MyUserDao{
    private  JdbcTemplate jdbcTemplate = JdbcTemplateBuild.getInstance();

    @Override
    public MyUserDto findById(String empId) {
        // root
        String sql = "select id, name, dept, title, email, auth_level, create_time, update_time "+
                "from myuser where id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(MyUserDto.class), empId);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<MyUserDto> findAll() {
        // root
        String sql = "select id, name, dept, title, email, auth_level, create_time, update_time from myuser";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MyUserDto.class));
    }

    @Override
    public int create(MyUser user) {
        // 一般 user
        String sql = "insert into myuser (id, name, pwd, dept, title, email) values (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPwd(),
                    user.getDept(), user.getTitle(), user.getEmail());
    }

    @Override
    public int update(String empId, MyUserDto user) {
        // 一般 user 改個資
        String sql = "update myuser set name = ?, dept = ?, title = ?, email = ? where id = ?";
        return jdbcTemplate.update(sql, user.getName(), user.getDept(), user.getTitle(),
                user.getEmail(), empId);
    }

    @Override
    public int delete(String empId) {
        // root
        String sql = "delete from myuser where id = ?";
        return jdbcTemplate.update(sql, empId);
    }
}
