package com.musala.task.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.task.dao.TomatoOrderDAO;
import com.musala.task.domain.TomatoOrder;

@Service
public class TomatoOrdersServiceImpl implements TomatoOrdersService {
	
	@Autowired
	private TomatoOrderDAO tomatoOrderProvider;
	
	@Override
	public List<TomatoOrder> retrieveTomatoOrders(long size) {
		
		List<TomatoOrder> orders = tomatoOrderProvider.getTomatoOrders(size);
		
		return orders;
	}

}
