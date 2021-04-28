package test.daoTest;

import loginExample.dao.UserDao;
import loginExample.domain.User;
import org.junit.Test;


public class UserDaoTest {
    @Test
    public void loginTest(){
        User loginuser = new User();
        loginuser.setName("mike");
        loginuser.setPassword("123456");
        User user = UserDao.login(loginuser);
        System.out.println(user);
    }
}
