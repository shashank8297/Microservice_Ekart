package com.infinite.logs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinite.logs.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
