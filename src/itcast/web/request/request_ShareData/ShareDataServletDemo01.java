package itcast.web.request.request_ShareData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//request共享数据,可以请求转发间的各个servlet之间共享数据。
@WebServlet("/sharedatademo01")
public class ShareDataServletDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、设置并存储共享数据,通过键值的形式
        request.setAttribute("username","mario");

        //2、首先设置请求转发，转发到 sharedatademo02中
                                    //getRequestDispatcher方法中传递要转发到的servlet路径，forward传递请求和响应参数
        request.getRequestDispatcher("sharedatademo02").forward(request,response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
