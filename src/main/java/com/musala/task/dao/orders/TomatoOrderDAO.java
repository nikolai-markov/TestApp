package com.musala.task.dao.orders;

import java.util.List;

import com.musala.task.model.TomatoOrder;

public interface TomatoOrderDAO {
	
	/**
	 * Get orders from db.
	 * @param size - number of orders to take from db.
	 * @return
	 */
	public List<TomatoOrder> getTomatoOrders(int size);
}
