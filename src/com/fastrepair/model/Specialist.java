package com.fastrepair.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by tage on 4/3/16.
 */
@Entity
public class Specialist extends Staff {
    private Company company;

    @ManyToOne
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
