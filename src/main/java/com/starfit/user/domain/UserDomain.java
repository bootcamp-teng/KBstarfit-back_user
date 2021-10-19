package com.starfit.user.domain;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.starfit.user.data.CharacterRepository;
import com.starfit.user.data.UserRepository;
import com.starfit.user.model.User;

@Service
public class UserDomain {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserRepository sampleUserRepo;
	
	public ResponseEntity<String> insertUser(User user) throws Exception {
		log.info("Start db insert");
		User re  = sampleUserRepo.save(user);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}

	public ResponseEntity<String> updateUser(User user) throws Exception {
		log.info("Start db update==>"+user.getId());
		Optional<User> entity = sampleUserRepo.findById(user.getId());
		
		if(entity.isPresent()) {
			entity.get().setName(user.getName());
			entity.get().setPassword(user.getPassword());
			entity.get().setPhone(user.getPhone());
			entity.get().setStarId(user.getStarId());
			entity.get().setUserId(user.getUserId());
			entity.get().setCharacterId(user.getCharacterId());
			User re  = sampleUserRepo.save(user);
		}

		
		log.debug("result :"+ entity);
		
		return new ResponseEntity<String> (entity+"", HttpStatus.OK);
	}

	public ResponseEntity<List<User>> getUserList(String userId) {
		List<User> re = null;
		try {
			log.info("Start db select");
			re = sampleUserRepo.findByuserId(userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<User>> (re, HttpStatus.OK);
	}

	public ResponseEntity<Optional<User>> getUser(Long Id) throws Exception {
		Optional<User> re = null;
		try {
			log.info("Start db select");
			re = sampleUserRepo.findById(Id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Optional<User>> (re, HttpStatus.OK);
	}
}
