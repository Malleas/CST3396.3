package com.gcu.topic22.data.repository;

import com.gcu.topic22.data.entity.OrderEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<OrderEntity, Long> {
    @Override
    @Query(value = "SELECT * FROM ORDERS")
    public List<OrderEntity> findAll();
}
