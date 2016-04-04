package com.fastrepair.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tage on 4/4/16.
 */
public class AdminLoginAction extends ActionSupport{
    private String username;
    private String password;

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


    @Override
    public String execute() throws Exception {
        if (username.equals("admin") && password.equals("admin")) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("username", username);
            return SUCCESS;
        }

        return "fail";
    }
}
