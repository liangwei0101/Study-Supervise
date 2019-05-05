package me.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import me.spring.entity.User;

public interface UserDao extends JpaSpecificationExecutor<User>,JpaRepository<User, Long>{
	User findByUsernameAndPassword(String username,String password);
	User findByUsername(String username);
}
