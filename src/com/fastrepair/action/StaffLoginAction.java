package com.fastrepair.action;

import com.fastrepair.model.Company;
import com.fastrepair.model.Department;
import com.fastrepair.model.Staff;
import com.fastrepair.service.StaffManager;
import com.fastrepair.util.DepartmentType;
import com.fastrepair.vo.StaffLoginInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tage on 4/3/16.
 */
public class StaffLoginAction extends ActionSupport implements ModelDriven {
    private StaffLoginInfo staffLoginInfo = new StaffLoginInfo();
    private StaffManager staffManager;


    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    private Staff staff;

    public StaffLoginInfo getStaffLoginInfo() {
        return staffLoginInfo;
    }

    public void setStaffLoginInfo(StaffLoginInfo staffLoginInfo) {
        this.staffLoginInfo = staffLoginInfo;
    }


    public StaffManager getStaffManager() {
        return staffManager;
    }

    public void setStaffManager(StaffManager staffManager) {
        this.staffManager = staffManager;
    }

    public String login() throws Exception {


        Staff staff = new Staff();
        staff.setName(staffLoginInfo.getUsername());
        staff.setPassword(staffLoginInfo.getPassword());
        if (staffManager.validate(staff)) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("username", staffLoginInfo.getUsername());
            this.staff = staffManager.loadByName(staffLoginInfo.getUsername());
            System.out.println(staff.getId());
            return SUCCESS;
        } else {
            return "fail";
        }


    }

    @Override
    public Object getModel() {
        return staffLoginInfo;
    }
}
