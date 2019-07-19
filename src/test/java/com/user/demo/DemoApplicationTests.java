package com.user.demo;

import com.user.demo.Dao.AccountMappe;
import com.user.demo.Dao.CompanyMapper;
import com.user.demo.Dao.UserMapper;
import com.user.demo.Mapper.Account;
import com.user.demo.Mapper.Company;
import com.user.demo.Mapper.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.user.demo.Mapper.stu_company;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
@Autowired
private AccountMappe accountMappe;
@Autowired
private CompanyMapper companyMapper;
@Autowired
private UserMapper userMapper;
    @Test
    public void contextLoads() {
        Account list=accountMappe.getAccountByUserId(3);
        System.err.println(list);
    }

    @Test
    public void getcompany(){
        Company cp=companyMapper.getCompanyById(2);
        System.err.println(cp);
    }


    /*@Test
   public void getccount() {
       User ar= userMapper.getUserWithAccount(1);
       System.out.println(ar);
    }*/


@Test
public void getspu() {
    User list = userMapper.getUserWithCompany(1);
    System.err.println(list);
}
/*@Test
    public void getallstu(){
        List<User> list=userMapper.getAll();
        System.err.println(list);
}
*/
@Test
public void dtsql() {
    List<Company> list=companyMapper.selectbydt(1,"公");
  for (Company SD:list){
      System.err.println(SD);
  }
}
}