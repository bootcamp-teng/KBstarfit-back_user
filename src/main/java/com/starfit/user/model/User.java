package com.starfit.user.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@Data
@Entity(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 는 ai pk이다.
	private Long id; // 회원 아이디 (pk)
	private String loginId; // 회원 아이디(pk아님).
	private String password; // 비밀번호
	private String name; // 회원 이름
	private String starId; // 스타뱅킹 아이디
	private String phone; // 핸드폰 번호
	private Long characterId; // 캐릭터 아이디	(fk)

}
