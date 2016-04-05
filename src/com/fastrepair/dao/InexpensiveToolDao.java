package com.fastrepair.dao;

import com.fastrepair.model.Department;
import com.fastrepair.model.InexpensiveTool;

import java.util.List;

/**
 * Created by tage on 4/4/16.
 */
public interface InexpensiveToolDao {
   public  List<InexpensiveTool> getDepartmentTool(Department department) ;

   public   void add(InexpensiveTool inexpensiveTool);
}
