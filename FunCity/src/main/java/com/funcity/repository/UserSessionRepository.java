package com.funcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.funcity.model.UserSession;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, String> {
	
	public UserSession findBySessionId(String sessionid);
	
}
