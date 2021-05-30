package searchCase.web.servlet;

import searchCase.dao.CustomerDao;
import searchCase.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getCustomerServlet")
public class GetCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        int customerId = Integer.parseInt(id);
        Customer customer = CustomerDao.getCustomer(customerId);
        request.setAttribute("customer",customer);
        request.setAttribute("gender",customer.getGender());
        request.getRequestDispatcher("/showcase/changecustomer.jsp").forward(request,response);
//        response.sendRedirect("/showcase/changecustomer.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
