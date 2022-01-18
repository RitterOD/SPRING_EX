package org.maslov.mongo.configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "org.maslov.mongo.repository")
public class ApplicationConfiguration {

}
