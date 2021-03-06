package com.starfit.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.starfit.user.domain.AvatarDomain;
import com.starfit.user.domain.UserDomain;
import com.starfit.user.model.Avatar;
import com.starfit.user.model.User;

@Service
public class UserService {
	@Autowired
	private AvatarDomain characterDomain;
	@Autowired
	private UserDomain userDomain;
//	
//	@Autowired
//	private TestDomain testDomain;
	
	public ResponseEntity <List<Avatar>> getCharList() { 
		return characterDomain.getCharList();
	}
	
	public ResponseEntity <Optional<Avatar>> getCharById(Long Id) { 
		return characterDomain.getCharById(Id);
	}
	
	public ResponseEntity <String > updateChar(Avatar sampleChar) throws Exception {
		return characterDomain.updateChar(sampleChar);
	}
	
	public ResponseEntity <String > insertChar(Avatar sampleChar) throws Exception { 
		return characterDomain.insertChar(sampleChar);		
	}

	public ResponseEntity <String > deleteChar(Long Id) throws Exception { 
		return characterDomain.deleteChar(Id);
	}

	public ResponseEntity<String> insertUser(User user) throws Exception {
		ResponseEntity<List<User>> entity = userDomain.getUserList(user.getLoginId());
		if (entity.getBody().isEmpty()) {
			return userDomain.insertUser(user);
		}
		return new ResponseEntity<String> ("이미 존재하는 아이디 입니다", HttpStatus.CREATED);
	}

	public ResponseEntity<String> updateUser( User user) throws Exception {
		return userDomain.updateUser(user);
	}

	// 아이디 중복 검사
	public ResponseEntity<List<User>> getUserList(String userId) throws Exception {
		return userDomain.getUserList(userId);
	}

	public ResponseEntity<Optional<User>> getUser(Long Id) throws Exception {
		return userDomain.getUser(Id);
	}

	public ResponseEntity<Optional<User>> login(User user) {
		return userDomain.getUser(user);
	}

	public ResponseEntity<List<User>> getUserAll() {
		return userDomain.getUserAll();
	}
	
//	public ResponseEntity <String > createTestGoals(int startGoalId, int goalCount) throws Exception { 
//		return goalDomain.createTestGoals(startGoalId, goalCount);
//	}
}
