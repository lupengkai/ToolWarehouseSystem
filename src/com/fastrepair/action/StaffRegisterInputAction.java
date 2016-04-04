package com.fastrepair.action;

import com.fastrepair.model.Company;
import com.fastrepair.service.CompanyManager;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tage on 4/4/16.
 */
public class StaffRegisterInputAction extends ActionSupport {


    private CompanyManager companyManager;

    private List<Company> allCompanies;

    public List<Company> getAllCompanies() {
        return allCompanies;
    }

    public void setAllCompanies(List<Company> allCompanies) {
        this.allCompanies = allCompanies;
    }

    public CompanyManager getCompanyManager() {
        return companyManager;
    }


    public void setCompanyManager(CompanyManager companyManager) {
        this.companyManager = companyManager;
    }

    @Override
    public String execute() throws Exception {
        allCompanies = companyManager.getAllCompanies();
        return super.execute();
    }




}
