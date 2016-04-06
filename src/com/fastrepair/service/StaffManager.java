package com.fastrepair.service;

import com.fastrepair.dao.StaffDao;
import com.fastrepair.model.Employee;
import com.fastrepair.model.Specialist;
import com.fastrepair.model.Staff;

/**
 * Created by tage on 4/3/16.
 */
public class StaffManager {
    private StaffDao staffDao;


    public boolean validate(Staff staff) {
        return staffDao.validate(staff);
    }

    public boolean exists(Staff staff) throws Exception {
        return staffDao.checkUserExistsWithName(staff.getName());

    }


    public boolean add(Staff staff) throws Exception {
        if (exists(staff)) {
            return false;
        }
        staffDao.save(staff);
        return true;
    }


    public StaffDao getStaffDao() {
        return staffDao;
    }




    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public Staff loadByName(String name) {
        return staffDao.loadByName(name);
    }


    public boolean isEmployee(int id) {
       Staff staff =  staffDao.load(id);
        return (staff instanceof Employee);

    }

    public boolean isSpecialist(int id) {
        Staff staff =  staffDao.load(id);
        return (staff instanceof Specialist);
    }


}
