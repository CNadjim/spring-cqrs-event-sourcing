package com.nadjim.cqrs.core.exceptions;

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
public class BaseException {
  private Integer code;
  private String status;
  private String message;
  private String date;
  private Object details;

  public BaseException(HttpStatus httpStatus, String message, Object details) {
    this.code = httpStatus.value();
    this.status = httpStatus.getReasonPhrase();
    this.message = message;
    this.date = LocalDateTime.now().toString();
    this.details = details;
  }
  public BaseException(HttpStatus httpStatus, String message) {
    this.code = httpStatus.value();
    this.status = httpStatus.getReasonPhrase();
    this.message = message;
    this.date = LocalDateTime.now().toString();
  }

  public BaseException(HttpStatus httpStatus) {
    this.code = httpStatus.value();
    this.status = httpStatus.getReasonPhrase();
    this.date = LocalDateTime.now().toString();
  }
}
