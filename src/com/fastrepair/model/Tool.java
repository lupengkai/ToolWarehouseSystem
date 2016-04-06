package com.fastrepair.model;

import com.fastrepair.util.ToolState;

import javax.persistence.*;

/**
 * Created by tage on 4/3/16.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class    Tool {
    private int id;
    private String name;
    private Department department;
    private double price;
    private Staff staff;
    private ToolState toolState;
    private int version;

   @Version//乐观锁
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public ToolState getToolState() {
        return toolState;
    }

    public void setToolState(ToolState toolState) {
        this.toolState = toolState;
    }
@ManyToOne
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
