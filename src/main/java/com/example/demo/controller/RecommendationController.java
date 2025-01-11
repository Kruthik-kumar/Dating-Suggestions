package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class RecommendationController {

	@Autowired
	private RecommendationService recommendationService;

    @GetMapping("/recommendations/{userId}")
    public List<User> getRecommendations(@PathVariable Long userId, @RequestParam(defaultValue = "2") int topN) {
        return recommendationService.getTopMatches(userId, topN);
    }
}