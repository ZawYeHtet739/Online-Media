package com.services;

import com.daos.AuthorityDao;
import com.models.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityDao authorityDao;

    public void addAuthority(Authority authority){
        authorityDao.addAuthority(authority);
    }

}
