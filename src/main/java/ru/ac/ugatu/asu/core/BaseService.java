/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ac.ugatu.asu.core;

import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author aleksandr
 */
public class BaseService {
    private HibernateTemplate template;
    
    @Inject
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.template = new HibernateTemplate(sessionFactory);
    }
    
    protected HibernateTemplate getTemplate() {
        return this.template;
    }
    
    public PagableResultSet getPagableResults(String className, int pageNumber) {
        PagableResultSet result = new PagableResultSet(className, pageNumber, this.getTemplate());
        return result;
    }
}
