package com.starfit.user.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starfit.user.model.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

}
