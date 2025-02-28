package net.engineeringdigest.journalApp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import net.engineeringdigest.journalApp.api.response.UserResponse;
// import net.engineeringdigest.journalApp.cache.AppCache;

@Component
public class UserServiceExternalAPI {
    @Value("{${weather.api.key}}") // from application.properties
    private static String api_key;
    private static final String api = "https://jsonplaceholder.typicode.com/users";

    @Autowired
    private RestTemplate restTemplate;

    // @Autowired
    // private AppCache appCache;

    // calling external api to get cars details
    public List<UserResponse> getUSers() { // get calls
        UserResponse[] users = restTemplate.getForObject(api, UserResponse[].class);
        return Arrays.asList(users);
    }

    // post call for an external api
    public UserResponse createUser(UserResponse user) {
        // Sending a POST request and receiving the response
        UserResponse createdUser = restTemplate.postForObject(api, user, UserResponse.class);
        return createdUser;
    }
}
