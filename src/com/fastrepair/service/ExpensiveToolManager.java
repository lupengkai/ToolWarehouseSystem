package com.fastrepair.service;

import com.fastrepair.dao.ExpensiveToolDao;
import com.fastrepair.model.Department;
import com.fastrepair.model.ExpensiveTool;

import java.util.List;

/**
 * Created by tage on 4/3/16.
 */
public class ExpensiveToolManager {



    private ExpensiveToolDao expensiveToolDao;





    public ExpensiveToolDao getExpensiveToolDao() {
        return expensiveToolDao;
    }

    public void setExpensiveToolDao(ExpensiveToolDao expensiveToolDao) {
        this.expensiveToolDao = expensiveToolDao;
    }

    public List<ExpensiveTool> getAllExpensiveTools() {
        return expensiveToolDao.getAllExpensiveTools();
    }


    public void add(ExpensiveTool expensiveTool) {
        expensiveToolDao.add(expensiveTool);
    }



    public List<ExpensiveTool> getDepartmentTool(Department department) {
        return expensiveToolDao.getDepartmentTool(department);
    }

    public boolean isRequestStaff(int staffid, int toolid) {
        return  expensiveToolDao.isRequestStaff(staffid,toolid);
    }


    public List<ExpensiveTool> getStaffTools(int staffid) {
        return expensiveToolDao.getStaffTools(staffid);
    }


}
