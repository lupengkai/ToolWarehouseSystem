package com.fastrepair.dao;

import com.fastrepair.model.Company;

import java.util.List;

/**
 * Created by tage on 4/3/16.
 */
public interface CompanyDao {
    public List<Company> getAllCompanies();
    public Company load(int id);
}
