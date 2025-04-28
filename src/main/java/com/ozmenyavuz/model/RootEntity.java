package com.ozmenyavuz.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "RootEntity wrapper for standard API responses")
public class RootEntity<T> {

    private boolean result;
    private String errorMessage;
    private T data;

    // Basarili durum
    public static <T> RootEntity<T> ok(T data) {

        RootEntity<T> rootEntity = new RootEntity<>();

        rootEntity.setData(data);
        rootEntity.setResult(true);
        rootEntity.setErrorMessage(null);
        return rootEntity;
    }

    // Hata Durumu
    public static <T> RootEntity<T> error(String errorMessage) {
        RootEntity<T> rootEntity = new RootEntity<>();

        rootEntity.setData(null);
        rootEntity.setResult(false);
        rootEntity.setErrorMessage(errorMessage);
        return rootEntity;
    }


}
