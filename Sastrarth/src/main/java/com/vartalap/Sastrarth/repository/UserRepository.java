package com.vartalap.Sastrarth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vartalap.Sastrarth.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
