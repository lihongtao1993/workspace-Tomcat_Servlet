package searchCase.web.servlet;

import searchCase.dao.CustomerDao;
import searchCase.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static searchCase.util.EmptyAndNull.isEmptyOrNull;

@WebServlet("/searchCustomerServlet")
public class SearchCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        if (isEmptyOrNull(name) && isEmptyOrNull(address) && isEmptyOrNull(email)){
//            List<Customer> list = CustomerDao.searchAllCustomer();
//            request.setAttribute("list",list);
            request.getRequestDispatcher("/customerservlet").forward(request,response);
        }else {
            List<Customer> list = CustomerDao.searchCustomer(name,address,email);
            request.setAttribute("list",list);
            request.getRequestDispatcher("/showcase/show.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
