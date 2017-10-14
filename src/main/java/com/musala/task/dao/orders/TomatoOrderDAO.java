package com.musala.task.dao.orders;

import java.util.List;

import com.musala.task.model.TomatoOrder;

public interface TomatoOrderDAO {
	public List<TomatoOrder> getTomatoOrders(long size);
}
