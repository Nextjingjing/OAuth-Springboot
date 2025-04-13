package com.nexty.backend.dto;

import lombok.Data;

@Data
public class ResponseAPI<T> {
    private String message;
    private T data;
}
