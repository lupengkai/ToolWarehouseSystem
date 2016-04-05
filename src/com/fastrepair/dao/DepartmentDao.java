package com.fastrepair.dao;

import com.fastrepair.model.Department;
import com.fastrepair.util.DepartmentType;

/**
 * Created by tage on 4/3/16.
 */
public interface DepartmentDao {
    public Department loadByCompanyIdAndType(int id, DepartmentType departmentType);

    public Department load(int id);
}
