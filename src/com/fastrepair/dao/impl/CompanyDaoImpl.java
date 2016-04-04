package com.fastrepair.dao.impl;

import com.fastrepair.dao.CompanyDao;
import com.fastrepair.model.Company;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 4/4/16.
 */
public class CompanyDaoImpl implements CompanyDao {

    private HibernateTemplate hibernateTemplate;

    public List<Company> getAllCompanies() {
        return (List<Company>)hibernateTemplate.find("from Company c");
    }


    @Override
    public Company load(int id) {
        return hibernateTemplate.load(Company.class,id);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
@Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
