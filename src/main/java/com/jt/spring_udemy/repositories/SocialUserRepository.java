package com.jt.spring_udemy.repositories;

import com.jt.spring_udemy.models.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepository extends JpaRepository<SocialUser, Long> {
}
