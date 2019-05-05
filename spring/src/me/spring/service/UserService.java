package me.spring.service;

import me.spring.entity.User;

public interface UserService extends java.io.Serializable{
	boolean validateUser(User user);
	User getUser(User user);

}
