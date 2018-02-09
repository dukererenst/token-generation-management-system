package com.example.assignment.config;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.example.assignment.TokenGenerator;
import com.example.assignment.model.Customer;
import com.example.assignment.model.Token;

@Component
public class DepositCounterOperator extends AbstractCounterOperatorImpl {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TokenGenerator.class);

	@Override
	protected void performSpecificTask(Token activeToken) {
		Customer customer = activeToken.getRequest().getCustomer();
		LOGGER.info("10000 deposited by customer :{}", customer);
	}


}