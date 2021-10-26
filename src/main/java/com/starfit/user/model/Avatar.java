package com.starfit.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter @Setter
@Table(name="Avatar")
public class Avatar {
	
	public Avatar() {
		super();
	}
	public Avatar(Long id, String name, String img1, String img2, String img3, String img4, String img5) {
		super();
		this.id = id;
		this.name = name;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 는 ai pk이다.
	private Long  id 		; // 아바타 아이디
	private String  name	; // 아바타 이름
	private String img1		; // 아바타 이미지 1
	private String img2 	; // 아바타 이미지 2
	private String img3 	; // 아바타 이미지 3
	private String img4 	; // 아바타 이미지 4
	private String img5 	; // 아바타 이미지 5
	

}
