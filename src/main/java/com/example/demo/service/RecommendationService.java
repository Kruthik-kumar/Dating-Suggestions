package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getTopMatches(Long userId, int topN) {
		// Find the current user by ID
		User currentUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		return userRepository.findAll().stream().filter(user -> !user.getId().equals(userId)) // Exclude the current
																								// user
				.sorted(Comparator.comparing((User user) -> user.getGender().equals(currentUser.getGender()) ? 0 : 1)
						.thenComparing(user -> Math.abs(user.getAge() - currentUser.getAge())) // Age difference
						.thenComparing(user -> {
							// Common interests count
							List<String> commonInterests = currentUser.getInterests().stream()
									.filter(user.getInterests()::contains).collect(Collectors.toList());
							return -commonInterests.size(); // Higher common interests = higher rank
						}))
				.limit(topN) // Limit to the top N matches
				.collect(Collectors.toList());
	}
}