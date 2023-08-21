package kempaiah.microservices.springbootrestapi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

  private LocalDateTime localDateTime;
  private String message;
  private String path;
  private String errorCode;
}