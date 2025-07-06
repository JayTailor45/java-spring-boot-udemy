package com.jt.spring_udemy.repositories;

import com.jt.spring_udemy.models.SocialGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialGroupRepository extends JpaRepository<SocialGroup, Long> {
}
