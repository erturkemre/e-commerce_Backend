package com.work.e_commerce.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private Integer status;
    private String message;
    private LocalDateTime dateTime;

}
