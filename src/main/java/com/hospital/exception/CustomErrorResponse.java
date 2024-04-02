package com.hospital.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomErrorResponse {

    private LocalDateTime dateTime;

    private String message;

    private String details;
}
