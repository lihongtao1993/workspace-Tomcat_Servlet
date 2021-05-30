package searchCase.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import searchCase.domain.Customer;
import searchCase.util.JDBCUtil;

import java.util.List;

import static searchCase.util.EmptyAndNull.isEmptyOrNull;

public class CustomerDao {
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());

    // TODO: 2021/5/8 getCustomer
    public static Customer getCustomer(int id){
        String sql = "select *from customer where id = ?";
        List<Customer> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class),id);
        return list.get(0);
    }

    public static List<Customer> searchAllCustomer(){
        String sql = "select *from customer where isDelete = '0'";
        List<Customer> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
        return list;
    }

    public static boolean delCustomer(int id){
        String sql = "update customer set isDelete = 1 where id = ?";
        int result = jdbcTemplate.update(sql, id);
        if(result==1){
            return true;
        }else {
            return false;
        }
    }

    public static void addCustomer(Customer customer){
//        定义sql
        String sql = "insert into customer(name, gender, age, address, qq, email) VALUES (?,?,?,?,?,?) ";
//        执行sql
        jdbcTemplate.update(
                sql,
                customer.getName(),
                customer.getGender(),
                customer.getAge(),
                customer.getAddress(),
                customer.getQq(),
                customer.getEmail()
        );
    }

//    修改用户信息
    public static void changeCustomer(Customer customer){

        String sql = "update customer set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        jdbcTemplate.update(sql,
                customer.getName(),
                customer.getGender(),
                customer.getAge(),
                customer.getAddress(),
                customer.getQq(),
                customer.getEmail(),
                customer.getId()
        );
   }

//   查询用户信息
    public static List<Customer> searchCustomer(String name, String address, String email ){
        String sql = "select *from customer where  isDelete = 0 "+
                (isEmptyOrNull(name)?"":" and name = '"+name +"'") +
                (isEmptyOrNull(address)?"":"  and  address = '"+address +"'") +
                (isEmptyOrNull(email)?"":" and email = '"+email+"'") +"limit 0,5";
       return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Customer.class));
    }

    public static List<Customer> searchAllCustomerByPageIndex(int pageIndex,int pageSize){
        int beginNum = pageSize*(pageIndex-1);
        int endNum = pageSize;
        String sql = "select *from customer where isDelete = '0' limit ?, ? ";
        List<Customer> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class),beginNum,endNum);
        return list;
    }
    public static int getTotalCount(){
        String sql = "select count(*) from customer where isDelete = 0 ";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
}
