package itcast.loginservlet;

import itcast.User.CreatUser;
import itcast.User.SearchUser;
import itcast.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logintest")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loginuser = CreatUser.creatUser(req.getParameter("username"), req.getParameter("password"));
        boolean isExist = SearchUser.search(loginuser);
        if (isExist){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败，请重试");
        }

    }
}
