package com.fastrepair.action;

import com.fastrepair.model.ExpensiveTool;
import com.fastrepair.model.InexpensiveTool;
import com.fastrepair.service.DepartmentManager;
import com.fastrepair.service.ExpensiveToolManager;
import com.fastrepair.service.InexpensiveToolManager;
import com.fastrepair.util.ToolState;
import com.fastrepair.vo.ToolAddInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by tage on 4/5/16.
 */
public class ToolAddAction extends ActionSupport implements ModelDriven{
    private ToolAddInfo toolAddInfo = new ToolAddInfo();
    private DepartmentManager departmentManager;
    private InexpensiveToolManager inexpensiveToolManager;
    private ExpensiveToolManager expensiveToolManager;


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

    public DepartmentManager getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(DepartmentManager departmentManager) {
        this.departmentManager = departmentManager;
    }

    public ToolAddInfo getToolAddInfo() {
        return toolAddInfo;
    }

    public void setToolAddInfo(ToolAddInfo toolAddInfo) {
        this.toolAddInfo = toolAddInfo;
    }

    @Override
    public Object getModel() {
        return toolAddInfo;
    }


    @Override
    public String execute() throws Exception {
        double price = Double.parseDouble(toolAddInfo.getToolprice());
        if (price < 200.0) {
            InexpensiveTool inexpensiveTool = new InexpensiveTool();
            inexpensiveTool.setName(toolAddInfo.getToolname());
            inexpensiveTool.setPrice(price);
            inexpensiveTool.setDepartment(departmentManager.load(Integer.parseInt(toolAddInfo.getDepartmentid())));
            inexpensiveTool.setToolState(ToolState.FREE);
            inexpensiveToolManager.add(inexpensiveTool);

        } else {
            ExpensiveTool expensiveTool = new ExpensiveTool();
            expensiveTool.setName(toolAddInfo.getToolname());
            expensiveTool.setPrice(price);
            expensiveTool.setDepartment(departmentManager.load(Integer.parseInt(toolAddInfo.getDepartmentid())));
            expensiveTool.setToolState(ToolState.FREE);
            expensiveToolManager.add(expensiveTool);
        }

        return SUCCESS;

    }
}
