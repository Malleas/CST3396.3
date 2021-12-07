package com.gcu.topic22.business;

import com.gcu.topic22.model.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface{
    @Override
    public void test() {
        System.out.println("Hello from AnotherOrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
       return null;
    }

    @Override
    public OrderModel getOrderById(String id) {
        return null;
    }

    @Override
    public void init() {
        System.out.println("Hello from AOBS init()");
    }

    @Override
    public void destroy() {
        System.out.println("Hello from AOBS destroy()");
    }
}
