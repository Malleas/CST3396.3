package com.gcu.topic22.business;

import com.gcu.topic22.model.OrderModel;
import java.util.List;
import com.gcu.topic22.model.OrdersList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/service")
public class OrdersRestService {

    @Autowired
    public OrdersBusinessServiceInterface service;

    @GetMapping(path = "/getJson", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<OrderModel> getOrdersAsJson(){
        return service.getOrders();
    }

    @GetMapping(path = "/getXml", produces = {MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody OrdersList getOrdersAsXml(){
        OrdersList ordersList = new OrdersList();
        ordersList.setOrders(service.getOrders());
        return ordersList;
    }
    @GetMapping(path = "/getOrder/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") String id){
        try {
            OrderModel order = service.getOrderById(id);
            if(order == null){
                System.out.println("From not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                System.out.println("from success");
                return new ResponseEntity<>(order, HttpStatus.OK);
            }
        }catch (Exception e){
            System.out.println("From exception");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
