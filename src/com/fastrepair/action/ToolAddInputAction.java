package com.fastrepair.action;

import com.fastrepair.model.Department;
import com.fastrepair.service.DepartmentManager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by tage on 4/5/16.
 */
public class ToolAddInputAction extends ActionSupport {
    private String departmentid;

    private Department department;

    private DepartmentManager departmentManager;


    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public DepartmentManager getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(DepartmentManager departmentManager) {
        this.departmentManager = departmentManager;
    }

    @Override
    public String execute() throws Exception {
        department = departmentManager.load(Integer.parseInt(departmentid));
        return SUCCESS;
    }
}
