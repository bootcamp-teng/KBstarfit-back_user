package com.starfit.user.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starfit.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByLoginId(String loginId);

	Optional<User> findByLoginIdAndPassword(String loginId, String password);
}
