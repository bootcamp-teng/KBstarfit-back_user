package com.starfit.user.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.starfit.user.data.AvatarRepository;
import com.starfit.user.model.Avatar;

@Service
public class AvatarDomain {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AvatarRepository sampleCharacterRepo;
	
	/*
	 * getGoalList: 목표 목록을 100개까지 리턴
	 */
	public ResponseEntity<List<Avatar>> getCharList() { 
		
		List<Avatar> list = new ArrayList<>();;

		System.out.println(list);
		try {
			log.info("Start db select");
			list = sampleCharacterRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.debug("user counts : {}", list.size());
		
		return new ResponseEntity<List<Avatar>> (list, HttpStatus.OK);
	}
	
	/*
	 * getGoalById: goalId에 해당하는 목표정보 리턴 
	 */
	public ResponseEntity <Optional<Avatar>> getCharById(Long goalId) { 
		Optional<Avatar> re = null;
		try {
			log.info("Start db select");
			re = sampleCharacterRepo.findById(goalId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Optional<Avatar>> (re, HttpStatus.OK);
	}
	
	/*
	 * updateGoal: 목표 정보 변경 
	 */
	public ResponseEntity <String > updateChar(Avatar sampleChar) throws Exception { 
		log.info("Start db update==>"+sampleChar.getId());
		Avatar re;
		Optional<Avatar> entity = sampleCharacterRepo.findById(sampleChar.getId());
		if(entity.isPresent()) {
			entity.get().setImg1(sampleChar.getImg1());
			entity.get().setImg2(sampleChar.getImg2());
			entity.get().setImg3(sampleChar.getImg3());
			entity.get().setImg4(sampleChar.getImg4());
			entity.get().setImg5(sampleChar.getImg5());
			entity.get().setName(sampleChar.getName());
			re  = sampleCharacterRepo.save(sampleChar);
		}
		
		log.debug("result :"+ "update");
		
		return new ResponseEntity<String> ("update", HttpStatus.OK);
	}

	/*
	 * insertGoal: 목표 추가 
	 */
	public ResponseEntity <String > insertChar(Avatar sampleChar) throws Exception { 
		log.info("Start db insert");
		Avatar re  = sampleCharacterRepo.save(sampleChar);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
	
	/*
	 *  deleteGoal: 목표 삭제 
	 */
	public ResponseEntity <String > deleteChar(Long Id) throws Exception { 
		log.info("Start db insert");
		sampleCharacterRepo.deleteById(Id);
		log.debug("result :"+ "delete");
		
		return new ResponseEntity<String> ("delete", HttpStatus.OK);
	}


}
