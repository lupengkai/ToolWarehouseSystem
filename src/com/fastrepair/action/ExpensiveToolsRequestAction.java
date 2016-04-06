package com.fastrepair.action;

import com.fastrepair.model.ExpensiveTool;
import com.fastrepair.service.EmployeeManager;
import com.fastrepair.service.ExpensiveToolManager;
import com.fastrepair.service.StaffManager;
import com.fastrepair.util.DepartmentType;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by tage on 4/5/16.
 */
public class ExpensiveToolsRequestAction extends ActionSupport {
    private String staffid;
    private StaffManager staffManager;
    private ExpensiveToolManager expensiveToolManager;
    private EmployeeManager employeeManager;

    public EmployeeManager getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    public ExpensiveToolManager getExpensiveToolManager() {
        return expensiveToolManager;
    }

    public void setExpensiveToolManager(ExpensiveToolManager expensiveToolManager) {
        this.expensiveToolManager = expensiveToolManager;
    }

    private List<ExpensiveTool>  expensiveToolList;

    public List<ExpensiveTool> getExpensiveToolList() {
        return expensiveToolList;
    }

    public void setExpensiveToolList(List<ExpensiveTool> expensiveToolList) {
        this.expensiveToolList = expensiveToolList;
    }

    public StaffManager getStaffManager() {
        return staffManager;
    }

    public void setStaffManager(StaffManager staffManager) {
        this.staffManager = staffManager;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    @Override
    public String execute() throws Exception {
        int id = Integer.parseInt(staffid);


        if (staffManager.isEmployee(id)) {
            System.out.println("is employee");
            DepartmentType departmentType = employeeManager.getEmployeeDepartmentType(id);
           expensiveToolList =  expensiveToolManager.getDepartmentFreeTool(departmentType);

        } else if (staffManager.isSpecialist(id)) {
            System.out.println("is specialist");
            expensiveToolList = expensiveToolManager.getFreeTool();

        }
        return SUCCESS;
    }
}
