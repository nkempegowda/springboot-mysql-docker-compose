package kempaiah.microservices.springbootrestapi.service;

import java.util.List;

import kempaiah.microservices.springbootrestapi.dto.UserDTO;
import kempaiah.microservices.springbootrestapi.entity.User;

public interface UserService {
  UserDTO createUser(UserDTO user);

  User updateUser(User user);

  User getUserById(Long id);

  void deleteUser(Long userId);


  List<User> getAllUsers();
}
