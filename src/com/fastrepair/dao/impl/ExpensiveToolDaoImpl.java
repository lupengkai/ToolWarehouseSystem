package com.fastrepair.dao.impl;

import com.fastrepair.dao.ExpensiveToolDao;
import com.fastrepair.model.Department;
import com.fastrepair.model.ExpensiveTool;
import com.fastrepair.model.Staff;
import com.fastrepair.model.Tool;
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
        Tool tool = hibernateTemplate.get(Tool.class,toolid);
        if (tool.getStaff().getId() == staffid) {
            return true;
        } else {
            return false;
        }

    }



    public List<ExpensiveTool> getStaffTools(int staffid) {
        return (List<ExpensiveTool>)hibernateTemplate.find("from ExpensiveTool et where et.staff.id=?",staffid);
    }
}
