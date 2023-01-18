package com.estudosjava.springbootcourse.config;

import com.estudosjava.springbootcourse.entities.User;
import com.estudosjava.springbootcourse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test") // tem que ser o mesmo do application.properties
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Gustavo", "gustavo.queiroz@gmail.com", "988838773", "test");
        User u2 = new User(null, "Maria", "maria.queiroz@gmail.com", "988838773", "test1");
        User u3 = new User(null, "Joao", "joao.queiroz@gmail.com", "988838773", "test2");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
