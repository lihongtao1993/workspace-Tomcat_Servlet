package test.daoTest;

import loginExample.dao.UserDao;
import loginExample.domain.User;
import org.junit.Test;
import searchCase.dao.CustomerDao;
import searchCase.domain.Customer;


public class UserDaoTest {
    @Test
    public void loginTest(){
        User loginuser = new User();
        loginuser.setName("mike");
        loginuser.setPassword("123456");
        User user = UserDao.login(loginuser);
        System.out.println(user);
    }
    @Test
    public void change(){
        Customer customer = CustomerDao.getCustomer(6);

        System.out.println(customer.getName());
    }
    @Test
    public void update(){
        Customer c = new Customer();
        c.setName("dd");
        c.setAge(34);
        c.setAddress("66666");
        c.setQq("fdsdfdd");
        c.setEmail("dfdssfsdffg");
        c.setGender("nn");
        c.setId(3);
        CustomerDao.changeCustomer(c);

        System.out.println(c.getChangeTime());
    }
}
