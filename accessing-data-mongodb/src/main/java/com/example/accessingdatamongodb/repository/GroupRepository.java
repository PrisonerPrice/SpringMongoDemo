package com.example.accessingdatamongodb.repository;

import com.example.accessingdatamongodb.domain.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {

    Group findGroupById(String id);
    Group findGroupByGroupName(String name);

}
