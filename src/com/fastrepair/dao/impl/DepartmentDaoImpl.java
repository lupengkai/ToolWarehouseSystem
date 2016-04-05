package com.fastrepair.dao.impl;

import com.fastrepair.dao.DepartmentDao;
import com.fastrepair.model.Department;
import com.fastrepair.util.DepartmentType;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 4/4/16.
 */
public class DepartmentDaoImpl implements DepartmentDao {

    private HibernateTemplate hibernateTemplate;


    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public Department loadByCompanyIdAndType(int id, DepartmentType departmentType) {
        Department department = ((List<Department>)hibernateTemplate.find("from Department d where d.departmentType = ? and d.company.id = ?",departmentType,id)).get(0);
        return department;

    }

    @Override
    public Department load(int id) {
        return hibernateTemplate.load(Department.class,id);
    }
}
