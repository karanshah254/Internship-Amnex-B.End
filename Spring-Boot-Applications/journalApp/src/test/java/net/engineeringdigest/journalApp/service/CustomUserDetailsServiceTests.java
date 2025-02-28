package net.engineeringdigest.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.test.context.ActiveProfiles;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;

@SpringBootTest
// @ActiveProfiles("dev") // set profile to dev
public class CustomUserDetailsServiceTests {
    @InjectMocks // inject mock test and its details
    private UserDetailsServiceImpl customUserDetailsService;

    @Mock
    private UserRepository userRepository;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTest() {
        when(userRepository.findByUsername(ArgumentMatchers.anyString()))
                .thenReturn(User.builder().username("john").password("password").roles(new ArrayList<>()).build());
        UserDetails user = customUserDetailsService.loadUserByUsername("john");
        assertNotNull(user);
    }
}
