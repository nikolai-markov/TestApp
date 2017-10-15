package com.musala.task.services.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.task.dao.orders.TomatoOrderDAO;
import com.musala.task.model.TomatoOrder;

@Service
public class TomatoOrdersServiceImpl implements TomatoOrdersService {
	
	@Autowired
	private TomatoOrderDAO tomatoOrderProvider;
	
	@Override
	public List<TomatoOrder> retrieveTomatoOrders(int size) {
		
		List<TomatoOrder> orders = tomatoOrderProvider.getTomatoOrders(size);
		
		return orders;
	}

}
