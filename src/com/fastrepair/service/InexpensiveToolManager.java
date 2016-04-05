package com.fastrepair.service;

import com.fastrepair.dao.InexpensiveToolDao;
import com.fastrepair.model.Department;
import com.fastrepair.model.InexpensiveTool;

import java.util.List;

/**
 * Created by tage on 4/3/16.
 */
public class InexpensiveToolManager {

    private InexpensiveToolDao inexpensiveToolDao;

    public InexpensiveToolDao getInexpensiveToolDao() {
        return inexpensiveToolDao;
    }

    public void setInexpensiveToolDao(InexpensiveToolDao inexpensiveToolDao) {
        this.inexpensiveToolDao = inexpensiveToolDao;
    }

    public List<InexpensiveTool> getDepartmentTool(Department department) {
        return inexpensiveToolDao.getDepartmentTool(department);
    }


    public void add(InexpensiveTool inexpensiveTool) {
        inexpensiveToolDao.add(inexpensiveTool);
    }
}
