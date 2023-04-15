package com.example.crudapi.dao;

import com.example.crudapi.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    private List<UserDTO> users = new ArrayList<>();

    public UserDTO createUser(UserDTO userDTO) {
        users.add(userDTO);
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        return users;
    }

    public UserDTO getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        for (UserDTO user : users) {
            if (user.getId().equals(id)) {
                user.setName(userDTO.getName());
                user.setEmail(userDTO.getEmail());
                user.setRole(userDTO.getRole());
                return user;
            }
        }
        return null;
    }

    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
