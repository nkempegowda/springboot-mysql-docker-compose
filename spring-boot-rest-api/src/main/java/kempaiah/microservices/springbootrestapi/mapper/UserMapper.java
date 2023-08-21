package kempaiah.microservices.springbootrestapi.mapper;

import kempaiah.microservices.springbootrestapi.dto.UserDTO;
import kempaiah.microservices.springbootrestapi.entity.User;

public class UserMapper {

  /*
    Convert User JPA Entity to User DTO
   */
  public static UserDTO mapToUserDTO(User user)
  {
    UserDTO userDTO = new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    return userDTO;
  }

  /*
  Convert User DTO to User JPA Entity.
 */
  public static User mapToUser(UserDTO userDTO)
  {
    User user = new User(userDTO.getId(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail());
    return user;
  }
}
