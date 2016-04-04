package com.fastrepair.action;

import com.fastrepair.model.ExpensiveTool;
import com.fastrepair.service.ExpensiveToolManager;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by tage on 4/4/16.
 */
public class ExpensiveToolsManageAction extends ActionSupport{
    private ExpensiveToolManager expensiveToolManager;
    private List<ExpensiveTool> expensiveTools;


    public ExpensiveToolManager getExpensiveToolManager() {
        return expensiveToolManager;
    }

    public void setExpensiveToolManager(ExpensiveToolManager expensiveToolManager) {
        this.expensiveToolManager = expensiveToolManager;
    }

    public List<ExpensiveTool> getExpensiveTools() {
        return expensiveTools;
    }

    public void setExpensiveTools(List<ExpensiveTool> expensiveTools) {
        this.expensiveTools = expensiveTools;
    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}
