package com.gcu.topic22.data.mapper;

import com.gcu.topic22.data.entity.OrderEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<OrderEntity> {
    @Override
    public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new OrderEntity(rs.getLong("ID"), rs.getString("ORDER_NO"), rs.getString("PRODUCT_NAME"),
                rs.getFloat("PRICE"), rs.getInt("QUANTITY"));
    }
}
