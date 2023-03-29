package com.estudosjava.springbootcourse.config;

import com.estudosjava.springbootcourse.entities.*;
import com.estudosjava.springbootcourse.entities.enums.OrderStatus;
import com.estudosjava.springbootcourse.repositories.*;
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

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {


        List<Order> orderList = new ArrayList<>();


        User u1 = new User(null, "Gustavo", "gustavo.queiroz@gmail.com", "988838773", "test", orderList);
        User u2 = new User(null, "Maria", "maria.queiroz@gmail.com", "988838773", "test1", orderList);
        User u3 = new User(null, "Joao", "joao.queiroz@gmail.com", "988838773", "test2", orderList);
        User u4 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", orderList);

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),  u2, OrderStatus.SHIPPED);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),  u2, OrderStatus.PAID);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u3, OrderStatus.WAITING_PAYMENT);

        orderList.add(o1);
        orderList.add(o2);
        orderList.add(o3);

        Category c1 = new Category(null, "Categoria1");
        Category c2 = new Category(null, "Categoria2");
        Category c3 = new Category(null, "Categoria3");

        Product p1 = new Product(null, "PLAYSTATION 5", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "RTX 4090 Ti", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

         //Associando um produto a uma categoria
        p1.getCategories().add(c1);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);

        userRepository.saveAll(Arrays.asList(u1, u2, u3,u4));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        // printando as categorias do produto 2
        for(Category x : p2.getCategories()){
            System.out.printf(x.getName());
        }

        // instanciando or orderItems
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o1, p4, 1, p4.getPrice());
        OrderItem oi4 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi5 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

    }
}
