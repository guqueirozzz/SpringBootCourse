package com.estudosjava.springbootcourse.repositories;

import com.estudosjava.springbootcourse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // opcional porque o JPARepository ja faz isso
public interface UserRepository extends JpaRepository<User, Long> {

}
