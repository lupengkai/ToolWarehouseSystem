package com.fastrepair.model;

import com.fastrepair.util.DepartmentType;

import javax.persistence.*;

/**
 * Created by tage on 4/3/16.
 */
@Entity
public class Department {
    private int id;
    private DepartmentType departmentType;
    private Company company;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    @ManyToOne
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
