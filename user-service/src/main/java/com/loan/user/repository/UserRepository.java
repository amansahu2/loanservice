package com.loan.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
