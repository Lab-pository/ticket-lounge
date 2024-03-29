package com.ticketlounge.web.common;

public class ApiResult<T> {

    private final T data;

    private final String error;

    ApiResult(T data, String error) {
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResult<T> succeed(T data) {
        return new ApiResult<>(data, null);
    }

    public static <T> ApiResult<T> failed(Throwable throwable) {
        return failed(throwable.getMessage());
    }

    public static <T> ApiResult<T> failed(String message) {
        return new ApiResult<>(null, message);
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }

}

