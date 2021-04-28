package loginExample.dao;

import loginExample.domain.User;
import loginExample.utils.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;

//操作数据库中user表的类
public class UserDao {
//    获取全局的JDBCTemplate对象，供本类下的所有方法操作数据库使用
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());

    /**
     * 用户登陆的方法
     * @param loginuser，登陆用户，包含用户名和密码
     * @return 返回用户User对象
     */
    public static User login(User loginuser){
        String sql = "select *from user where name = ? and password = ?";
        User user = jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(User.class), //这个参数不太明白，应该是方法查询后封装的对象实体类的class文件
                loginuser.getName(),
                loginuser.getPassword()
        );
        return user;
    }
}
