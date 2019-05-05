package me.spring.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.spring.dao.UserDao;
import me.spring.entity.User;
import me.spring.service.UserService;

@Service
@Transactional
public class UserImp implements UserService{
	private static final long serialVersionUID = -447333903669993015L;
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean validateUser(User user) {
		user = userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		if(user==null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(user.getUsername());
	}

}
