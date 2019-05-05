package me.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import me.spring.entity.Dog;


public interface DogDao  extends JpaRepository<Dog, Long>{
	 Dog findByDogId(Integer  dogId);

}
