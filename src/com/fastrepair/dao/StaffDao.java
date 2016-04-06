package com.fastrepair.dao;

import com.fastrepair.model.Staff;

/**
 * Created by tage on 4/3/16.
 */
public interface StaffDao {

    public void save(Staff staff);
    public boolean checkUserExistsWithName(String username);

   public boolean validate(Staff staff);
    public Staff loadByName(String name);

    public Staff load(int id);
}
