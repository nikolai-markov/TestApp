package com.musala.task.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Repository;

import com.musala.task.domain.TomatoOrder;

@Repository
public class TomatoOrderDAOImpl implements TomatoOrderDAO {

	public static final int MAX_ORDER_SIZE = 2000;
	public String[] TOMATO_PROVIDERS = {"Heinz", "Hunt's", "Del Monte", "Le Ol' Granma"};
	
	@Override
	public List<TomatoOrder> getTomatoOrders(long size) {
		
		List<TomatoOrder> orders = new ArrayList<TomatoOrder>();
		
		for (int i = 0; i < size; i++) {
			TomatoOrder order = generateOrder();
			orders.add(order);
		} 
		
		return orders;
	}
	
	
	private TomatoOrder generateOrder() {
		TomatoOrder tomatoOrder = new TomatoOrder();
		
		Random random = new Random();
		int orderSize = random.nextInt(MAX_ORDER_SIZE) + 1;
		
		int providerIndex = random.nextInt(TOMATO_PROVIDERS.length);
		String provider = TOMATO_PROVIDERS[providerIndex];
		
		UUID uuid = UUID.randomUUID();
		Long timestamp = getRandomTimestamp();
		
		tomatoOrder.setDate(timestamp);
		tomatoOrder.setId(uuid.toString());
		tomatoOrder.setProvider(provider);
		tomatoOrder.setTomatoes(orderSize);
		
		return tomatoOrder;
	}
	
	/**
	 * Retrieves random timestamp from last six months.
	 * @return
	 */
	private Long getRandomTimestamp() {
		
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		
		Long afterMillis = calendar.getTimeInMillis();
		
	    calendar.set(Calendar.MONTH, Calendar.MAY);  
	    Long beforeMillis = calendar.getTimeInMillis();
		
		long timestamp = ThreadLocalRandom.current().nextLong(beforeMillis, afterMillis);
		
		return timestamp;
	}
 
}
