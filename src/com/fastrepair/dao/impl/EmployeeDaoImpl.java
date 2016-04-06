package com.fastrepair.dao.impl;

import com.fastrepair.dao.EmployeeDao;
import com.fastrepair.model.Employee;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;

/**
 * Created by tage on 4/6/16.
 */
public class EmployeeDaoImpl implements EmployeeDao {
private HibernateTemplate hibernateTemplate;


    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public Employee load(int id) {
        return hibernateTemplate.get(Employee.class, id);
    }
}
