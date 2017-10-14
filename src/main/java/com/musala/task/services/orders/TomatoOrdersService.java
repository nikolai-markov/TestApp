package com.musala.task.services.orders;

import java.util.List;

import com.musala.task.model.TomatoOrder;

public interface TomatoOrdersService {
	public List<TomatoOrder> retrieveTomatoOrders(long size);
}
