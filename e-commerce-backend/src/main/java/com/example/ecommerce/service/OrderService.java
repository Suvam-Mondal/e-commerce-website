package com.example.ecommerce.service;

import com.example.ecommerce.model.OrderItemList;
import com.example.ecommerce.model.OrderPayment;
import com.example.ecommerce.model.PaymentInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class OrderService {

    public List<OrderPayment> getOrdersForUser(String userId, String authToken) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange("https://angular-demo-prj-default-rtdb.firebaseio.com/orders_table.json?auth=" + authToken, HttpMethod.GET, null, String.class);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, OrderPayment> ordersMap = new HashMap<>();
        ordersMap = mapper.readValue(response.getBody(), HashMap.class);

        List<OrderPayment> orderPaymentList = new ArrayList<>();

        for (Map.Entry<String, OrderPayment> entry : ordersMap.entrySet()) {

            Map<String, Object> orderData = (Map<String, Object>) entry.getValue();

            OrderPayment orderItemList = new OrderPayment();
            orderItemList.setOrderId((String) orderData.get("orderId"));
            orderItemList.setOrderList((List<OrderItemList>) orderData.get("orderList"));

            Map<String, Object> paymentInfoData = (Map<String, Object>) orderData.get("paymentInfo");

            PaymentInfo paymentInfo = new PaymentInfo();
            paymentInfo.setPaymentStatus((String) paymentInfoData.get("paymentStatus"));
            paymentInfo.setPaymentType((String) paymentInfoData.get("paymentType"));
            paymentInfo.setPaymentCardNumber((String) paymentInfoData.get("paymentCardNumber"));
            paymentInfo.setRegisteredEmail((String) paymentInfoData.get("registeredEmail"));

            if (paymentInfo.getRegisteredEmail().equalsIgnoreCase(userId)) {
                orderItemList.setPaymentInfo(paymentInfo);
                orderPaymentList.add(orderItemList);
            }

        }

        log.info(orderPaymentList.toString());
        return orderPaymentList;

    }

    public void saveOrder(OrderPayment orderPayment, String authToken) throws ExecutionException, InterruptedException {

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity entity = new HttpEntity(orderPayment, null);
        ResponseEntity<String> response = restTemplate.exchange("https://angular-demo-prj-default-rtdb.firebaseio.com/orders_table.json?auth="+authToken, HttpMethod.POST, entity, String.class);

        log.info("Saved... {}", response);
    }
}
