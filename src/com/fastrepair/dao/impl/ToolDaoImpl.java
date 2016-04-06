package com.fastrepair.dao.impl;

import com.fastrepair.dao.ToolDao;
import com.fastrepair.model.Employee;
import com.fastrepair.model.ExpensiveTool;
import com.fastrepair.model.Staff;
import com.fastrepair.model.Tool;
import com.fastrepair.util.ToolState;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;

/**
 * Created by tage on 4/5/16.
 */
public class ToolDaoImpl implements ToolDao {
    private HibernateTemplate hibernateTemplate;


    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void delete(int id) {
        hibernateTemplate.delete(hibernateTemplate.get(Tool.class,id));
    }


    @Override
    public void register(int toolid, int userid) {
        Tool tool = hibernateTemplate.get(Tool.class,toolid);
        tool.setToolState(ToolState.OUT);
        Staff staff = hibernateTemplate.get(Staff.class, userid);
        tool.setStaff(staff);
        hibernateTemplate.update(tool);
    }

    @Override
    public void lend(int toolid, int userid) {
        ExpensiveTool tool = hibernateTemplate.get(ExpensiveTool.class,toolid);
        tool.setToolState(ToolState.OUT);
        tool.setRequestStaff(null);
        Staff staff = hibernateTemplate.get(Staff.class, userid);
        tool.setStaff(staff);
        hibernateTemplate.update(tool);
    }

    @Override
    public boolean sameDepartment(int staffid, int toolid) {
       Employee employee = hibernateTemplate.get(Employee.class, staffid);
        Tool tool = hibernateTemplate.get(Tool.class, toolid);

        if (employee.getDepartmentType().equals(tool.getDepartment().getDepartmentType())) {
            return true;
        }

        return false;
    }

    @Override
    public Tool load(int toolId) {
        return hibernateTemplate.get(Tool.class,toolId);
    }

    @Override
    public void update(Tool tool) {
        hibernateTemplate.update(tool);
    }
}
