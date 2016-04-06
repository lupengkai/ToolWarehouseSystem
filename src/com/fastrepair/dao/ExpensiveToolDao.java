package com.fastrepair.dao;

import com.fastrepair.model.Department;
import com.fastrepair.model.ExpensiveTool;
import com.fastrepair.util.DepartmentType;

import java.util.List;

/**
 * Created by tage on 4/3/16.
 */
public interface ExpensiveToolDao {
    public List<ExpensiveTool> getAllExpensiveTools();

    public void add(ExpensiveTool expensiveTool);

    public List<ExpensiveTool> getDepartmentTool(Department department);

   public boolean isRequestStaff(int staffid,int tooid);
    public List<ExpensiveTool> getStaffTools(int staffid) ;

   public List<ExpensiveTool> getDepartmentFreeTool(DepartmentType departmentType);

    public List<ExpensiveTool> getFreeTool();

   public boolean request(int staffid, int toolid);

   public void lend(int toolid, int staffid);
}
