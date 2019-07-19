package com.user.demo.service;

import com.user.demo.Mapper.Company;
import com.user.demo.Mapper.User;
import com.user.demo.Mapper.stu_company;
import com.user.demo.Dao.CompanyMapper;
import java.util.List;

public interface stuservice {
    public Company getcompany();

    public User getstuwithcompany();

    public List<stu_company> selectcompany();

    public void adds();

    public List<Company> selectbydtai();

    public int Adduser(long id,String name);

    public void Delete();

    public void Update();
}