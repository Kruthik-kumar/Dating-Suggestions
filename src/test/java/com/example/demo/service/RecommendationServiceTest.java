//package com.example.demo.service;
//
//import com.example.demo.model.User;
//import com.example.demo.respository.UserRepository;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class RecommendationServiceTest {
//	  @Mock
//	    private UserRepository userRepository;
//
//	    @InjectMocks
//	    private RecommendationService recommendationService;
//
//	    private User user1, user2, user3;
//
//	    @BeforeEach
//	    public void setup() {
//	        user1 = new User("User 1", "Female", 25, Arrays.asList("Cricket", "Chess"));
//	        user2 = new User("User 2", "Male", 27, Arrays.asList("Cricket", "Football", "Movies"));
//	        user3 = new User("User 3", "Male", 26, Arrays.asList("Movies", "Tennis", "Football", "Cricket"));
//
//	        // Mock the UserRepository behavior
//	        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
//	        when(userRepository.findById(2L)).thenReturn(Optional.of(user2));
//	        when(userRepository.findById(3L)).thenReturn(Optional.of(user3));
//
//	        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2, user3));
//	    }
//
//	    @Test
//	    public void testGetTopMatches() {
//	        List<User> matches = recommendationService.getTopMatches(1L, 2);
//
//	        assertNotNull(matches);
//	        assertEquals(2, matches.size());
//	        assertEquals("User 2", matches.get(0).getName());
//	        assertEquals("User 3", matches.get(1).getName());
//	    }
//
//	    @Test
//	    public void testGetNoMatchesForNonExistentUser() {
//	        when(userRepository.findById(99L)).thenReturn(Optional.empty());
//
//	        Exception exception = assertThrows(RuntimeException.class, () -> {
//	            recommendationService.getTopMatches(99L, 2);
//	        });
//
//	        assertTrue(exception.getMessage().contains("User not found"));
//	    }
//	}