package net.engineeringdigest.journalApp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import net.engineeringdigest.journalApp.entity.User;

// implementing mongotmpalte, query and criteria for user repository in database
// adds condition for based on query and criteria

public class UserRepositoryImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUsersForSentimentAnalysis() {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").exists(true)); // gives email of user if exists
        query.addCriteria(Criteria.where("email").ne(null).ne("")); // checks email is not null and empty
        query.addCriteria(Criteria.where("sentimentAnalysis").exists(true)); // check if this key has valid value
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}
