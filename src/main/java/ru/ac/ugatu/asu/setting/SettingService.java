/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.ac.ugatu.asu.setting;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;
import ru.ac.ugatu.asu.core.BaseService;

/**
 *
 * @author aleksandr
 */
@Component
public class SettingService extends BaseService{
    public Setting getSetting(final String alias) {
        List results = (List) this.getTemplate().execute(new HibernateCallback(){

            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(Setting.class);
                criteria.add(Restrictions.eq("alias", alias));
                return criteria.list();
            }
        });
        if (!results.isEmpty()) {
            return (Setting) results.get(0);
        }
        return null;
    }
}
