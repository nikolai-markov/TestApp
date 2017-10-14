package com.musala.task.services;

import java.util.List;

import com.musala.task.domain.TomatoOrder;

public interface TomatoOrdersService {
	public List<TomatoOrder> retrieveTomatoOrders(long size);
}
