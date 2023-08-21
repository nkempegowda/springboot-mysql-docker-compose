package kempaiah.microservices.springbootrestapi.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kempaiah.microservices.springbootrestapi.dto.UserDTO;
import kempaiah.microservices.springbootrestapi.entity.User;
import kempaiah.microservices.springbootrestapi.exception.EmailAlreadyExistsException;
import kempaiah.microservices.springbootrestapi.exception.ResourceNotFoundException;
import kempaiah.microservices.springbootrestapi.mapper.UserMapper;
import kempaiah.microservices.springbootrestapi.repository.UserRepository;
import kempaiah.microservices.springbootrestapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public UserDTO createUser(UserDTO userDTO) {
    User userToBeCreated = modelMapper.map(userDTO, User.class);
    userRepository.findByEmail(userToBeCreated.getEmail()).ifPresent(user->{
      throw new EmailAlreadyExistsException(String.format("Email %s Already exists",user.getEmail()));
        });
    User createdUser = userRepository.save(userToBeCreated);
    return modelMapper.map(createdUser, UserDTO.class);
  }

  @Override
  public User updateUser(User user) {

    User existingUser = getUserById(user.getId());
    existingUser.setFirstName(user.getFirstName());
    existingUser.setLastName(user.getLastName());
    existingUser.setEmail(user.getEmail());

    return userRepository.save(existingUser);
  }

  @Override
  public User getUserById(Long id) {
    User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    return user;
  }

  @Override
  public void deleteUser(Long userId) {
    getUserById(userId);
    userRepository.deleteById(userId);
  }

  @Override
  public List<User> getAllUsers() {

    return userRepository.findAll();
  }
}
