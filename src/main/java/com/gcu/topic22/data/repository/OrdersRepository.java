package com.gcu.topic22.data.repository;

import com.gcu.topic22.data.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends MongoRepository<OrderEntity, String> {
OrderEntity getOrderById(String id);
}
