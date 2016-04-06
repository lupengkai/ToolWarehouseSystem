package com.fastrepair.action;

import com.fastrepair.model.Recorder;
import com.fastrepair.service.RecorderManager;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by tage on 4/6/16.
 */
public class StaffRecordShow extends ActionSupport {
    private String staffid;
    private RecorderManager recorderManager;
    private List<Recorder> recorderList;

    public List<Recorder> getRecorderList() {
        return recorderList;
    }

    public void setRecorderList(List<Recorder> recorderList) {
        this.recorderList = recorderList;
    }

    public RecorderManager getRecorderManager() {
        return recorderManager;
    }

    public void setRecorderManager(RecorderManager recorderManager) {
        this.recorderManager = recorderManager;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }


    public String request() {

        recorderList = recorderManager.findRequest(Integer.parseInt(staffid));
        return SUCCESS;
    }
   public String lend() {

        recorderList = recorderManager.findLend(Integer.parseInt(staffid));
        return SUCCESS;
    }
   public String register() {

        recorderList = recorderManager.findRegister(Integer.parseInt(staffid));
        return SUCCESS;
    }

   public String cancellation() {

        recorderList = recorderManager.findCancellation(Integer.parseInt(staffid));
        return SUCCESS;
    }

}
