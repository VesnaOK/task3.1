package ru.vesnina.spring_boot.SpringBoot.dao;



import ru.vesnina.spring_boot.SpringBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User showUserById(Long id);
    void saveUser(User user);
    void deleteUserById(Long id);
    void updateUserById(Long id, User user);
}
