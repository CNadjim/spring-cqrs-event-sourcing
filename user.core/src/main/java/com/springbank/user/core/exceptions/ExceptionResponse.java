package com.springbank.user.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

  private Integer code;
  private String status;
  private String message;
  private String date;
  private Object errors;

  public ExceptionResponse(HttpStatus httpStatus, String message, Object errors) {
    this.code = httpStatus.value();
    this.status = httpStatus.getReasonPhrase();
    this.message = message;
    this.date = LocalDateTime.now().toString();
    this.errors = errors;
  }
  public ExceptionResponse(HttpStatus httpStatus, String message) {
    this.code = httpStatus.value();
    this.status = httpStatus.getReasonPhrase();
    this.message = message;
    this.date = LocalDateTime.now().toString();
  }

  public ExceptionResponse(HttpStatus httpStatus) {
    this.code = httpStatus.value();
    this.status = httpStatus.getReasonPhrase();
    this.date = LocalDateTime.now().toString();
  }
}
