package com.gcu.topic22.business;

import com.gcu.topic22.data.OrderDataService;
import com.gcu.topic22.data.entity.OrderEntity;
import com.gcu.topic22.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
        return service.findAll();
      //  4.2 code
      //  List<OrderEntity> ordersEntity = service.findAll();
      //  List<OrderModel> ordersDomain = new ArrayList<>();
      //  for(OrderEntity entity:ordersEntity){
      //      ordersDomain.add(new OrderModel(entity.getId(), entity.getOrder_no(), entity.getProduct_name(),
      //              entity.getPrice(), entity.getQuantity()));
      //  }
      //  return ordersDomain;
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
