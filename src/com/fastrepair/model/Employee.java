package com.fastrepair.model;

import com.fastrepair.util.DepartmentType;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tage on 4/3/16.
 */
@Entity
public class Employee extends Staff{
    private Department department;


@ManyToOne
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
