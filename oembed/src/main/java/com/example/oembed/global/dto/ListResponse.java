package com.example.oembed.global.dto;

import com.example.oembed.global.error.BasicError;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ListResponse<T> {
    List<T> data;
    BasicError error;

    public static <T> ListResponse<T> of(List<T> data) {
        return new ListResponse<>(data, null);
    }
}
