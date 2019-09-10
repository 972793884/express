package com.star.controller;

import com.star.Utils.PageUtils;
import com.star.Utils.Ret;
import com.star.service.CompanyService;
import com.star.vo.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("company")
@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    PageUtils pageUtils;


    @GetMapping("getCompanyList")
    Ret getCompanyList() {
        List<Company> list = companyService.findAll();
        return Ret.ok().set("companyList", list);
    }
    @GetMapping("getCompanyById")
    Ret getCompanyById(Integer id) {
        Company company= companyService.getCompanyById(id);
        return Ret.ok().set("company", company);
    }
    @GetMapping("saveCompany")
    Ret saveCompany(Company company) {
        Integer result= companyService.saveCompany(company);
        return result>0? Ret.ok():Ret.fail();
    }
    @GetMapping("updateCompany")
    Ret updateCompany(Company company ) {
        Integer result= companyService.updateCompany(company);
        return result>0? Ret.ok():Ret.fail();
    }
    @GetMapping("delCompany")
    Ret delCompany(Integer id) {
        Integer result= companyService.delCompany(id);
        return result>0? Ret.ok():Ret.fail();
    }
}
