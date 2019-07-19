package com.user.demo.Mapper;

public class stu_company {
    private String name;
    private String companyname;

    @Override
    public String toString() {
        return "stu_company{" +
                "name='" + name + '\'' +
                ", companyname='" + companyname + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}
