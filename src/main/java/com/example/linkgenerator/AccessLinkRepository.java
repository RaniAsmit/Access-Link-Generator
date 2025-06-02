package com.example.linkgenerator;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface AccessLinkRepository extends MongoRepository<AccessLink, String> {
    Optional<AccessLink> findByUrl(String url);
}