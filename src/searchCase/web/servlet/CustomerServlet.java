package searchCase.web.servlet;

import searchCase.dao.CustomerDao;
import searchCase.domain.Customer;
import searchCase.util.EmptyAndNull;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/customerservlet")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndex = request.getParameter("pageIndex");
        String pageSize = request.getParameter("pageSize");
//        List<Customer> list = CustomerDao.searchAllCustomer();
//        获取总数,并将结果存入request域中。
        int totalCount = CustomerDao.getTotalCount();
        request.setAttribute("totalCount",totalCount);
//        计算总的页数
        int totalPageCount = 1;
        if (pageSize!=null){
            int size = Integer.parseInt(pageSize);
            totalPageCount = totalCount / size == 0 ? totalCount/size:totalCount/size+1;
        }else {
            totalPageCount = totalCount / 5 == 0 ? totalCount/5:totalCount/5+1;
        }
        request.setAttribute("totalPageCount",totalPageCount);
        if (EmptyAndNull.isEmptyOrNull(pageIndex)){
            pageIndex = "1";
        }
        if (EmptyAndNull.isEmptyOrNull(pageSize)){
            pageSize = "5";
        }
        List<Customer> list = CustomerDao.searchAllCustomerByPageIndex(Integer.parseInt(pageIndex),Integer.parseInt(pageSize));

        request.setAttribute("currentPage",Integer.parseInt(pageIndex));
        request.setAttribute("list",list);
        request.getRequestDispatcher("/showcase/show.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
