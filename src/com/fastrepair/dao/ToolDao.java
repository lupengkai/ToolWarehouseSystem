package com.fastrepair.dao;

import com.fastrepair.model.Tool;

/**
 * Created by tage on 4/5/16.
 */
public interface ToolDao {
   public void delete(int id);

    public void register(int toolid, int userid);

   public void lend(int toolid, int userid);

    public boolean sameDepartment(int staffid, int toolid);

   public Tool load(int toolId);

   public void update(Tool tool);
}
