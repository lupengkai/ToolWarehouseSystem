package com.fastrepair.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tage on 4/3/16.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Staff {
    private int id;
    private String name;
    private String password;
    private List<Tool> tools = new ArrayList<>();
    private Company company;

@ManyToOne
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @OneToMany(mappedBy = "staff")
    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
