package com.fastrepair.service;

import com.fastrepair.dao.DepartmentDao;
import com.fastrepair.model.Company;
import com.fastrepair.model.Department;
import com.fastrepair.util.DepartmentType;

import java.util.List;

/**
 * Created by tage on 4/3/16.
 */
public class DepartmentManager {
    private DepartmentDao departmentDao;



    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public Department loadByCompanyIdAndType(int id, DepartmentType departmentType) {
        return departmentDao.loadByCompanyIdAndType(id,departmentType);
    }


    public Department load(int id) {
        return departmentDao.load(id);
    }
}
