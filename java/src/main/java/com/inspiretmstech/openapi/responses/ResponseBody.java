package com.inspiretmstech.openapi.responses;

class ResponseBody<T> {

    public final T data;

    public final Exception error;

    public ResponseBody(T body) {
        this.data = body;
        this.error = null;
    }

    public ResponseBody(Exception error) {
        this.data = null;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public Exception getError() {
        return error;
    }
}
