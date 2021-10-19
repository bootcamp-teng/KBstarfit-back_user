package com.starfit.user.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.starfit.user.model.Character;
import com.starfit.user.model.User;
import com.starfit.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="User API")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/v1/char")	
	@ApiOperation(value="아바타 정보 가져오기", notes="아바타 정보를 제공합니다. ")
	public ResponseEntity<List<Character>> getCharList() { 
		return userService.getCharList();
	}
	
	@GetMapping("/v1/char/{charId}")
	@ApiOperation(value="아이디로 아바타 상세 정보 가져오기 ")
	public ResponseEntity <Optional<Character>> getCharById(
				@PathVariable (name="charId", required = true) Long charId
			) { 
		return userService.getCharById(charId);
	}
	
	@PutMapping("/v1/char/{charId}")
	@ApiOperation(value="아바타 정보 변경하기 ")
	public ResponseEntity <String > updateChar(
			@RequestBody Character sampleChar
		) throws Exception { 
		
		return userService.updateChar(sampleChar);
	}
	
	@PostMapping("/v1/char")
	@ApiOperation(value="아바타 정보 등록하기 ")
	public ResponseEntity <String > insertChar(
			@RequestBody Character sampleChar
		) throws Exception { 
		
		return userService.insertChar(sampleChar);
	}
	
	@DeleteMapping("/v1/char/{charId}")
	@ApiOperation(value="아바타 정보 삭제하기 ")
	public ResponseEntity <String > deleteGoal(
			@PathVariable(name="charId",required = true ) Long charId
		) throws Exception { 
		
		return userService.deleteChar(charId);
	}
	
	@GetMapping("/v1/usersbyid/{userId}")
	@ApiOperation(value="유저 아이디 중복 검사하기")
	public ResponseEntity <List<User>> getUserGoalList(
				@PathVariable(name="userId", required = true) String userId
			) throws Exception {
		return userService.getUserList(userId);
	}
	
	@GetMapping("/v1/user/{Id}")
	@ApiOperation(value = "유저 상세 조회")
	public ResponseEntity <Optional<User>> getUserGoal(
			@PathVariable(name="Id", required = true) Long Id
		) throws Exception {
	return userService.getUser(Id);
	}
	
	@PostMapping("/v1/user")
	@ApiOperation(value="유저 추가하기")
	public ResponseEntity<String> insertUser(
			@RequestBody User user
			) throws Exception {
			return userService.insertUser(user);
	}
	
	@PutMapping("/v1/user")
	@ApiOperation(value="유저 정보 수정하기")
	public ResponseEntity<String> updateUser(
			@RequestBody User user
			) throws Exception{
		return userService.updateUser(user);
	}
//	@GetMapping("/createtestusers/{startUserId}/{userCount}")
//	@ApiOperation(value="테스트 사용자를 userCount명 등록하기 ")
//	public ResponseEntity <String > createTestUsers(
//			@PathVariable (name="startUserId", required = true) int startUserId,
//			@PathVariable (name="userCount", required = true) int userCount
//		) throws Exception { 
//		
//		return userService.createTestUsers(startUserId, userCount);
//	}	
}
