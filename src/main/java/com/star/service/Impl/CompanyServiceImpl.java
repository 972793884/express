package com.star.service.Impl;

import com.star.mapper.CompanyMapper;
import com.star.service.CompanyService;
import com.star.vo.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyMapper companyMapper;
    @Override
    public List<Company> findAll() {
        return companyMapper.findAll();
    }

    @Override
    public Company getCompanyById(Integer id) {
        return companyMapper.getCompanyById(id);
    }

    @Override
    public Integer saveCompany(Company company) {
        company.setIsDelete(0);
        return companyMapper.saveCompany(company);
    }

    @Override
    public Integer updateCompany(Company company) {
        return companyMapper.updateCompany(company);
    }

    @Override
    public Integer delCompany(Integer id) {
        Company company =getCompanyById(id);
        company.setIsDelete(1);
        return companyMapper.updateCompany(company);
    }
}
