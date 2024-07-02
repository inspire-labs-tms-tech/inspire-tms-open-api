package com.inspiretmstech.openapi.responses;

public class Response<T> {

    private final int status;

    private final ResponseStatus type;

    private final ResponseBody<T> body;

    private Response(int status, T body, ResponseStatus type) {
        this.status = status;
        this.body = new ResponseBody<>(body);
        this.type = type;
    }

    private Response(int status, Exception error, ResponseStatus type) {
        this.status = status;
        this.body = new ResponseBody<>(error);
        this.type = type;
    }

    public static <T> Response<T> success(T data, int status) {
        return new Response<>(status, data, ResponseStatus.SUCCESS);
    }

    public static <T> Response<T> success(T data) {
        return Response.success(data, 200);
    }

    public static <T> Response<T> error(Exception error, int status) {
        return new Response<>(status, error, ResponseStatus.ERROR);
    }

    public static <T> Response<T> error(Exception error) {
        return Response.error(error, 500);
    }

    public int getStatus() {
        return status;
    }

    public ResponseBody<T> getBody() {
        return body;
    }

    public ResponseStatus getType() {
        return type;
    }
}
