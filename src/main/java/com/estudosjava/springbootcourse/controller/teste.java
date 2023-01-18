package com.estudosjava.springbootcourse.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class teste {
    @GetMapping("/teste")
    public ResponseEntity<String> getText(){
        return ResponseEntity.ok("Retornando");

    }
}
