package com.fastrepair.action;

import com.fastrepair.service.RecorderManager;
import com.fastrepair.service.ToolManager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by tage on 4/5/16.
 */
public class ToolCancellationAction extends ActionSupport {
    private String toolid;
    private RecorderManager recorderManager;
    private String staffid;

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public RecorderManager getRecorderManager() {
        return recorderManager;
    }

    public void setRecorderManager(RecorderManager recorderManager) {
        this.recorderManager = recorderManager;
    }

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


    public String execute() {

        toolManager.cancellation(Integer.parseInt(toolid));
        recorderManager.cancellation(Integer.parseInt(staffid),Integer.parseInt(toolid));




        return SUCCESS;
    }



}
