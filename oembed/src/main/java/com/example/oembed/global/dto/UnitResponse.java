package com.example.oembed.global.dto;

import com.example.oembed.global.error.BasicError;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UnitResponse<T> {
    T data;
    BasicError error;

    public static <T> UnitResponse<T> of(T data) {
        return new UnitResponse<>(data, null);
    }
}