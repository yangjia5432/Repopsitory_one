package com.user.demo.Dao;

import com.user.demo.Mapper.Company;
import com.user.demo.Mapper.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.user.demo.Mapper.stu_company;
import com.user.demo.Dao.AccountMappe;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {


    /*@Select("select* from spu where id=#{id}")
    @Results({@Result(property = "accounts", column = "id", many = @Many(select = "com.user.demo.Dao.CompanyMapper.getAccountByUserId"))})
    User getUserWithAccount(@Param("id") Integer id);*/

    /*@Select("select e.name,d.name from spu e join company d on e.company_id=d.id")
    stu_company getUserWithCompany(long id);*/
   @Select("select* from spu where id=#{id}")
    @Results({@Result(property = "company", column = "company_id", one = @One(select = "com.user.demo.Dao.CompanyMapper.getCompanyById"))})
    User getUserWithCompany(@Param("id") long id);


   /* @Select("SELECT * FROM spu")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "company", column = "company_id", one = @One(select =
                    "com.user.demo.Dao.CompanyMapper.getCompanyById")),
            @Result(property = "accounts", column = "id", many = @Many(select =
                    "com.user.demo.Dao.CompanyMapper.getAccountByUserId"))
    })
    List<User> getAll();*/


@Select("select spu.name,company.name companyname from spu join company on spu.company_id=company.id")
    List<stu_company> getAll();

//添加方式一
    @Insert("INSERT INTO company (id,name) VALUES (#{id}, #{companyName})")
    void add(Company company);
}