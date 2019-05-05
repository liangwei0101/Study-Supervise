package me.spring.service;

import me.spring.entity.Dog;

public interface DogService extends java.io.Serializable{
	public Dog getDog(Integer dogId);
	public Dog getDog(Dog dog);
}
