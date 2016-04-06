package com.fastrepair.dao.impl;

import com.fastrepair.dao.StaffDao;
import com.fastrepair.model.*;
import com.fastrepair.util.DepartmentType;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 4/3/16.
 */
public class StaffDaoImpl implements StaffDao {
    HibernateTemplate hibernateTemplate;


    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    public Staff loadByName(String name) {
        return ((List<Staff>)hibernateTemplate.find("from Staff s where s.name = ?" ,name)).get(0);
    }



    public void save(Staff staff) {
        if (staff instanceof Specialist) {
            hibernateTemplate.save((Specialist)staff);
        } else {
            hibernateTemplate.save((Employee)staff);
        }
    }

    public boolean checkUserExistsWithName(String name) {
        List<Staff> staffs = (List<Staff>) hibernateTemplate.find("from Staff s where s.name = ?",name);

        if (staffs != null && staffs.size() > 0) return true;
        return false;
    }

    @Override
    public boolean validate(Staff staff) {

        List<Staff> result = (List<Staff>)hibernateTemplate.find("from Staff s where s.name = ? and s.password = ?", staff.getName(),staff.getPassword());
        System.out.println(result);
        if (result != null && result.size()  > 0) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public Staff load(int id) {
       return hibernateTemplate.get(Staff.class,id);
    }
}
