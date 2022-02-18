package com.temporal.basicController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.temporal.basicService.BasicServiceInterface;
import com.temporal.model.Order;

@RestController
public class BasicController {
	
	
	@Autowired
	BasicServiceInterface basicServiceInterface;
	
	@GetMapping("/api/v1/order/{id}")
	public Order getEndPoint(@PathVariable String id) {
		return basicServiceInterface.getOrderDetails(id);
		
	}

}
