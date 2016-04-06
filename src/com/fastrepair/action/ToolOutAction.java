package com.fastrepair.action;

import com.fastrepair.model.Employee;
import com.fastrepair.model.Specialist;
import com.fastrepair.model.Staff;
import com.fastrepair.service.ExpensiveToolManager;
import com.fastrepair.service.RecorderManager;
import com.fastrepair.service.StaffManager;
import com.fastrepair.service.ToolManager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by tage on 4/5/16.
 */
public class ToolOutAction extends ActionSupport {

    private String toolid;
    private String username;
    private String password;
    private ExpensiveToolManager expensiveToolManager;
    private RecorderManager recorderManager;

    public RecorderManager getRecorderManager() {
        return recorderManager;
    }

    public void setRecorderManager(RecorderManager recorderManager) {
        this.recorderManager = recorderManager;
    }

    public ExpensiveToolManager getExpensiveToolManager() {
        return expensiveToolManager;
    }

    public void setExpensiveToolManager(ExpensiveToolManager expensiveToolManager) {
        this.expensiveToolManager = expensiveToolManager;
    }

    private StaffManager staffManager;
    private ToolManager toolManager;

    public ToolManager getToolManager() {
        return toolManager;
    }

    public void setToolManager(ToolManager toolManager) {
        this.toolManager = toolManager;
    }

    public StaffManager getStaffManager() {
        return staffManager;
    }

    public void setStaffManager(StaffManager staffManager) {
        this.staffManager = staffManager;
    }

    public String getToolid() {
        return toolid;
    }

    public void setToolid(String toolid) {
        this.toolid = toolid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String register() {
        Staff staff = new Staff();
        staff.setName(username);
        staff.setPassword(password);

        if (staffManager.validate(staff)) {
            int id = Integer.parseInt(toolid);
            staff = staffManager.loadByName(username);
            if (staff instanceof Specialist) {//specialist
                toolManager.register(id, staff.getId());
                recorderManager.reigster(staff.getId(),id);

                return SUCCESS;
            } else {//employee
                if (toolManager.sameDepartment(staff.getId(), id)) {
                    toolManager.register(id, staff.getId());
                    recorderManager.reigster(staff.getId(),id);
                    return SUCCESS;
                }
            }


        }

        return ERROR;

    }


    public String lend() {
        Staff staff = new Staff();
        staff.setName(username);
        staff.setPassword(password);

        if (staffManager.validate(staff)) {
            staff = staffManager.loadByName(username);
            int id = Integer.parseInt(toolid);
            if (expensiveToolManager.isRequestStaff(staff.getId(), id)) {
                expensiveToolManager.lend(id, staff.getId());
                recorderManager.lendApprovedD(staff.getId(),id);
                return SUCCESS;
            }
        }

        return ERROR;
    }
}
