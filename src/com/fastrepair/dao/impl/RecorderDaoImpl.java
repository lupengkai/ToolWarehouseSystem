package com.fastrepair.dao.impl;

import com.fastrepair.dao.RecorderDao;
import com.fastrepair.model.Recorder;
import com.fastrepair.model.Staff;
import com.fastrepair.model.Tool;
import com.fastrepair.util.OperationType;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 4/6/16.
 */
public class RecorderDaoImpl implements RecorderDao{
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void save(Recorder recorder) {
        hibernateTemplate.save(recorder);
    }

    @Override
    public void record(int staffId, int toolId,Recorder recorder) {
        Staff staff = hibernateTemplate.get(Staff.class,staffId);
        Tool tool = hibernateTemplate.get(Tool.class,toolId);
        recorder.setStaff(staff);
        recorder.setTool(tool);
        hibernateTemplate.save(recorder);

    }

    @Override
    public List<Recorder> find(int staffId, OperationType operationType) {
        Staff staff = hibernateTemplate.get(Staff.class, staffId);
        return (List<Recorder>)hibernateTemplate.find("from Recorder r where r.staff=? and r.operationType=? order by r.timestamp",staff,operationType);
    }
}
