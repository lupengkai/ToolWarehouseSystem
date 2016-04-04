package com.fastrepair.action;

import com.fastrepair.model.Employee;
import com.fastrepair.model.Specialist;
import com.fastrepair.model.Staff;
import com.fastrepair.service.StaffManager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by tage on 4/4/16.
 */
public class StaffInfoAction extends ActionSupport implements SessionAware{
    private StaffManager staffManager;
    private Staff staff = null;
    private Employee employee = null;
    private Specialist specialist = null;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    private Map<String, Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public StaffManager getStaffManager() {
        return staffManager;
    }

    public void setStaffManager(StaffManager staffManager) {
        this.staffManager = staffManager;
    }


    @Override
    public String execute() throws Exception {
        String username = (String)session.get("username");

        staff = staffManager.loadByName(username);
        if (staff instanceof Employee) {
            employee = (Employee) staff;
        } else if (staff instanceof Specialist) {
            specialist = (Specialist)staff;
        }

        return SUCCESS;
    }
}
