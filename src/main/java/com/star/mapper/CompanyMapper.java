package com.star.mapper;

import com.star.vo.Company;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CompanyMapper {
    @Select("select * from company where is_delete=0")
    List<Company> findAll();
    @Select("select * from company where id=#{id}")
    Company getCompanyById(@Param("id") Integer id);
    @Insert("insert into company(name,is_delete) values(#{name},#{isDelete})")
    Integer saveCompany(Company company);
    @Update("update company set id=#{id},name=#{name},is_delete=#{isDelete} where id=#{id}")
    Integer updateCompany(Company company);
}
