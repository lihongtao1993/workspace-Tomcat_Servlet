package itcast.User;


import itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchUser {
    public static boolean search(User loginuser)  {
        try {
            Connection connection = JDBCUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select *from user where name = "+"'"+loginuser.getName()+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet!=null){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
