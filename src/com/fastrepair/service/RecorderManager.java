package com.fastrepair.service;

import com.fastrepair.dao.RecorderDao;
import com.fastrepair.model.Recorder;
import com.fastrepair.util.OperationType;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by tage on 4/6/16.
 */
public class RecorderManager {
    private RecorderDao recorderDao;


    public RecorderDao getRecorderDao() {
        return recorderDao;
    }

    public void setRecorderDao(RecorderDao recorderDao) {
        this.recorderDao = recorderDao;
    }


    public void add(Recorder recorder) {
        recorderDao.save(recorder);
    }


    public void record(int staffId, int toolId, OperationType operationType) {
        Recorder recorder = new Recorder();
        recorder.setTimestamp(new Timestamp(System.currentTimeMillis()));
        recorder.setOperationType(operationType);
        recorderDao.record(staffId, toolId, recorder);
    }

    public void reigster(int staffId, int toolId) {
        this.record(staffId, toolId, OperationType.REGISTER);
    }

    public void cancellation(int staffId, int toolId) {
        this.record(staffId, toolId, OperationType.CANCELLATION);
    }

    public void lendApprovedD(int staffId, int toolId) {
        this.record(staffId, toolId, OperationType.LENDAPPROVED);
    }

    public void lendRequest(int staffId, int toolId) {
        this.record(staffId, toolId, OperationType.LENDREQUEST);
    }

    public void delete(int toolId) {

    }


    public List<Recorder> find(int staffId, OperationType operationType) {
        return recorderDao.find(staffId, operationType);
    }

    public List<Recorder> findRequest(int staffId) {
        return recorderDao.find(staffId, OperationType.LENDREQUEST);
    }



    public List<Recorder> findLend(int staffId) {
        return recorderDao.find(staffId, OperationType.LENDAPPROVED);
    }

    public List<Recorder> findRegister(int staffId) {
        return recorderDao.find(staffId, OperationType.REGISTER);
    }

    public List<Recorder> findCancellation(int staffId) {
        return recorderDao.find(staffId, OperationType.CANCELLATION);
    }


}
