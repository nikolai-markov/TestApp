package com.musala.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.musala.task.domain.TomatoOrder;
import com.musala.task.services.TomatoOrdersService;

@Controller
@RequestMapping(path="/data")
public class TomatoViewController {
	
	@Autowired
    private TomatoOrdersService userService;

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		model.setView(view);
		model.addObject("msg", name);

		return model;
	}
	
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.PUT})
	public ModelAndView getOrdersData(@RequestParam(defaultValue="3", value="size", required=false) String size) {
		System.out.println("size " + size);
		
		List<TomatoOrder> orders = null;
		
		ModelAndView model = new ModelAndView();
		try {
			long requestedSize = Long.valueOf(size);
			orders = userService.retrieveTomatoOrders(requestedSize);
			
			model.addObject(orders);
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