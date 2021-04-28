package loginExample.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//druid工具类,提供数据库连接池和数据库连接对象
public class JDBCUtil {
    private static DataSource dataSource =null; //定义一个全局的静态Datasource变量，一定是静态的，不然不能在静态代码块中访问

    //    1、使用静态代码块（类加载时就会执行）加载配置文件，并创建数据库连接池
    static{
    Properties properties = new Properties();
        try {
            //加载配置文件
            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties); //创建数据库连接池
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//       2、创建一个方法，获取数据库连接池，方便其他地方使用
    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
