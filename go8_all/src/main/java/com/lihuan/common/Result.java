package com.lihuan.common;

public class Result<T> {
	private int status;

	private String message;

	private T data;

	public Result(int status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public static <T> Result<T> ok() {
		return Result.ok(null);
	}

	public static <T> Result<T> ok(T data) {
		return new Result<T>(200, "ok", data);
	}

	public static <T> Result<T> error() {
		return new Result<T>(500, "error", null);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
