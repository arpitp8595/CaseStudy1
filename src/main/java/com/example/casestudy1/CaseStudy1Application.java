package com.example.casestudy1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CaseStudy1Application {

    public static void main(String[] args) {
        SpringApplication.run(CaseStudy1Application.class, args);
    }

//    @Bean(destroyMethod = "close")
//    public Mongo mongo() throws IOException {
//        return new EmbeddedMongoBuilder()
//                .version("2.4.5")
//                .bindIp("localhost")
//                .port(27017)
//                .build();
//    }

//    @Bean
//    @DependsOn(value = "mongo")
//    public MongoTemplate mongoTemplate() throws IOException {
//        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
//        mongo.setBindIp("localhost");
//        mongo.setPort(27017);
//        MongoClient mongoClient = mongo.getObject();
//        MongoTemplate mongoTemplate = new MongoTemplate((com.mongodb.client.MongoClient) mongoClient, "embeded_db");
//        return mongoTemplate;
//    }
}
