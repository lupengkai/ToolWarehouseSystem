package com.fastrepair.service;

import com.fastrepair.dao.EmployeeDao;
import com.fastrepair.model.Employee;
import com.fastrepair.util.DepartmentType;

/**
 * Created by tage on 4/3/16.
 */
public class EmployeeManager {

    private EmployeeDao employeeDao;


    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public DepartmentType getEmployeeDepartmentType(int id) {
        Employee employee =  employeeDao.load(id);
        return employee.getDepartmentType();
    }
}
