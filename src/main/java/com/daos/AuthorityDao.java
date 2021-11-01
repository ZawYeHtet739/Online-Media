package com.daos;

import com.models.Authority;
import org.springframework.stereotype.Component;

@Component
public interface AuthorityDao {

    void addAuthority(Authority authority);
}
