package com.fastrepair.model;

import com.fastrepair.util.OperationType;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tage on 4/3/16.
 */
@Entity
public class Recorder {
    private int id;
    private Staff staff;
    private Tool tool;
    private Timestamp timestamp;
    private OperationType operationType;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

@ManyToOne
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

@ManyToOne
    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}
