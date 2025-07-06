package com.jt.spring_udemy.repositories;

import com.jt.spring_udemy.models.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialProfileRepository extends JpaRepository<SocialProfile, Long> {
}
