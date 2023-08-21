package kempaiah.microservices.springbootrestapi.controller;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import kempaiah.microservices.springbootrestapi.dto.ErrorDetails;
import kempaiah.microservices.springbootrestapi.dto.UserDTO;
import kempaiah.microservices.springbootrestapi.entity.User;
import kempaiah.microservices.springbootrestapi.exception.ResourceNotFoundException;
import kempaiah.microservices.springbootrestapi.service.UserService;

@Tag(
    name = "CRUD API for User resource.",
    description = "User APIs"
)
@RestController
@RequestMapping("api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @Operation(
      summary = "Create User Rest API",
      description = "Create user API is used to persist new User"
  )
  @ApiResponse(
      responseCode = "201",
      description = "Http Status 201 created."
  )
  @PostMapping
  public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO) {
    UserDTO savedUserDTO = userService.createUser(userDTO);
    return ResponseEntity.ok(savedUserDTO);
  }

  @PutMapping("{id}")
  public ResponseEntity<User> updateUser(@PathVariable("id") Long userId ,@RequestBody User user) {
    user.setId(userId);
    User updatedUser = userService.updateUser(user);
    return ResponseEntity.ok(updatedUser);
  }

  @GetMapping("{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
    User user = userService.getUserById(userId);
    return ResponseEntity.ok(user);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId) {
    userService.deleteUser(userId);
    return ResponseEntity.ok("User successfully deleted");
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }


}
