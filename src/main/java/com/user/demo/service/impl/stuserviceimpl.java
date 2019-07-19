package com.user.demo.service.impl;

import com.user.demo.Dao.CompanyMapper;
import com.user.demo.Dao.UserMapper;
import com.user.demo.Mapper.Company;
import com.user.demo.Mapper.User;
import com.user.demo.Mapper.stu_company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.user.demo.service.stuservice;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.user.demo.Dao.CompanyMapper.*;

@Service
@Repository
public class stuserviceimpl implements stuservice {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private UserMapper userMapper;

    public Company getcompany() {
        return companyMapper.getCompanyById(1);

    }

    public User getstuwithcompany() {
        return userMapper.getUserWithCompany(1);

    }

    public List<stu_company> selectcompany() {

        List<stu_company> list = userMapper.getAll();

        return list;
    }

    //事务控制
@Transactional
    @Override
    public void adds() {
        Company scp = new Company();
        scp.setId(6);
        scp.setCompanyName("rrs");
        userMapper.add(scp);
        System.err.println("添加成功");

        int a = 10 / 0;
    }



    public List<Company> selectbydtai() {
        List<Company> list = companyMapper.selectbydt(1,"公");
        return list;
    }

    //添加公司方式二
    public int Adduser(long id,String name){
     return companyMapper.adduser(id,name);

    }
    //根据id删除公司信息
    public void Delete(){
        companyMapper.delete(46);
    }

    //修改公司名字
    public void Update(){
        companyMapper.update(7);
    }
}
