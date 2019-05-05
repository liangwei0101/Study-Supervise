package me.spring.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.spring.dao.DogDao;
import me.spring.entity.Dog;
import me.spring.service.DogService;

@Service
@Transactional
public class DogImp implements DogService{
	private static final long serialVersionUID = -447333903669993015L;
	
	@Autowired
	private DogDao dogDao;

	@Override
	public Dog getDog(Integer dogId) {
		// TODO Auto-generated method stub
		return dogDao.findByDogId(dogId);
	}

	@Override
	public Dog getDog(Dog dog) {
		// TODO Auto-generated method stub
		return dogDao.findByDogId(dog.getDogId());
	}


}
