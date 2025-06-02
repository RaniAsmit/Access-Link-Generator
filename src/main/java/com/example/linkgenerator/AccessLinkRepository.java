package com.example.linkgenerator;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;



public interface AccessLinkRepository extends MongoRepository<AccessLink, String> {
    Optional<AccessLink> findByUrl(String url);
}