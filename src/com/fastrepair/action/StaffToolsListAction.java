package com.fastrepair.action;

import com.fastrepair.model.ExpensiveTool;
import com.fastrepair.model.InexpensiveTool;
import com.fastrepair.model.Tool;
import com.fastrepair.service.ExpensiveToolManager;
import com.fastrepair.service.InexpensiveToolManager;
import com.fastrepair.service.ToolManager;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by tage on 4/4/16.
 */
public class StaffToolsListAction extends ActionSupport{
    private InexpensiveToolManager inexpensiveToolManager;
    private ExpensiveToolManager expensiveToolManager;

    private List<ExpensiveTool> expensiveTools;
    private List<InexpensiveTool> inexpensiveTools;

    public List<ExpensiveTool> getExpensiveTools() {
        return expensiveTools;
    }

    public void setExpensiveTools(List<ExpensiveTool> expensiveTools) {
        this.expensiveTools = expensiveTools;
    }

    public List<InexpensiveTool> getInexpensiveTools() {
        return inexpensiveTools;
    }

    public void setInexpensiveTools(List<InexpensiveTool> inexpensiveTools) {
        this.inexpensiveTools = inexpensiveTools;
    }

    public InexpensiveToolManager getInexpensiveToolManager() {
        return inexpensiveToolManager;
    }

    public void setInexpensiveToolManager(InexpensiveToolManager inexpensiveToolManager) {
        this.inexpensiveToolManager = inexpensiveToolManager;
    }

    public ExpensiveToolManager getExpensiveToolManager() {
        return expensiveToolManager;
    }

    public void setExpensiveToolManager(ExpensiveToolManager expensiveToolManager) {
        this.expensiveToolManager = expensiveToolManager;
    }



    private String staffid;

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String inexpensive() {
System.out.print(staffid);
        inexpensiveTools = inexpensiveToolManager.getStaffGoodTools(Integer.parseInt(staffid));


        return SUCCESS;
    }


    public String expensive() {
        expensiveTools = expensiveToolManager.getStaffTools(Integer.parseInt(staffid));


        return SUCCESS;
    }
}
