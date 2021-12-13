package com.gcu.topic22.business;

import com.gcu.topic22.data.OrderDataService;
import com.gcu.topic22.data.entity.OrderEntity;
import com.gcu.topic22.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrdersBusinessService implements OrdersBusinessServiceInterface{

    @Autowired
    private OrderDataService service;

    @Override
    public void test() {
        System.out.println("Hello from OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        System.out.println("Generating a list from getOrders()");
        //return service.findAll();
      //  4.2 code
        List<OrderEntity> ordersEntity = service.findAll();
        List<OrderModel> ordersDomain = new ArrayList<>();
        for(OrderEntity entity:ordersEntity){
            ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(),
                    entity.getPrice(), entity.getQuantity()));
        }
        return ordersDomain;
    }

    @Override
    public OrderModel getOrderById(String id) {
        System.out.println("Getting order " + id);
        OrderEntity orderEntity = service.findById(id);
        if (orderEntity == null) {
            return null;
        } else {
            return new OrderModel(orderEntity.getId(), orderEntity.getOrderNo(), orderEntity.getProductName(), orderEntity.getPrice(), orderEntity.getQuantity());
        }
    }

    @Override
    public void init() {
        System.out.println("Hello from OBS init()");
    }

    @Override
    public void destroy() {
        System.out.println("Hello from OBS destroy()");
    }
}
