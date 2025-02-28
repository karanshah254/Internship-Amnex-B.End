package net.engineeringdigest.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.engineeringdigest.journalApp.repository.UserRepository;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Disabled // to disable a test
    @Test // annotation used for testing
    public void testByAdd() {
        assertEquals(4, 2 + 1);
    }

    @Test // test if username of user is not null or exists
    @ParameterizedTest
    @ValueSource(strings = { // shows only strings can be passed
            "john", // this will pass
            "jane", // this will pass
            // "bob" // this test will fail
    })
    public void testByUsername(String username) {
        assertNotNull(userRepository.findByUsername(username));
    }

    @ParameterizedTest // test based on parameters given to function
    @CsvSource({ // passed the paramters values
            "1,1,2", // each line represent its value (a = 1, b = 1, expected = 2)
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }
}
