package com.temporal.paymentProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="paymentProxy", url="http://localhost:9002")
public interface PaymentProxy {
	@GetMapping("/payment/{id}")
	public String getPaymentDetails(@PathVariable String id);
}
