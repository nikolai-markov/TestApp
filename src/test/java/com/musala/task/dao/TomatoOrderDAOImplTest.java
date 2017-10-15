package com.musala.task.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.musala.task.dao.orders.TomatoOrderDAO;
import com.musala.task.dao.orders.TomatoOrderDAOImpl;
import com.musala.task.model.TomatoOrder;

public class TomatoOrderDAOImplTest {
	
	@Test
    public void testGeneratedOrdersNotNull() {
		
		TomatoOrderDAO dao = new TomatoOrderDAOImpl();
		int size = 5;
		List<TomatoOrder> orders = dao.getTomatoOrders(size);
		
        if (orders == null) {
        	fail("Randomly generated orders are not generated correctly! No orders generated!");
        }
        
        assertTrue(true);
    }

	@Test
    public void testCorrectNumberOfOrdersGenerated() {
		
		TomatoOrderDAO dao = new TomatoOrderDAOImpl();
		int size = 5;
		List<TomatoOrder> orders = dao.getTomatoOrders(size);
		
        assertEquals("Assert correct number of randomly generated orders", size, orders.size());
    }
	
	@Test
	public void testCorrectTomatoSize() {
		TomatoOrderDAO dao = new TomatoOrderDAOImpl();
		int size = 5;
		List<TomatoOrder> orders = dao.getTomatoOrders(size);
		
		boolean fail = false;
		for (TomatoOrder order: orders) {
			int tomatoes = order.getTomatoes();
			if (tomatoes < 1 || tomatoes > 2000) {
				fail = true;
				break;
			}
		}
		
		if (fail) {
			fail("Tomato number is greater than 2000 or less than 1");
		}
        assertTrue(true);
	}
	
	@Test
	public void testCorrectGeneratedDate() {
		TomatoOrderDAO dao = new TomatoOrderDAOImpl();
		int size = 10;
		List<TomatoOrder> orders = dao.getTomatoOrders(size);
		
		Calendar calendar = Calendar.getInstance();
		long now = calendar.getTimeInMillis();
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		long beggingOfYear = calendar.getTimeInMillis();
		boolean fail = false;
		for (TomatoOrder order: orders) {
			long timestamp = order.getTimestamp();
			if (timestamp > now || timestamp < beggingOfYear) {
				fail = true;
				break;
			}
		}
		
		if (fail) {
			fail("Order date is not between now and begging the year.");
		}
        assertTrue(true);
	}
}
