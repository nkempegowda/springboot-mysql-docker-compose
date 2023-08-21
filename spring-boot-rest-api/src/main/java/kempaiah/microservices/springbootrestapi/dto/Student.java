package kempaiah.microservices.springbootrestapi.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
public class Student {
  @NonNull
  private long id;
  @NonNull
  private String firstName;
  @NonNull
  private String lastName;



}
