package com.starfit.user.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starfit.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByuserId(String userId);
}
