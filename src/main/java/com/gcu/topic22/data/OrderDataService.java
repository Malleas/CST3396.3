package com.gcu.topic22.data;

import com.gcu.topic22.data.entity.OrderEntity;
import com.gcu.topic22.data.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class OrderDataService implements DataAccessInterface<OrderEntity>{


    @Autowired
    private OrdersRepository ordersRepository;

    public OrderDataService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List findAll() {
        List<OrderEntity> orders = new ArrayList<>();
        try {
            Iterable<OrderEntity> orderEntities = ordersRepository.findAll();
            orderEntities.forEach(orders::add);
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public OrderEntity findById(String id) {
        return ordersRepository.getOrderById(id);
    }

    @Override
    public boolean create(OrderEntity order){
        String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?,?,?,?)";
        try {
            this.ordersRepository.save(order);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(OrderEntity order) {
        return true;
    }

    @Override
    public boolean delete(OrderEntity order) {
        return true;
    }
}
