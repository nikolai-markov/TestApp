package com.musala.task.controller.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.musala.task.model.TomatoOrder;
import com.musala.task.services.orders.TomatoOrdersService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(path="/data")
public class TomatoViewController {
	
	@Autowired
    private TomatoOrdersService userService;
	
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getOrdersData(@RequestParam(defaultValue="3", value="size", required=false) String size) {
		System.out.println("size " + size);
		
		List<TomatoOrder> orders = null;
		
		ModelAndView model = new ModelAndView();
		try {
			int requestedSize = Integer.valueOf(size);
			orders = userService.retrieveTomatoOrders(requestedSize);
			
			model.addObject("orders", orders);
		} catch(NumberFormatException e) {
			model.addObject("ERROR", "Incorrect size set for size of orders!s");
			e.printStackTrace();
		} catch (Exception e) {
			model.addObject("ERROR", "Something went wrong. Please try again later!");
			e.printStackTrace();
		}
		
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		model.setView(view);
		
		return model;
	}
}
