package com.musala.task.services.orders;

import java.util.List;

import com.musala.task.model.TomatoOrder;

public interface TomatoOrdersService {
	/**
	 * Retrieve orders from db.
	 * @param size - the number of orders to retrieve.
	 * @return
	 */
	public List<TomatoOrder> retrieveTomatoOrders(int size);
}
