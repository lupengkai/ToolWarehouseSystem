package com.fastrepair.action;

import com.fastrepair.model.Department;
import com.fastrepair.model.ExpensiveTool;
import com.fastrepair.model.InexpensiveTool;
import com.fastrepair.service.CompanyManager;
import com.fastrepair.service.DepartmentManager;
import com.fastrepair.service.ExpensiveToolManager;
import com.fastrepair.service.InexpensiveToolManager;
import com.fastrepair.util.DepartmentType;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by tage on 4/5/16.
 */
public class ToolsListAction extends ActionSupport {
    private String company;
    private String department;

    private ExpensiveToolManager expensiveToolManager;
    private InexpensiveToolManager inexpensiveToolManager;
    private CompanyManager companyManager;
    private DepartmentManager departmentManager;
    private Department toolDepartment;


    public Department getToolDepartment() {
        return toolDepartment;
    }

    public void setToolDepartment(Department toolDepartment) {
        this.toolDepartment = toolDepartment;
    }

    private List<ExpensiveTool> expensiveToolList;
    private List<InexpensiveTool> inexpensiveToolList;

    public DepartmentManager getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(DepartmentManager departmentManager) {
        this.departmentManager = departmentManager;
    }

    public CompanyManager getCompanyManager() {
        return companyManager;
    }

    public void setCompanyManager(CompanyManager companyManager) {
        this.companyManager = companyManager;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ExpensiveToolManager getExpensiveToolManager() {
        return expensiveToolManager;
    }

    public void setExpensiveToolManager(ExpensiveToolManager expensiveToolManager) {
        this.expensiveToolManager = expensiveToolManager;
    }

    public InexpensiveToolManager getInexpensiveToolManager() {
        return inexpensiveToolManager;
    }

    public void setInexpensiveToolManager(InexpensiveToolManager inexpensiveToolManager) {
        this.inexpensiveToolManager = inexpensiveToolManager;
    }

    public List<ExpensiveTool> getExpensiveToolList() {
        return expensiveToolList;
    }

    public void setExpensiveToolList(List<ExpensiveTool> expensiveToolList) {
        this.expensiveToolList = expensiveToolList;
    }

    public List<InexpensiveTool> getInexpensiveToolList() {
        return inexpensiveToolList;
    }

    public void setInexpensiveToolList(List<InexpensiveTool> inexpensiveToolList) {
        this.inexpensiveToolList = inexpensiveToolList;
    }


    @Override
    public String execute() throws Exception {
        int companyId = Integer.parseInt(company);
        DepartmentType departmentType = DepartmentType.valueOf(department);
        Department department = departmentManager.loadByCompanyIdAndType(companyId,departmentType);
        inexpensiveToolList = inexpensiveToolManager.getDepartmentTool(department);
        expensiveToolList = expensiveToolManager.getDepartmentTool(department);
        toolDepartment = department;




        return SUCCESS;
    }
}
