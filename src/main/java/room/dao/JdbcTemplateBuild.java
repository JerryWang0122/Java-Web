package room.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// 利用單例模式(SingleTon)建立 JdbcTemplate 物件
public class JdbcTemplateBuild {

    private static JdbcTemplate jdbcTemplate;

    static {
        init();
    }

    // 防止外部初始化
    private JdbcTemplateBuild() {}

    // 初始化
    private static void init() {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/web?serverTimezone=Asia/Taipei";
        String username = "root";
        String password = "12345678";

        // 資料源設定
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(dbURL);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // 將資料源設定給 jdbcTemplate
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static JdbcTemplate getInstance() {
        if (jdbcTemplate == null) {
            init();
        }
        return jdbcTemplate;
    }
}
