package itcast.web.request;


//演示获取请求体的方法
/*
* 获取请求提的步骤：
*   1、获取请求体的输入流
*       *BufferedReader getReader()
*       *ServletInputStream getInputStream()
*   2、通过流获取请求数据
* */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/requestdemo3")
public class P03_RequestDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        int len = 0;
        while ((len = reader.read()) != -1){
            System.out.print((char)len);
        }
    }
}
