package com.example.mybatisplusdemo.common;

import lombok.Data;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Result<R> implements Serializable {
    @Serial
    private static final long serialVersionUID = 7574078101944305355L;
    private boolean status;
    private int code;
    private String message;
    private R data;
    private Map<String, Object> otherData = new HashMap<>();

    public Result() {
    }

    public static <R> Result<R> success(R data) {
        Result<R> response = new Result<>();
        response.status = true;
        response.data = data;
        return response;
    }

    public static <R> Result<R> success(R data, String message) {
        Result<R> response = new Result<>();
        response.status = true;
        response.data = data;
        response.message = message;
        return response;
    }

    public static <R> Result<R> successMessage(String message) {
        return message(true, message);
    }

    public static <R> Result<R> message(boolean status, String message) {
        Result<R> response = new Result<>();
        response.status = status;
        response.message = message;
        return response;
    }

    public static <R> Result<R> failure(String message) {
        return message(false, message);
    }

    public Result<R> setOtherData(Map<String, Object> otherData) {
        this.otherData = otherData;
        return this;
    }

    public Result<R> addOtherData(String key, Object value) {
        this.otherData.put(key, value);
        return this;
    }

    public Result<R> removeOtherData(String key) {
        this.otherData.remove(key);
        return this;
    }

    public Result<R> setException(Exception e) {
        this.addOtherData("exception", e.getClass().getName());
        return this;
    }

    public Result<R> removeException() {
        this.removeOtherData("exception");
        return this;
    }

}

