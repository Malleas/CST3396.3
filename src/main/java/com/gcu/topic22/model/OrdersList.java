package com.gcu.topic22.model;

import com.gcu.topic22.business.OrdersRestService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "orders")
public class OrdersList implements Serializable {
    private List<OrderModel> orders = new ArrayList<OrderModel>();

    @XmlElement(name = "order")
    public List<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrdersList{" +
                "orders=" + orders +
                '}';
    }
}
