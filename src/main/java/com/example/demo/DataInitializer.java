package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration

public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User("User 1", "Female", 25, Arrays.asList("Cricket", "Chess")));
            userRepository.save(new User("User 2", "Male", 27, Arrays.asList("Cricket", "Football", "Movies")));
            userRepository.save(new User("User 3", "Male", 26, Arrays.asList("Movies", "Tennis", "Football", "Cricket")));
            userRepository.save(new User("User 4", "Female", 24, Arrays.asList("Tennis", "Football", "Badminton")));
            userRepository.save(new User("User 5", "Female", 32, Arrays.asList("Cricket", "Football", "Movies", "Badminton")));
        };
    }
}