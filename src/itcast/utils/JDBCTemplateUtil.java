package itcast.utils;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateUtil {
    public static JdbcTemplate getJdbcTmeplate(){
        return new JdbcTemplate(JDBCUtils.getDatasource());
    }
}