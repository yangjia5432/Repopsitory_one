package com.user.demo.Dao;

import com.user.demo.Mapper.Company;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyMapper {
    @Select("select* from company where id=#{id}")
    @Results({@Result(property = "companyName",column = "name")})
    Company getCompanyById(@Param("id") long id);

    //动态sql
    @Select("<script>" +
            "select * from company" +
            "<where>" +
            "<if test='id>0'>" +
            "and id>#{id}" +
            "</if>" +
            "<if test='companyName!=null'>" +
            "and name like concat('%',#{companyName},'%')"+
            "</if>" +
            "</where>" +
            "</script>")
    @Results({@Result(property = "companyName",column = "name")})
     List<Company> selectbydt(@Param("id") int id,@Param("companyName")String companyName);

    //添加方式二

    @Insert("INSERT INTO company (id,name) VALUES (#{id}, #{name})")
     int adduser(@Param("id") long id, @Param("name") String name);

    //删除delete
    @Delete("delete from company where id = #{id}")
    void delete(long id);

    //修改公司名字
    @Update("update company set name='神月' where id=#{id}")
    void update(long id);

}
