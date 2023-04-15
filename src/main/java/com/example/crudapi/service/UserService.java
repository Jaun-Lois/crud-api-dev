package com.example.crudapi.service;

import com.example.crudapi.dao.UserDAO;
import com.example.crudapi.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserDTO createUser(UserDTO userDTO) {
        return userDAO.createUser(userDTO);
    }

    public List<UserDTO> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public UserDTO getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return userDAO.updateUser(id, userDTO);
    }

    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
