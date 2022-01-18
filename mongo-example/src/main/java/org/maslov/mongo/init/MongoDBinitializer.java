package org.maslov.mongo.init;

import lombok.extern.slf4j.Slf4j;
import org.maslov.mongo.model.User;
import org.maslov.mongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MongoDBinitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public MongoDBinitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User(1L, "John");
        userRepository.insert(user);
        Optional<User> rv = userRepository.findOne(Example.of(user));
        if (rv.isPresent()) {
            log.info("Find");
        } else {
            log.info("Not found");
        }

    }
}
