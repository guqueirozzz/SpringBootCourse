package com.estudosjava.springbootcourse.repositories;

import com.estudosjava.springbootcourse.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
