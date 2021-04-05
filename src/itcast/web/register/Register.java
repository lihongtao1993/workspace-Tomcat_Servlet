package itcast.web.register;

import itcast.utils.JDBCTemplateUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int update = 0;
        try {
            JdbcTemplate jdbcTmeplate = JDBCTemplateUtil.getJdbcTmeplate();
            req.setCharacterEncoding("utf-8");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String sql = "insert into user(name,password)  VALUES ('"+username+"','"+password+"')";
            update = jdbcTmeplate.update(sql);
        }catch (Exception e){
            update = 0;
        }
        if (update > 0){
            System.out.println("success");
            req.getRequestDispatcher("/successregister").forward(req,resp);
        }else {
            System.out.println("Failure");
            req.getRequestDispatcher("/failureregister").forward(req,resp);
        }
    }
}
