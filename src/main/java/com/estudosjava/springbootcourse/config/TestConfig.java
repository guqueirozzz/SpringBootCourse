package com.estudosjava.springbootcourse.config;

import com.estudosjava.springbootcourse.entities.Category;
import com.estudosjava.springbootcourse.entities.Product;
import com.estudosjava.springbootcourse.entities.User;
import com.estudosjava.springbootcourse.entities.Order;
import com.estudosjava.springbootcourse.entities.enums.OrderStatus;
import com.estudosjava.springbootcourse.repositories.CategoryRepository;
import com.estudosjava.springbootcourse.repositories.OrderRepository;
import com.estudosjava.springbootcourse.repositories.ProductRepository;
import com.estudosjava.springbootcourse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test") // tem que ser o mesmo do application.properties
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Order> orderList = new ArrayList<>();

        User u1 = new User(null, "Gustavo", "gustavo.queiroz@gmail.com", "988838773", "test", orderList);
        User u2 = new User(null, "Maria", "maria.queiroz@gmail.com", "988838773", "test1", orderList);
        User u3 = new User(null, "Joao", "joao.queiroz@gmail.com", "988838773", "test2", orderList);
        User u4 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", orderList);

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),  u1, OrderStatus.SHIPPED);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),  u2, OrderStatus.PAID);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);

        Category c1 = new Category(null, "Categoria1");
        Category c2 = new Category(null, "Categoria2");
        Category c3 = new Category(null, "Categoria3");

        Product p1 = new Product(null, "PLAYSTATION 5", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "RTX 4090 Ti", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        orderList.add(o1);
        orderList.add(o2);
        orderList.add(o3);
        userRepository.saveAll(Arrays.asList(u1, u2, u3,u4));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
    }
}
