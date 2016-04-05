package com.fastrepair.action;

import com.fastrepair.model.Company;
import com.fastrepair.service.CompanyManager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by tage on 4/4/16.
 */
public class AdminLoginAction extends ActionSupport{

    private CompanyManager companyManager;
    private String username;
    private String password;
    private List<Company> allCompanies;

    public CompanyManager getCompanyManager() {
        return companyManager;
    }

    public void setCompanyManager(CompanyManager companyManager) {
        this.companyManager = companyManager;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Company> getAllCompanies() {
        return allCompanies;
    }

    public void setAllCompanies(List<Company> allCompanies) {
        this.allCompanies = allCompanies;
    }

    @Override
    public String execute() throws Exception {
        if (username.equals("admin") && password.equals("admin")) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("username", username);



            allCompanies = companyManager.getAllCompanies();
            System.out.println(allCompanies.size());





            return SUCCESS;
        }

        return "fail";
    }
}
