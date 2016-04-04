package com.fastrepair.service;

import com.fastrepair.dao.CompanyDao;
import com.fastrepair.model.Company;

import java.util.List;

/**
 * Created by tage on 4/3/16.
 */

public class CompanyManager {

    private CompanyDao companyDao;

    public CompanyDao getCompanyDao() {
        return companyDao;
    }

    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }

    public Company load(int id) {
        return companyDao.load(id);
    }



}
