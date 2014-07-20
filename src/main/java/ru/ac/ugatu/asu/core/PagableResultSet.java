/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ac.ugatu.asu.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author aleksandr
 */
public class PagableResultSet {
    private static final int DEFAULT_PAGE_SIZE = 20;
    private ArrayList items;
    private ArrayList pages;
    private int pageNumber;
    private int pagesCount;
    private int pageSize;
    private HibernateTemplate template;
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public HibernateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    
    public PagableResultSet(String className, int pageNum, HibernateTemplate template) {
        this(className, pageNum, PagableResultSet.DEFAULT_PAGE_SIZE, template);
    }
    public PagableResultSet(final String className, int pageNum, final int pageSize, HibernateTemplate template) {
        this.setPageNumber(pageNum);
        this.setPageSize(pageSize);
        this.setTemplate(template);
        this.setClassName(className);
    }

    public ArrayList getItems() {
        if (this.items == null) {
            List items = (List) template.execute(new HibernateCallback(){

                @Override
                public Object doInHibernate(Session session) throws HibernateException, SQLException {
                    int start = (getPageNumber() - 1) * getPageSize();
//                    Query query = session.createQuery("from " + className);
//                    query.setMaxResults(getPageSize());
//                    query.setFirstResult(start);
                    
                    Criteria criteria = session.createCriteria(getClassName());
                    criteria.setFirstResult(start);
                    criteria.setMaxResults(getPageSize());
                    criteria.addOrder(Order.desc("id"));
                    return criteria.list();
                    
                    // return query.list();
                }

            });
            this.setItems((ArrayList) items);
        }
        return this.items;
    }

    public void setItems(ArrayList items) {
        this.items = items;
    }

    public ArrayList getPages() {
        return pages;
    }

    public void setPages(ArrayList pages) {
        this.pages = pages;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
}
