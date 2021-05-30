package searchCase.web.servlet;

import searchCase.dao.CustomerDao;
import searchCase.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/changecustomerservlet")
public class ChangeCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setAge(Integer.parseInt(request.getParameter("age")));
        customer.setAddress(request.getParameter("address"));
        customer.setGender(request.getParameter("gender"));
        customer.setQq(request.getParameter("qq"));
        customer.setEmail(request.getParameter("email"));
        customer.setId(Integer.parseInt(request.getParameter("id")));
        CustomerDao.changeCustomer(customer);
        response.sendRedirect("/customerservlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
