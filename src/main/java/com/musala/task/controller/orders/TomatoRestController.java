package com.musala.task.controller.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musala.task.model.TomatoOrder;
import com.musala.task.responses.ErrorCode;
import com.musala.task.responses.TomatoOrderResponse;
import com.musala.task.services.orders.TomatoOrdersService;

@RestController
@RequestMapping(path="tomatoes")
public class TomatoRestController {

	@Autowired
    private TomatoOrdersService userService;
	
	@RequestMapping("data")
	public TomatoOrderResponse getOrdersData(@RequestParam(defaultValue="3", value="size", required=false) String size) {
		List<TomatoOrder> orders = null;
		
		TomatoOrderResponse response = new TomatoOrderResponse();
		try {
			long requestedSize = Long.valueOf(size);
			orders = userService.retrieveTomatoOrders(requestedSize);
			response.setCode(ErrorCode.OK);
			response.setMessage("OK");
			response.setOrders(orders);
		} catch (Exception e) {
			response.setCode(ErrorCode.ERROR);
			response.setMessage("An error has occurred, please try again later.");
			e.printStackTrace();
		}
		System.out.println("size " + size);
		
		return response;
	}
}
