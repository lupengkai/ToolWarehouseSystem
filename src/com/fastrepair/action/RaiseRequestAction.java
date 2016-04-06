package com.fastrepair.action;

import com.fastrepair.service.ExpensiveToolManager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by tage on 4/6/16.
 */
public class RaiseRequestAction extends ActionSupport {
    private String staffid;
    private String toolid;
    private ExpensiveToolManager expensiveToolManager;

    public ExpensiveToolManager getExpensiveToolManager() {
        return expensiveToolManager;
    }

    public void setExpensiveToolManager(ExpensiveToolManager expensiveToolManager) {
        this.expensiveToolManager = expensiveToolManager;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getToolid() {
        return toolid;
    }

    public void setToolid(String toolid) {
        this.toolid = toolid;
    }

    @Override
    public String execute() throws Exception {
        int sid = Integer.parseInt(staffid);
        int tid = Integer.parseInt(toolid);
        if (expensiveToolManager.request(sid, tid)) {
            return SUCCESS;
        } else {
            return ERROR;
        }


    }
}
