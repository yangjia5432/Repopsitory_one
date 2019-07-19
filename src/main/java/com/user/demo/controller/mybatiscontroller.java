package com.user.demo.controller;

import com.user.demo.Mapper.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.user.demo.service.stuservice;

import java.util.List;

@Controller
@RequestMapping(value = "/mybatiscon")
public class mybatiscontroller {

    @Autowired
    private stuservice stuservice;
    //@ResponseBody
    //查询id为1的公司
    @GetMapping("/boot/stucompany")
    public Object stucp(){
        return stuservice.getcompany();
    }

    //根据用户Id通过@one一对一查询用户和所在公司
    @GetMapping("/boot/stuwithcompany")
    public Object stucomp(){
        return stuservice.getstuwithcompany();}

//通过多表关联查询出用户和所在公司
    @GetMapping("/boot/stuwithcompanyselect")
    public Object selectuserall(){
        return stuservice.selectcompany();}

//通过@Transactional实现事务控制，对公司信息的添加
    @GetMapping("/boot/stuwithcompanyadd")
    public void addcompany(){
         stuservice.adds();}

//动态sql，通过条件判断查询公司信息
    @GetMapping("/boot/stuwithcompanyadddongtai")
    public List<Company> selectcompany(){
       return stuservice.selectbydtai();
    }

    //添加方式二，通过从浏览器获取信息进行添加
    @RequestMapping(value = "/pyadd")
    public String pyaddHtml(){
        return "pyadd";    }

@RequestMapping("/addc")
    public String addc(@RequestParam("id") long id, @RequestParam("name") String name){
    stuservice.Adduser(id,name);
    return "succse";

}
//根据id删除公司
    @GetMapping("/boot/deletecompanybyid")
    public String deletebyid(){
        stuservice.Delete();
        return "del_succse";
    }

 //修改公司名字根据id
 @GetMapping("/boot/companybyupdateid")
 public String updatecompanybyid(){
     stuservice.Update();
     return "update_succse";
 }
}
