package com.fastrepair.dao;

import com.fastrepair.model.Recorder;
import com.fastrepair.util.OperationType;

import java.util.List;

/**
 * Created by tage on 4/6/16.
 */
public interface RecorderDao {
    public void save(Recorder recorder);

   public void record(int staffId, int toolId, Recorder recorder);

    public List<Recorder> find(int staffId, OperationType operationType);
}
