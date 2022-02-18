package com.temporal.paymentController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	
	@GetMapping("/payment/{id}")
	public String getPaymentDetails(@PathVariable String id) {
		return "Payment is complete for OrderID: "+id;
	}
	
}
