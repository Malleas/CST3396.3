package com.gcu.topic22.data;

import com.gcu.topic22.data.entity.OrderEntity;
import com.gcu.topic22.data.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Service
public class OrderDataService implements DataAccessInterface<OrderEntity>{

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrdersRepository ordersRepository;

    public OrderDataService(OrdersRepository ordersRepository, DataSource dataSource) {
        this.ordersRepository = ordersRepository;
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
    public OrderEntity findById(int id) {
        return null;
    }

    @Override
    public boolean create(OrderEntity order) {
       String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?,?,?,?)";
       try {
           jdbcTemplate.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());
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
