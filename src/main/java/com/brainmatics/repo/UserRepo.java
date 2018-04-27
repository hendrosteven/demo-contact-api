package com.brainmatics.repo;

import com.brainmatics.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<User, Long>{
	
	public User findByEmailAndPassword(String email, String password);
	public User findByEmail(String email);
}
