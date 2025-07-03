package com.jt.spring_udemy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class SocialGroup {
    @Id
    private String id;

    @ManyToMany(mappedBy = "groups")
    private Set<SocialUser> users = new HashSet<>();
}
