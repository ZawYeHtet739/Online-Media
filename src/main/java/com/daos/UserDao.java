package com.daos;

import com.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    List<User> getAllUser();

    User getUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);


}
