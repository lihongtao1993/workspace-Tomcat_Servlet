package itcast.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource ds;
    //    1、加载配置文件,获取数据库连接池
    static{
        try {
            //新建一个Properties对象
            Properties pro = new Properties();
            //获取配合文件的字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            //加载配置文件
            pro.load(is);
            //获取连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDatasource(){
        return ds;
    }

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}
