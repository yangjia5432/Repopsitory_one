package com.user.demo.Dao;

import com.user.demo.Mapper.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Mapper
@Repository
public interface AccountMappe {

    @Select("SELECT * FROM account WHERE user_id = #{id}")
    @Results({@Result(property ="accountName",column = "name")})
    Account getAccountByUserId(@Param("id") long id);


}
