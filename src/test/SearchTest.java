package test;


import itcast.User.SearchUser;
import itcast.User.User;
import org.junit.Test;


public class SearchTest {
    @Test
    public void search1(){
        User user = new User();
        user.setName("mi");
        user.setPassword("123");
        boolean search = SearchUser.search(user);
        System.out.println(search);
    }
}
