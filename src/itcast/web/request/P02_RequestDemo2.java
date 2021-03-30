package itcast.web.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

//演示获取请求头相关方法
@WebServlet("/requestdemo2")
public class P02_RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String agent = req.getHeader("user-agent");
        System.out.println(agent);

        //获取所有的请求头名字
        Enumeration<String> headerNames = req.getHeaderNames();
        //遍历请求头
        while (headerNames.hasMoreElements()){
            //获取请求头名称
            String name = headerNames.nextElement();
            //通过请求头名称获取其的值
            System.out.println(name+"="+req.getHeader(name));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
