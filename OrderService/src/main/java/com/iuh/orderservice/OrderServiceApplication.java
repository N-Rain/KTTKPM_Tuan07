package com.iuh.orderservice;

import com.iuh.orderservice.models.Order;
import com.iuh.orderservice.repositories.OrderRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderServiceApplication {
    @Autowired
    private OrderRepository orderRepository;
    private final Faker faker = new Faker();

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 1; i <= 5; i++) {
                Order order = createFakeOrder();
                orderRepository.save(order);
            }
        };
    }

    private Order createFakeOrder() {
        Order order = new Order();
        order.setOrderDate(faker.date().past(10, java.util.concurrent.TimeUnit.DAYS).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
        order.setStatus(faker.lorem().word());
        order.setShippingAddress(faker.address().fullAddress());
        return order;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
