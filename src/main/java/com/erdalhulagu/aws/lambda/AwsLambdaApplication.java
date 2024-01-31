package com.erdalhulagu.aws.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.erdalhulagu.aws.lambda.domain.Order;
import com.erdalhulagu.aws.lambda.repository.OrderRepository;

@SpringBootApplication
public class AwsLambdaApplication {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Bean
	public Supplier<List<Order>> orders() {
		return ()->orderRepository.buildOrders();
		
	}
	@Bean
	public Function<String, List<Order>> findOrderByName(){
		return (input)->orderRepository
				.buildOrders()
				.stream()
				.filter(order->order.getName().equals(input))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(AwsLambdaApplication.class, args);
	}

}
