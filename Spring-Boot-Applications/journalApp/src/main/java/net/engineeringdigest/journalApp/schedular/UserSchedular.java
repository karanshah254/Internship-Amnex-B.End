package net.engineeringdigest.journalApp.schedular;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepositoryImpl;
import net.engineeringdigest.journalApp.service.EmailService;

@Component
public class UserSchedular {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepository;

    // @Scheduled(cron = "* 0 0 ? * * *")
    public void fetchUsersAndSendSAMails() {
        List<User> usersForSA = userRepository.getUsersForSentimentAnalysis();
        for (User user : usersForSA) {
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<String> filteEntries = journalEntries.stream()
                    .filter(x -> x.getData().isAfter(LocalDateTime.now().minus(7,
                            ChronoUnit.DAYS)))
                    .map(x -> x.getContent())
                    .collect(Collectors.toList());

            String entry = String.join(" ", filteEntries);
            emailService.sendEmail(user.getEmail(), "Sentiment Analysis Report", "");
        }
    }
}
