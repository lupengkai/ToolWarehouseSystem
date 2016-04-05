package com.fastrepair.dao;

/**
 * Created by tage on 4/5/16.
 */
public interface ToolDao {
   public void delete(int id);

    public void register(int toolid, int userid);

   public void lend(int toolid, int userid);

    public boolean sameDepartment(int staffid, int toolid);
}
