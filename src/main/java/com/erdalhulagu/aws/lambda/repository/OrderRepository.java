package com.erdalhulagu.aws.lambda.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.erdalhulagu.aws.lambda.domain.Order;

@Repository
public class OrderRepository {
	
	public List<Order> buildOrders() {
	return	Stream.of(
				new Order(101,"Mobile",500,2),
				new Order(102,"Book",100,3),
				new Order(103,"Book",150,5),
				new Order(104,"Watch",1000,1),
				new Order(104,"Short",50,2)
				).collect(Collectors.toList());
		
	}

}
