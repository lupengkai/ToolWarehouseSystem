package com.fastrepair.dao.impl;

import com.fastrepair.dao.ExpensiveToolDao;
import com.fastrepair.model.Department;
import com.fastrepair.model.ExpensiveTool;
import com.fastrepair.model.Staff;
import com.fastrepair.model.Tool;
import com.fastrepair.util.DepartmentType;
import com.fastrepair.util.ToolState;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 4/4/16.
 */
public class ExpensiveToolDaoImpl implements ExpensiveToolDao {
    private HibernateTemplate hibernateTemplate;


    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
@Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<ExpensiveTool> getAllExpensiveTools() {
        return (List<ExpensiveTool>)hibernateTemplate.find("from ExpensiveTool et");
    }

    @Override
    public void add(ExpensiveTool expensiveTool) {
        hibernateTemplate.save(expensiveTool);
    }

    @Override
    public List<ExpensiveTool> getDepartmentTool(Department department) {
        List<ExpensiveTool> expensiveTools = (List<ExpensiveTool>) hibernateTemplate.find("from ExpensiveTool et where et.department = ?",department);
        return expensiveTools;
    }

    @Override
    public boolean isRequestStaff(int staffid, int toolid) {
        ExpensiveTool tool = hibernateTemplate.get(ExpensiveTool.class,toolid);
        if (tool.getRequestStaff().getId() == staffid) {
            return true;
        } else {
            return false;
        }

    }



    public List<ExpensiveTool> getStaffTools(int staffid) {
        return (List<ExpensiveTool>)hibernateTemplate.find("from ExpensiveTool et where et.staff.id=?",staffid);
    }


    @Override
    public List<ExpensiveTool> getDepartmentFreeTool(DepartmentType departmentType) {
       return (List<ExpensiveTool>)hibernateTemplate.find("from ExpensiveTool et where et.department.departmentType=? and et.toolState=?",departmentType, ToolState.FREE);
    }


    @Override
    public List<ExpensiveTool> getFreeTool() {
        return (List<ExpensiveTool>)hibernateTemplate.find("from ExpensiveTool et where et.toolState=?",ToolState.FREE);
    }


    @Override
    public boolean request(int staffid, int toolid) {

       ExpensiveTool requestedTool = hibernateTemplate.get(ExpensiveTool.class,toolid);
        Staff staff = hibernateTemplate.get(Staff.class,staffid);
        if (requestedTool.getToolState().equals(ToolState.FREE)) {
            requestedTool.setRequestStaff(staff);
            requestedTool.setToolState(ToolState.REQUESTING);
            hibernateTemplate.update(requestedTool);
            return true;
        }
        return false;

    }



    public void lend(int toolid, int staffid) {
        ExpensiveTool tool = hibernateTemplate.get(ExpensiveTool.class,toolid);
        tool.setToolState(ToolState.OUT);
        tool.setRequestStaff(null);
        Staff staff = hibernateTemplate.get(Staff.class, staffid);
        tool.setStaff(staff);
        hibernateTemplate.update(tool);
    }
}
