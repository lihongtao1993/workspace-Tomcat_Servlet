package itcast.web.request;


//演示获取请求参数的通用方式

import org.jcp.xml.dsig.internal.dom.DOMXPathFilter2Transform;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/*
String               getParameter(String name)         通过参数名称获取参数对应的值
String[]             getParameterValues(String name)   通过参数名称获取参数值的数组，用于一个参数有多个值，如复选
Enumeration<String>  getParameterNames()               获取所有请求参数的名称
Map<String,String[]> getParameterMap()                 获取所有请求参数的map集合


*/
@WebServlet("/requestdemo4")
public class P04_RequestDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//防止中文乱码，设置request的编码格式
        //通过参数名称获取参数的值
        String username = req.getParameter("username");
        System.out.println("username=="+username);
        String hobby = req.getParameter("hobby");//通过这种方式只能获取一个值，
        System.out.println(hobby);

        System.out.println("1_______________________________");
        //通过参数名称获取参数值的数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby1 : hobbies) {
            System.out.println(hobby1);
        }
        System.out.println("2__________________________");
        //获取所有请求参数的名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println(s+"---"+req.getParameter(s));
        }

        System.out.println("3_3______________________________");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String s : keySet) {
            System.out.println(s +"" + Arrays.toString(parameterMap.get(s)));
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
