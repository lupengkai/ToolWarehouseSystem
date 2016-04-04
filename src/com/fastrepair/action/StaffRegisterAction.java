package com.fastrepair.action;

import com.fastrepair.model.Employee;
import com.fastrepair.model.Specialist;
import com.fastrepair.model.Staff;
import com.fastrepair.service.CompanyManager;
import com.fastrepair.service.StaffManager;
import com.fastrepair.util.DepartmentType;
import com.fastrepair.vo.StaffRegisterInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by tage on 4/4/16.
 */
public class StaffRegisterAction extends ActionSupport implements ModelDriven {

    private StaffRegisterInfo staffRegisterInfo = new StaffRegisterInfo();
    private StaffManager staffManager;
    private CompanyManager companyManager;

    public StaffRegisterInfo getStaffRegisterInfo() {
        return staffRegisterInfo;
    }

    public void setStaffRegisterInfo(StaffRegisterInfo staffRegisterInfo) {
        this.staffRegisterInfo = staffRegisterInfo;
    }

    public StaffManager getStaffManager() {
        return staffManager;
    }

    public void setStaffManager(StaffManager staffManager) {
        this.staffManager = staffManager;
    }

    public CompanyManager getCompanyManager() {
        return companyManager;
    }

    public void setCompanyManager(CompanyManager companyManager) {
        this.companyManager = companyManager;
    }

    @Override
    public String execute() throws Exception {
        Staff staff = null;

        if (staffRegisterInfo.getStaff().trim().equals("employee")) {
            Employee employee = new Employee();
            employee.setDepartmentType(DepartmentType.valueOf(staffRegisterInfo.getDepartment()));
            employee.setName(staffRegisterInfo.getUsername());
            employee.setPassword(staffRegisterInfo.getPassword1());
            employee.setCompany(companyManager.load(Integer.parseInt(staffRegisterInfo.getCompany())));
            staff = employee;
        } else if (staffRegisterInfo.getStaff().trim().equals("specialist")) {
            Specialist specialist = new Specialist();
            specialist.setCompany(companyManager.load(Integer.parseInt(staffRegisterInfo.getCompany())));
            specialist.setName(staffRegisterInfo.getUsername());
            specialist.setPassword(staffRegisterInfo.getPassword1());
            staff = specialist;
        }


        if (staffManager.add(staff)) {
            return SUCCESS;
        } else {
            return "fail";
        }


    }

    @Override
    public Object getModel() {
        return staffRegisterInfo;
    }
}
