package com.musala.task.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.musala.task.dao.TomatoOrderDAO;
import com.musala.task.dao.TomatoOrderDAOImpl;
import com.musala.task.domain.TomatoOrder;

public class TomatoOrderDAOImplTest {
	
	@Test
    public void testGeneratedOrdersNotNull() {
		
		TomatoOrderDAO dao = new TomatoOrderDAOImpl();
		int size = 5;
		List<TomatoOrder> orders = dao.getTomatoOrders(size);
		
        if (orders == null) {
        	fail("Randomly generated orders are not generated correctly");
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
			int tomatoes = order.getTomatoes() ;
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
}
