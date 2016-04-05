package com.fastrepair.action;

import com.fastrepair.service.ToolManager;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * Created by tage on 4/5/16.
 */
public class ToolManageAction extends ActionSupport {
    private String toolid;


private ToolManager toolManager;

    public ToolManager getToolManager() {
        return toolManager;
    }

    public void setToolManager(ToolManager toolManager) {
        this.toolManager = toolManager;
    }

    public String getToolid() {
        return toolid;
    }

    public void setToolid(String toolid) {
        this.toolid = toolid;
    }


    public String delete() {

        toolManager.delete(Integer.parseInt(toolid));



        return SUCCESS;
    }

    public String lend() {
        return SUCCESS;
    }

    public String register() {
        return SUCCESS;
    }


}
