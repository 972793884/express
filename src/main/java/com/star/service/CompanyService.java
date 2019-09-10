package com.star.service;

import com.star.vo.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    Company getCompanyById(Integer id);

    Integer saveCompany(Company company);

    Integer updateCompany(Company company);

    Integer delCompany(Integer id);
}
