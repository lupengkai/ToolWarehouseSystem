package com.fastrepair.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by tage on 4/3/16.
 */
@Entity
public class ExpensiveTool extends Tool {
    private Staff requestStaff;

    @ManyToOne
    public Staff getRequestStaff() {
        return requestStaff;
    }

    public void setRequestStaff(Staff requestStaff) {
        this.requestStaff = requestStaff;
    }
}
