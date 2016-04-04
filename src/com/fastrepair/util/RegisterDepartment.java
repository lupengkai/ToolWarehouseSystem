package com.fastrepair.util;

import com.fastrepair.model.Company;
import com.fastrepair.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by tage on 4/4/16.
 */
@Component
public class RegisterDepartment {
    HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        HibernateTemplate hibernateTemplate = (HibernateTemplate)applicationContext.getBean("hibernateTemplate");
        for (int i = 1; i < 10; i++) {
            Company company = hibernateTemplate.get(Company.class, i);
            Department department1 = new Department();
            department1.setCompany(company);
            department1.setDepartmentType(DepartmentType.CONSTRUCTDEVICE);
            Department department2 = new Department();
            department2.setCompany(company);
            department2.setDepartmentType(DepartmentType.AUTOMOBILE);
            Department department3 = new Department();
            department3.setCompany(company);
            department3.setDepartmentType(DepartmentType.APPLIANCE);
            Department department4 = new Department();
            department4.setCompany(company);
            department4.setDepartmentType(DepartmentType.COMPUTER);
            hibernateTemplate.save(department1);
            hibernateTemplate.save(department2);
            hibernateTemplate.save(department3);
            hibernateTemplate.save(department4);
        }
    }


}
