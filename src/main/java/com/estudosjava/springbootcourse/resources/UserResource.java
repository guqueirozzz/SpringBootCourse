package com.estudosjava.springbootcourse.resources;

import com.estudosjava.springbootcourse.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1, "Gustavo", "guaraujoo@hotmail.com", "11961022720", "teste");
        return ResponseEntity.ok().body(u);
    }

}
