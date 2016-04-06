package com.fastrepair.dao.impl;

import com.fastrepair.dao.InexpensiveToolDao;
import com.fastrepair.model.Department;
import com.fastrepair.model.InexpensiveTool;
import com.fastrepair.util.ToolState;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 4/4/16.
 */
public class InexpensiveToolDaoImpl implements InexpensiveToolDao {

   private  HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
@Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<InexpensiveTool> getDepartmentTool(Department department) {
        List<InexpensiveTool> inexpensiveTools = (List<InexpensiveTool>) hibernateTemplate.find("from InexpensiveTool it where it.department = ?",department);
        return inexpensiveTools;
    }


    @Override
    public void add(InexpensiveTool inexpensiveTool) {
        hibernateTemplate.save(inexpensiveTool);
    }


    @Override
    public List<InexpensiveTool> getStaffTools(int staffid) {
       return (List<InexpensiveTool>)hibernateTemplate.find("from InexpensiveTool it where it.staff.id=?",staffid);
    }

    @Override
    public List<InexpensiveTool> getStaffGoodTools(int staffid) {
        return (List<InexpensiveTool>)hibernateTemplate.find("from InexpensiveTool it where it.staff.id=? and it.toolState=?",staffid, ToolState.OUT);
    }
}
