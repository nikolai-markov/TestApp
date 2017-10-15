package com.musala.task.dao.orders;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Repository;

import com.musala.task.model.TomatoOrder;

@Repository
public class TomatoOrderDAOImpl implements TomatoOrderDAO {

	public static final int MAX_ORDER_SIZE = 2000;
	public String[] TOMATO_PROVIDERS = {"Heinz", "Hunt's", "Del Monte", "Le Ol' Granma"};
	
	@Override
	public List<TomatoOrder> getTomatoOrders(int size) {
		
		List<TomatoOrder> orders = new ArrayList<TomatoOrder>(size);
		
		for (int i = 0; i < size; i++) {
			TomatoOrder order = generateOrder();
			orders.add(order);
		} 
		
		return orders;
	}
	
	
	/**
	 * Generate one random order that has: <p>
	 * tomatoes: Integer from 1 to 2000 <p>
	 * provider: randomly generated string from "Heinz", "Hunt's", "Del Monte", "Le Ol' Granma" <p>
	 * timestamp: randomly generated string from the begging of this year to today. <p>
	 * @return
	 */
	private TomatoOrder generateOrder() {
		TomatoOrder tomatoOrder = new TomatoOrder();
		
		Random random = new Random();
		int orderSize = random.nextInt(MAX_ORDER_SIZE) + 1;
		
		int providerIndex = random.nextInt(TOMATO_PROVIDERS.length);
		String provider = TOMATO_PROVIDERS[providerIndex];
		
		UUID uuid = UUID.randomUUID();
		Long timestamp = getRandomTimestamp();
		
		tomatoOrder.setTimestamp(timestamp);
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
	
	    calendar.set(Calendar.DAY_OF_YEAR, 1);
	    Long beforeMillis = calendar.getTimeInMillis();
		
		long timestamp = ThreadLocalRandom.current().nextLong(beforeMillis, afterMillis);
		
		return timestamp;
	}
 
}
