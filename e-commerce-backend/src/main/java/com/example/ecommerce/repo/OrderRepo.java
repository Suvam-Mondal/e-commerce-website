package com.example.ecommerce.repo;

import com.example.ecommerce.model.OrderItemList;
import com.example.ecommerce.model.OrderPayment;
import com.example.ecommerce.model.OrderResponse;
import com.example.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepo {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepo(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<OrderResponse> getAll(String userId) {
        String sql = "WITH TEMP AS (SELECT * FROM OrderItemList \n" +
                "JOIN Product ON Product.document_id = OrderItemList.productId\n" +
                "WHERE orderId = 'ORD12346')\n" +
                "SELECT OrderPayment.orderId, OrderPayment.paymentInfoId, paymentType, paymentStatus, paymentCardNumber, registeredEmail, orderItemListId, OrderPayment.orderId, productId, quantity, name, brand, category, price, img, rating FROM OrderPayment \n" +
                "JOIN PaymentInfo ON OrderPayment.paymentInfoId = PaymentInfo.paymentInfoId\n" +
                "JOIN TEMP ON TEMP.orderId = OrderPayment.orderId\n" +
                "WHERE registeredEmail = :userId";

        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(OrderResponse.class));
    }



public void saveOrder(OrderPayment orderPayment) {
    // Insert into PaymentInfo table
    String paymentInfoSql = "INSERT INTO PaymentInfo (paymentType, paymentStatus, paymentCardNumber, registeredEmail) VALUES (:paymentType, :paymentStatus, :paymentCardNumber, :registeredEmail)";
    Map<String, Object> paymentInfoParams = new HashMap<>();
    paymentInfoParams.put("paymentType", orderPayment.getPaymentInfo().getPaymentType());
    paymentInfoParams.put("paymentStatus", orderPayment.getPaymentInfo().getPaymentStatus());
    paymentInfoParams.put("paymentCardNumber", orderPayment.getPaymentInfo().getPaymentCardNumber());
    paymentInfoParams.put("registeredEmail", orderPayment.getPaymentInfo().getRegisteredEmail());

    KeyHolder paymentInfoKeyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(paymentInfoSql, new MapSqlParameterSource(paymentInfoParams), paymentInfoKeyHolder, new String[]{"paymentInfoId"});
    int paymentInfoId = paymentInfoKeyHolder.getKey().intValue();

    // Insert into OrderPayment table
    String orderPaymentSql = "INSERT INTO OrderPayment (orderId, paymentInfoId) VALUES (:orderId, :paymentInfoId)";
    Map<String, Object> orderPaymentParams = new HashMap<>();
    orderPaymentParams.put("orderId", orderPayment.getOrderId());
    orderPaymentParams.put("paymentInfoId", paymentInfoId);

    jdbcTemplate.update(orderPaymentSql, new MapSqlParameterSource(orderPaymentParams));

    // Insert into OrderItemList table
    String orderItemListSql = "INSERT INTO OrderItemList (orderItemListId, orderId, productId, quantity) VALUES (:orderItemListId, :orderId, :productId, :quantity)";
    for (OrderItemList item : orderPayment.getOrderList()) {
        Map<String, Object> orderItemListParams = new HashMap<>();
        orderItemListParams.put("orderItemListId", item.getOrderItemListId());
        orderItemListParams.put("orderId", orderPayment.getOrderId());
        orderItemListParams.put("productId", item.getProduct().getDocument_id());
        orderItemListParams.put("quantity", item.getQuantity());
        jdbcTemplate.update(orderItemListSql, new MapSqlParameterSource(orderItemListParams));
    }
}
}
