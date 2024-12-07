package itcast.User;

public class CreatUser {
    public static User creatUser(String name,String password){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return user;
    }
}

