package com.impls;

import com.daos.AuthorityDao;
import com.models.Authority;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorityImpl implements AuthorityDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addAuthority(Authority authority) {
        session().save(authority);
        session().flush();
    }

}
