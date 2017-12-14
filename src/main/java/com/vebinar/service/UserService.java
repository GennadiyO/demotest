
package com.vebinar.service;

import com.vebinar.entity.User;

import java.util.List;


public interface UserService {

     void save (User user);

     User getById(int id);

     void update (User user);

     List<User> findAll();

     void delete (int id);
}
