package com.example.belajar.data;

public class Result<T> {
    private Result() {
    }

    public static final class Success<T> extends Result {
        private T data;

        public Success(T data2) {
            super();
            this.data = data2;
        }

        public T getData() {
            return this.data;
        }
    }

    public static final class Error extends Result {
        private Exception error;

        public Error(Exception error2) {
            super();
            this.error = error2;
        }

        public Exception getError() {
            return this.error;
        }
    }

    public String toString() {
        if (this instanceof Success) {
            return "Success[data=" + ((Success) this).getData().toString() + "]";
        }
        if (this instanceof Error) {
            return "Error[exception=" + ((Error) this).getError().toString() + "]";
        }
        return "";
    }
}
