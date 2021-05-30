package searchCase.web.servlet;

import searchCase.dao.CustomerDao;
import searchCase.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addcustomerservlet")
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置编码
        request.setCharacterEncoding("utf-8");
//        获取请求参数
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");
//        封装对象
        Customer add_customer = new Customer();
        add_customer.setName(name);
        add_customer.setGender(gender);
        add_customer.setAge(Integer.parseInt(age));
        add_customer.setAddress(address);
        add_customer.setQq(qq);
        add_customer.setEmail(email);
//        调用添加用户函数
        CustomerDao.addCustomer(add_customer);
//        设置重定向到结果查询页面
        response.sendRedirect("/customerservlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
