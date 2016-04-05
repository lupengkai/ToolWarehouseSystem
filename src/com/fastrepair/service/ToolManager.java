package com.fastrepair.service;

import com.fastrepair.dao.ToolDao;

/**
 * Created by tage on 4/5/16.
 */
public class ToolManager {
private ToolDao toolDao;

    public ToolDao getToolDao() {
        return toolDao;
    }

    public void setToolDao(ToolDao toolDao) {
        this.toolDao = toolDao;
    }


    public void delete(int id) {
        toolDao.delete(id);
    }

    public void register(int toolid, int userid) {
        toolDao.register(toolid,userid);
    }

    public void lend(int toolid, int userid) {
        toolDao.lend(toolid, userid);
    }

    public boolean sameDepartment(int staffid, int toolid) {
        return toolDao.sameDepartment(staffid, toolid);
    }
}
