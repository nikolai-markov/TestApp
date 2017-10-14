package com.musala.task.responses;

import java.util.List;

import com.musala.task.domain.TomatoOrder;

public class TomatoOrderResponse {
	
	private List<TomatoOrder> orders;
	private String message;
	private int code;

	public List<TomatoOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<TomatoOrder> orders) {
		this.orders = orders;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
