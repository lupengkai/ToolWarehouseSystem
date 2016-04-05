package com.fastrepair.dao;

import com.fastrepair.model.Department;
import com.fastrepair.model.ExpensiveTool;

import java.util.List;

/**
 * Created by tage on 4/3/16.
 */
public interface ExpensiveToolDao {
    public List<ExpensiveTool> getAllExpensiveTools();

    public void add(ExpensiveTool expensiveTool);

    List<ExpensiveTool> getDepartmentTool(Department department);
}
