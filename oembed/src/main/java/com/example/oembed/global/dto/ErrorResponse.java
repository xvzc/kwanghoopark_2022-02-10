package com.example.oembed.global.dto;

import com.example.oembed.global.error.BasicError;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    Object data;
    BasicError error;

    public static ErrorResponse of(BasicError error) {
        return new ErrorResponse(null, error);
    }
}