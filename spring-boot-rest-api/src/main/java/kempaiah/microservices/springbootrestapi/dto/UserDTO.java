package kempaiah.microservices.springbootrestapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
    description = "UserDTO Model Information."
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

  private Long id;

  @Schema(
      description = "User First Name"
  )
  @NotEmpty(message = "User first name should not be null or empty")
  private String firstName;

  @NotEmpty(message = "User last name should not be null or empty")
  private String lastName;

  @NotEmpty(message = "User email should not be null or empty")
  @Email(message = "User email should be Valid")
  private String email;
}
