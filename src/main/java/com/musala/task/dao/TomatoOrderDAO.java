package com.musala.task.dao;

import java.util.List;

import com.musala.task.domain.TomatoOrder;

public interface TomatoOrderDAO {
	public List<TomatoOrder> getTomatoOrders(long size);
}
