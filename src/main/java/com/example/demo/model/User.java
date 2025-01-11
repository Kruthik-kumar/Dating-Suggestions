package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")

public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String gender;
	    private int age;

	    @ElementCollection
	    @CollectionTable(name = "user_interests", joinColumns = @JoinColumn(name = "user_id"))
	    @Column(name = "interest")
	    private List<String> interests;

	    // No-arg constructor
	    public User() {}

	    // Constructor with parameters
	    public User(String name, String gender, int age, List<String> interests) {
	        this.name = name;
	        this.gender = gender;
	        this.age = age;
	        this.interests = interests;
	    }

	    // Getters
	    public Long getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public int getAge() {
	        return age;
	    }

	    public List<String> getInterests() {
	        return interests;
	    }

	    // Setters (optional if you need them)
	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public void setInterests(List<String> interests) {
	        this.interests = interests;
	    }
	}