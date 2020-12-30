package de.ovsiannikov.springboot.demo.dao;


import de.ovsiannikov.springboot.demo.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);
}
